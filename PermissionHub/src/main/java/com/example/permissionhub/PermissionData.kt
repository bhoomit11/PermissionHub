package com.example.permissionhub

import androidx.activity.result.ActivityResultLauncher

data class PermissionData(
    var permission: PermissionName? = null,
    var permissionTitle: String = "",
    var permissionDesc: String = "",
    var permissionDeniedDesc: String = "",
)