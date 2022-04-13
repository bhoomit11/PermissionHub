package com.example.permissionhub

import android.app.Activity
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

object PermissionHub {
    fun start(activity: Activity, permissionConfig: ArrayList<PermissionConfig> = arrayListOf()) {
        activity.startActivity(PermissionsActivity.createIntent(activity, permissionConfig))
    }
}

