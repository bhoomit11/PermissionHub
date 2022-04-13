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
            PermissionConfig.instance.permission(PermissionName.CAMERA.setRequired()) // add setRequired if permission is must required for your App
                .title(getString(R.string.permission_camera_title)) // Add permission title to be showed up on permission screen
                .description(getString(R.string.permission_camera_desc)) // Add permission desc to be showed up on permission screen
                .afterDeniedDescription(getString(R.string.permission_camera_after_deny_desc)), // Add permission desc to be showed up after permission is denied permanently from user

            PermissionConfig.instance.permission(PermissionName.ACCESS_FINE_LOCATION)// add setRequired if permission is must required for your App
                .title(getString(R.string.permission_location_title))// Add permission title to be showed up on permission screen
                .description(getString(R.string.permission_location_desc))// Add permission desc to be showed up on permission screen
                .afterDeniedDescription(getString(R.string.permission_location_after_deny_desc))// Add permission desc to be showed up after permission is denied permanently from user
        )
    }
}