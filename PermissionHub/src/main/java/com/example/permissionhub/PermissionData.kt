package com.example.permissionhub

import android.app.Activity
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

object PermissionHub {
    fun start(activity: Activity, permissionConfig: ArrayList<PermissionData> = arrayListOf()) {
        activity.startActivity(PermissionsActivity.createIntent(activity, permissionConfig))
    }
}

@Parcelize
data class PermissionData(
    var permission: PermissionName? = null,
    var permissionTitle: String = "",
    var permissionDesc: String = "",
    var permissionAfterDeniedDesc: String = "",
    var permissionButtonAction: PermissionButtonAction = PermissionButtonAction.ALLOW,
) : Parcelable

enum class PermissionButtonAction {
    ALLOW,
    ALLOWED,
    DENIED
}