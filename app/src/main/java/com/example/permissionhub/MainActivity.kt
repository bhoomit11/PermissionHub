package com.example.permissionhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PermissionHub.start(
            activity = this@MainActivity,
            permissionConfig = getPermissionConfig()
        )
    }

    private fun getPermissionConfig(): ArrayList<PermissionConfig> {
        return arrayListOf(
            PermissionConfig.get().permission(PermissionName.CAMERA.setRequired()) // add setRequired if permission is must required for your App
                .title(getString(R.string.permission_camera_title)) // Add permission title to be showed up on permission screen
                .description(getString(R.string.permission_camera_desc)) // Add permission desc to be showed up on permission screen
                .afterDeniedDescription(getString(R.string.permission_camera_after_deny_desc)) // Add permission desc to be showed up after permission is denied permanently from user
                .iconResource(android.R.drawable.ic_dialog_alert) // Add permission icon to be showed up on permission screen (Optional, library provides own icons as well)
                .iconColorResource(android.R.color.black), // Add permission icon color tint to showed up on permission screen (Optional, library will fetch your app theme accent color by default)


            PermissionConfig.get().permission(PermissionName.ACCESS_FINE_LOCATION)// add setRequired if permission is must required for your App
                .title(getString(R.string.permission_location_title))// Add permission title to be showed up on permission screen
                .description(getString(R.string.permission_location_desc))// Add permission desc to be showed up on permission screen
                .afterDeniedDescription(getString(R.string.permission_location_after_deny_desc))// Add permission desc to be showed up after permission is denied permanently from user
        )
    }
}