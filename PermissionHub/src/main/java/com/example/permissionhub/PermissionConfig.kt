package com.example.permissionhub

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class PermissionConfig() : Parcelable {

    // Required Params
    var permission: PermissionName? = null
    var permissionTitle: String = ""
    var permissionDesc: String = ""
    var permissionAfterDeniedDesc: String = ""
    var permissionIconResource: Int = -1
    var iconThemeColorResource: Int = -1

    // Library internal Params
    var isDenied: Boolean = false
    var permissionButtonAction: PermissionButtonAction = PermissionButtonAction.ALLOW

    constructor(parcel: Parcel) : this() {
        permission = parcel.readSerializable() as PermissionName
        permissionTitle = parcel.readString().toString()
        permissionDesc = parcel.readString().toString()
        permissionAfterDeniedDesc = parcel.readString().toString()
        permissionIconResource = parcel.readInt()
        iconThemeColorResource = parcel.readInt()
        isDenied = parcel.readByte() != 0.toByte()
    }


    fun permission(permission: PermissionName): PermissionConfig {
        this.permission = permission
        return this
    }

    fun title(permissionTitle: String): PermissionConfig {
        this.permissionTitle = permissionTitle
        return this
    }

    fun description(permissionDesc: String): PermissionConfig {
        this.permissionDesc = permissionDesc
        return this
    }

    fun afterDeniedDescription(permissionAfterDeniedDesc: String): PermissionConfig {
        this.permissionAfterDeniedDesc = permissionAfterDeniedDesc
        return this
    }

    fun iconResource(permissionIconResource: Int): PermissionConfig {
        this.permissionIconResource = permissionIconResource
        return this
    }

    fun iconColorResource(iconThemeColorResource: Int): PermissionConfig {
        this.iconThemeColorResource = iconThemeColorResource
        return this
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeSerializable(permission)
        parcel.writeString(permissionTitle)
        parcel.writeString(permissionDesc)
        parcel.writeString(permissionAfterDeniedDesc)
        parcel.writeInt(permissionIconResource)
        parcel.writeInt(iconThemeColorResource)
        parcel.writeByte(if (isDenied) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PermissionConfig> {
        fun get(): PermissionConfig {
            return PermissionConfig()
        }

        override fun createFromParcel(parcel: Parcel): PermissionConfig {
            return PermissionConfig(parcel)
        }

        override fun newArray(size: Int): Array<PermissionConfig?> {
            return arrayOfNulls(size)
        }
    }
}
