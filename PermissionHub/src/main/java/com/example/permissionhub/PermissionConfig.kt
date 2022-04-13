package com.example.permissionhub

import android.os.Parcel
import android.os.Parcelable

class PermissionConfig() : Parcelable {

    // Required Params
    var permission: PermissionName? = null
    var permissionTitle: String = ""
    var permissionDesc: String = ""
    var permissionAfterDeniedDesc: String = ""

    // Library internal Params
    var isDenied: Boolean = false
    var permissionButtonAction: PermissionButtonAction = PermissionButtonAction.ALLOW

    constructor(parcel: Parcel) : this() {
        permissionTitle = parcel.readString().toString()
        permissionDesc = parcel.readString().toString()
        permissionAfterDeniedDesc = parcel.readString().toString()
        isDenied = parcel.readByte() != 0.toByte()
    }

    fun permission(permission: PermissionName): PermissionConfig {
        this.permission = permission
        return instance
    }

    fun title(permissionTitle: String): PermissionConfig {
        this.permissionTitle = permissionTitle
        return instance
    }

    fun description(permissionDesc: String): PermissionConfig {
        this.permissionDesc = permissionDesc
        return instance
    }

    fun afterDeniedDescription(permissionAfterDeniedDesc: String): PermissionConfig {
        this.permissionAfterDeniedDesc = permissionAfterDeniedDesc
        return instance
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(permissionTitle)
        parcel.writeString(permissionDesc)
        parcel.writeString(permissionAfterDeniedDesc)
        parcel.writeByte(if (isDenied) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PermissionConfig> {
        val instance: PermissionConfig
            get() = PermissionConfig()

        override fun createFromParcel(parcel: Parcel): PermissionConfig {
            return PermissionConfig(parcel)
        }

        override fun newArray(size: Int): Array<PermissionConfig?> {
            return arrayOfNulls(size)
        }
    }
}
