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

            PermissionConfig.instance
                .permission(PermissionName.CAMERA.setRequired()) // add setRequired if permission is must required for your App
                .title("Camera") // Add permission title to be showed up on permission screen
                .description("Please allow this permission to use media features of the app") // Add permission desc to be showed up on permission screen
                .afterDeniedDescription("Camera permission required to use the media feature, please allow it from settings!"), // Add permission desc to be showed up after permission is denied permanently from user

            PermissionConfig.instance
                .permission(PermissionName.ACCESS_FINE_LOCATION)
                .title("Location")
                .description("Please allow this permission to use location features of the app")
                .afterDeniedDescription("Location permission required to use location features of the app, please allow it from settings!")
        )
    }
}