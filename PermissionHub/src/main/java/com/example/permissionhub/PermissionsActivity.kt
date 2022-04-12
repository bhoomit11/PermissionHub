package com.example.permissionhub

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.permissionhub.databinding.ActivityPermissionsBinding
import com.example.permissionhub.databinding.ItemPermissionBinding
import com.example.permissionhub.utils.DialogUtils
import com.simpleadapter.SimpleAdapter


class PermissionsActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, PermissionsActivity::class.java)
        }
    }

    private var permissionList: ArrayList<PermissionData> = arrayListOf()
    private var adapter: SimpleAdapter<PermissionData>? = null
    private val activityResult = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        // Handle Permission granted/rejected
        permissions.entries.forEach {
            val permissionName = it.key
            val isGranted = it.value

            Log.e("Permission", "----$permissionName----> :: $isGranted")
            val position = permissionList.indexOfFirst { it.permission?.getManifestPermission() == permissionName }

            if (isGranted.not()) {
                // Permission is denied
                if (position != -1) {
                    permissionList[position].permissionButtonAction = PermissionButtonAction.DENIED
                    adapter?.notifyItemChanged(position)
                }
                if (isNeverAskAgain(permissionList[position].permission?.getManifestPermission() ?: "").not()) {
                    openSettingActivity(permissionList[position].permissionDeniedDesc)
                }
            } else {
                // Permission is granted
                if (position != -1) {
                    permissionList[position].permissionButtonAction = PermissionButtonAction.ALLOWED
                    adapter?.notifyItemChanged(position)
                }
            }
        }
    }
    lateinit var binding: ActivityPermissionsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_permissions)
        try {
            val icon: Drawable = packageManager.getApplicationIcon(packageName)

            binding.ivLogo.setImageDrawable(icon)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        val ai: ApplicationInfo? = try {
            packageManager.getApplicationInfo(this.packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }
        val applicationName = (if (ai != null) packageManager.getApplicationLabel(ai) else "App") as String
        binding.tvTitle.text = "$applicationName needs Permissions!"

        checkSkipVisibility()

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvPermission.layoutManager = LinearLayoutManager(this)

        adapter = SimpleAdapter.with<PermissionData, ItemPermissionBinding>(R.layout.item_permission) { position, model, binding ->

            val hasPermission = isGranted(model.permission?.getManifestPermission() ?: "")
            binding.tvPermissionAction.setAvailable(hasPermission)

            binding.tvTitle.text = model.permissionTitle
            binding.tvDescription.text = model.permissionDesc

        }
        binding.rvPermission.adapter = adapter

        adapter?.setClickableViews({ view, modal, position ->
            activityResult.launch(
                arrayOf(modal.permission?.getManifestPermission() ?: "")
            )

        }, R.id.tvPermissionAction)

        adapter?.clear()
        adapter?.addAll(getDummyData())
        adapter?.notifyDataSetChanged()
    }

    private fun getDummyData(): ArrayList<PermissionData> {
        permissionList = arrayListOf(
            PermissionData().apply {
                permissionTitle = "Camera"
                permissionDesc = "Please allow this permission to use media features of the app"
                permissionDeniedDesc = "Camera permission required to use the media feature, please allow it from settings!"
                permission = PermissionName.CAMERA.setCompulsion()
            },
            PermissionData().apply {
                permissionTitle = "Read External Storage"
                permissionDesc = "Please allow this permission to use media features of the app"
                permissionDeniedDesc = "Read External Storage permission required to use the media feature, please allow it from settings!"
                permission = PermissionName.READ_EXTERNAL_STORAGE.setCompulsion()
            },
            PermissionData().apply {
                permissionTitle = "Write External Storage"
                permissionDesc = "Please allow this permission to use media features of the app"
                permissionDeniedDesc = "Write External Storage permission required to use the media feature, please allow it from settings!"
                permission = PermissionName.WRITE_EXTERNAL_STORAGE
            },
            PermissionData().apply {
                permissionTitle = "Record Audio"
                permissionDesc = "Please allow this permission to use microphone feature of your app"
                permissionDeniedDesc = "Record Audio permission required to use microphone feature, please allow it from settings!"
                permission = PermissionName.RECORD_AUDIO.setCompulsion()
            }
        )

        return permissionList
    }

    private fun openSettingActivity(permissionDeniedDesc: String?) {
        DialogUtils.showSimpleDialog(
            activity = this@PermissionsActivity,
            title = getString(R.string.permission_required),
            message = permissionDeniedDesc ?: "",
            isCancellable = true,
            yesText = getString(R.string.settings),
            yesCallback = {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            },
            noText = getString(R.string.cancel)
        )

    }


    override fun onResume() {
        super.onResume()
        checkSkipVisibility()
        if (permissionList.isNotEmpty()) {
            var index = 0
            permissionList.forEach {
                val hasPermission = isGranted(it.permission?.getManifestPermission() ?: "")
                if (hasPermission) {
                    index++
                }
            }
            if (index == permissionList.size) {
                finish()
            } else {

            }
        }
    }

    private fun isGranted(permission: String): Boolean {
        return ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun isNeverAskAgain(permission: String): Boolean {
        return isGranted(permission).not() && ActivityCompat.shouldShowRequestPermissionRationale(this, permission)
    }

    override fun onBackPressed() {

    }

    private fun checkSkipVisibility() {
        var compulsionFlagCount = 0

        val list = permissionList.filter { it.permission?.getCompulsion() == true }
        if (list.isNotEmpty()) {
            list.forEach {
                if (isGranted(it.permission?.getManifestPermission() ?: "")) {
                    compulsionFlagCount++
                }
            }
        }
        if (compulsionFlagCount == list.size) {
            binding.tvSKip.visibility = View.VISIBLE
        } else {
            binding.tvSKip.visibility = View.GONE
        }
    }

}

