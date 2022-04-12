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

    private fun getPermissionConfig(): ArrayList<PermissionData> {
        return arrayListOf(
            PermissionData().apply {
                permissionTitle = "Camera"
                permissionDesc = "Please allow this permission to use media features of the app"
                permissionAfterDeniedDesc = "Camera permission required to use the media feature, please allow it from settings!"
                permission = PermissionName.CAMERA.setCompulsion()
            },
            PermissionData().apply {
                permissionTitle = "Read External Storage"
                permissionDesc = "Please allow this permission to use media features of the app"
                permissionAfterDeniedDesc = "Read External Storage permission required to use the media feature, please allow it from settings!"
                permission = PermissionName.READ_EXTERNAL_STORAGE.setCompulsion()
            },
            PermissionData().apply {
                permissionTitle = "Write External Storage"
                permissionDesc = "Please allow this permission to use media features of the app"
                permissionAfterDeniedDesc = "Write External Storage permission required to use the media feature, please allow it from settings!"
                permission = PermissionName.WRITE_EXTERNAL_STORAGE
            },
            PermissionData().apply {
                permissionTitle = "Record Audio"
                permissionDesc = "Please allow this permission to use microphone feature of your app"
                permissionAfterDeniedDesc = "Record Audio permission required to use microphone feature, please allow it from settings!"
                permission = PermissionName.RECORD_AUDIO.setCompulsion()
            }
        )
    }
}