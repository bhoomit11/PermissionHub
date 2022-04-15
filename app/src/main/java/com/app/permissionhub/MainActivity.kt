package com.app.permissionhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.permissionhub.PermissionConfig
import com.example.permissionhub.PermissionHub
import com.example.permissionhub.PermissionName

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PermissionHub.start(
            activity = this,
            permissionConfig = getPermissionConfig()
        )
    }

    private fun getPermissionConfig(): ArrayList<PermissionConfig> {
        return arrayListOf(
            PermissionConfig.get().permission(PermissionName.CAMERA.setRequired()) // add setRequired if permission is must required for your App
                .title(getString(R.string.permission_camera_title)) // Add permission title to be showed up on permission screen
                .description(getString(R.string.permission_camera_desc)) // Add permission desc to be showed up on permission screen
                .afterDeniedDescription(getString(R.string.permission_camera_after_deny_desc)), // Add permission desc to be showed up after permission is denied permanently from user
            PermissionConfig.get().permission(PermissionName.ACCESS_FINE_LOCATION)// add setRequired if permission is must required for your App
                .title(getString(R.string.permission_location_title))// Add permission title to be showed up on permission screen
                .description(getString(R.string.permission_location_desc))// Add permission desc to be showed up on permission screen
                .afterDeniedDescription(getString(R.string.permission_location_after_deny_desc)), // Add permission desc to be showed up after permission is denied permanently from user
            PermissionConfig.get().permission(PermissionName.RECORD_AUDIO)// add setRequired if permission is must required for your App
                .title(getString(R.string.permission_record_title))// Add permission title to be showed up on permission screen
                .description(getString(R.string.permission_record_desc))// Add permission desc to be showed up on permission screen
                .afterDeniedDescription(getString(R.string.permission_record_after_deny_desc)), // Add permission desc to be showed up after permission is denied permanently from user

        )
    }
}