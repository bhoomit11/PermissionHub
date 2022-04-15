package com.example.permissionhub

import android.app.Activity

object PermissionHub {
    fun start(activity: Activity, permissionConfig: ArrayList<PermissionConfig> = arrayListOf()) {
        activity.startActivity(PermissionsActivity.createIntent(activity, permissionConfig))
    }
}

