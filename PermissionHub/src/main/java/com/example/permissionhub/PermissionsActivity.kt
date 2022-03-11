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
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.permissionhub.databinding.ActivityPermissionsBinding
import com.example.permissionhub.databinding.ItemPermissionBinding
import com.simpleadapter.SimpleAdapter


class PermissionsActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, PermissionsActivity::class.java)
        }
    }

    private var selectedModal: PermissionData? = null
    private var adapter: SimpleAdapter<PermissionData>? = null
    private val activityResult = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted.not()) {
            if (shouldShowRequestPermissionRationale(selectedModal?.permission?.getManifestPermission() ?: "").not()) {
                openSettingActivity()
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

        setupRecyclerView()

//        binding.pvCamera.setActionListener {
//            cameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
//        }
//
//        binding.pvMicrophone.setActionListener {
//            microphonePermissionLauncher.launch(android.Manifest.permission.RECORD_AUDIO)
//        }
//
//        binding.pvOverlay.setActionListener {
//            val intent = Intent(
//                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                Uri.parse("package:${packageName}")
//            )
//            startActivity(intent)
//        }
//        binding.tvSKip.setOnClickListener {
//            finish()
//        }
    }

    private fun setupRecyclerView() {
        binding.rvPermission.layoutManager = LinearLayoutManager(this)

        adapter = SimpleAdapter.with<PermissionData, ItemPermissionBinding>(R.layout.item_permission) { position, model, binding ->
            binding.tvMicAction.text = "Allow"
            binding.tvTitle.text = model.permissionTitle
            binding.tvDescription.text = model.permissionDesc
        }
        binding.rvPermission.adapter = adapter

        adapter?.setClickableViews({ view, modal, position ->
            selectedModal = modal
            activityResult.launch(selectedModal?.permission?.getManifestPermission() ?: "")
        }, R.id.tvMicAction)

        adapter?.clear()
        adapter?.addAll(getDummyData())
        adapter?.notifyDataSetChanged()
    }

    private fun getDummyData(): ArrayList<PermissionData> {
        return arrayListOf(
            PermissionData().apply {
                permissionTitle = "Camera"
                permissionDesc = "Please allow camera permission to user media features of the app"
                permissionDeniedDesc = "Camera permission required to use the media feature, please allow it from settings!"
                permission = PermissionName.CAMERA.setCompulsion()
            },
            PermissionData().apply {
                permissionTitle = "External Storage"
                permissionDesc = "Please allow External Storage to user media features of the app"
                permissionDeniedDesc = "External Storage permission required to use the media feature, please allow it from settings!"
                permission = PermissionName.WRITE_EXTERNAL_STORAGE.setCompulsion()
            }
        )
    }

    private fun openSettingActivity() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        startActivity(intent)
    }


    override fun onResume() {
        super.onResume()

        val hasCameraPermission = isGranted(android.Manifest.permission.CAMERA)
        val hasMicPermission = isGranted(android.Manifest.permission.RECORD_AUDIO)
        val hasOverlayPermission = Settings.canDrawOverlays(this)

//        binding.pvOverlay.setAvailable(hasOverlayPermission)
//        binding.pvMicrophone.setAvailable(hasMicPermission)
//        binding.pvCamera.setAvailable(hasCameraPermission)

        if (hasCameraPermission && hasMicPermission && hasOverlayPermission) {
            finish()
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
}