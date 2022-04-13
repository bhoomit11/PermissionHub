package com.example.permissionhub

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.permissionhub.databinding.ActivityPermissionsBinding
import com.example.permissionhub.databinding.ItemPermissionBinding
import com.example.permissionhub.utils.DialogUtils
import com.simpleadapter.SimpleAdapter


class PermissionsActivity : AppCompatActivity() {

    companion object {
        private const val PERMISSION_LIST = "PERMISSION_LIST"
        private const val ANDROID = "android"
        fun createIntent(context: Context, permissionList: ArrayList<PermissionConfig>): Intent {
            return Intent(context, PermissionsActivity::class.java).apply {
                putParcelableArrayListExtra(PERMISSION_LIST, permissionList)
            }
        }
    }

    private val permissionList by lazy {
        getFromIntent<ArrayList<PermissionConfig>>(PERMISSION_LIST, arrayListOf())
    }
    private var adapter: SimpleAdapter<PermissionConfig>? = null


    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
    var settingsActivityResultLauncher = registerForActivityResult(
        StartActivityForResult()
    ) { _ ->
        addDataToAdapter()
    }

    private val activityResult = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        // Handle Permission granted/rejected
        permissions.entries.forEach {
            val permissionName = it.key
            val isGranted = it.value

            Log.e("Permission", "----$permissionName----> :: $isGranted")
            val position = permissionList.indexOfFirst { it.permission?.getManifestPermission() == permissionName }
            val permissionModal = permissionList[position]
            if (isGranted.not()) {
                // Permission is denied
                if (position != -1) {
                    permissionModal.permissionButtonAction = PermissionButtonAction.DENIED
                    permissionModal.isDenied = true
                    adapter?.notifyItemChanged(position)
                }
                if (isNeverAskAgain(permissionList[position].permission?.getManifestPermission() ?: "").not()) {
                    openSettingActivity(permissionList[position].permissionAfterDeniedDesc)
                }
            } else {
                // Permission is granted
                if (position != -1) {
                    permissionModal.permissionButtonAction = PermissionButtonAction.ALLOWED
                    permissionModal.isDenied = false
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
        val applicationName = (if (ai != null) packageManager.getApplicationLabel(ai) else getString(R.string.app)) as String
        binding.tvTitle.text = "$applicationName needs Permissions!"

        checkSkipVisibility()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvPermission.layoutManager = LinearLayoutManager(this)

        adapter = SimpleAdapter.with<PermissionConfig, ItemPermissionBinding>(R.layout.item_permission) { position, model, binding ->
            val hasPermission = isGranted(model.permission?.getManifestPermission() ?: "")
            binding.tvPermissionAction.setAvailable(hasPermission)
            binding.tvDeniedText.visibility = if (model.isDenied && !hasPermission) View.VISIBLE else View.GONE
            binding.tvTitle.text = model.permissionTitle
            binding.tvDescription.text = model.permissionDesc
            binding.ivPermissionIcon.setImageResource(getPermissionDrawable(model.permission?.getManifestPermission() ?: ""))
        }

        binding.rvPermission.adapter = adapter

        adapter?.setClickableViews({ view, modal, position ->
            activityResult.launch(
                arrayOf(modal.permission?.getManifestPermission() ?: "")
            )

        }, R.id.tvPermissionAction)

        addDataToAdapter()
    }

    private fun addDataToAdapter() {
        adapter?.clear()
        adapter?.addAll(permissionList)
        adapter?.notifyDataSetChanged()
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
                settingsActivityResultLauncher.launch(intent);
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

        val list = permissionList.filter { it.permission?.getRequired() == true }
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

    @Nullable
    private fun getPermissionDrawable(permission: String): Int {
        var drawable: Int? = -1
        try {
            val info = packageManager.getPermissionInfo(permission, PackageManager.GET_META_DATA)
            drawable = info.icon
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        } catch (e: Resources.NotFoundException) {
            e.printStackTrace()
        }
        return drawable ?: -1
    }

}

