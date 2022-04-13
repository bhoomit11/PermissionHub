package com.example.permissionhub

import android.os.Parcelable
import java.io.Serializable

enum class PermissionName {

    ACCESS_COARSE_LOCATION {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_COARSE_LOCATION
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_COARSE_LOCATION
        }
    },
    ACCESS_FINE_LOCATION {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_FINE_LOCATION
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_FINE_LOCATION
        }
    },
    ADD_VOICEMAIL {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ADD_VOICEMAIL
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@ADD_VOICEMAIL
        }
    },
    BODY_SENSORS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.BODY_SENSORS
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@BODY_SENSORS
        }
    },
    CALL_PHONE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.CALL_PHONE
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@CALL_PHONE
        }
    },
    CAMERA {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.CAMERA
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@CAMERA
        }
    },
    GET_ACCOUNTS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.GET_ACCOUNTS
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@GET_ACCOUNTS
        }
    },
    PROCESS_OUTGOING_CALLS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.PROCESS_OUTGOING_CALLS
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@PROCESS_OUTGOING_CALLS
        }
    },
    READ_CALENDAR {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_CALENDAR
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@READ_CALENDAR
        }
    },
    READ_CALL_LOG {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_CALL_LOG
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@READ_CALL_LOG
        }
    },
    READ_CONTACTS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_CONTACTS
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@READ_CONTACTS
        }
    },
    READ_EXTERNAL_STORAGE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_EXTERNAL_STORAGE
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@READ_EXTERNAL_STORAGE
        }
    },
    READ_PHONE_STATE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_PHONE_STATE
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@READ_PHONE_STATE
        }
    },
    READ_SMS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_SMS
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@READ_SMS
        }
    },
    RECEIVE_MMS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.RECEIVE_MMS
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@RECEIVE_MMS
        }
    },
    RECEIVE_SMS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.RECEIVE_SMS
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@RECEIVE_SMS
        }
    },
    RECEIVE_WAP_PUSH {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.RECEIVE_WAP_PUSH
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@RECEIVE_WAP_PUSH
        }
    },
    RECORD_AUDIO {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.RECORD_AUDIO
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@RECORD_AUDIO
        }
    },
    SEND_SMS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.SEND_SMS
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@SEND_SMS
        }
    },
    USE_SIP {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.USE_SIP
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@USE_SIP
        }
    },
    WRITE_CALENDAR {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WRITE_CALENDAR
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@WRITE_CALENDAR
        }
    },
    WRITE_CALL_LOG {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WRITE_CALL_LOG
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@WRITE_CALL_LOG
        }
    },
    WRITE_CONTACTS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WRITE_CONTACTS
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@WRITE_CONTACTS
        }
    },
    WRITE_EXTERNAL_STORAGE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        }

        override fun getRequired(): Boolean {
            return compulsionFlagValue
        }

        override fun setRequired(): PermissionName {
            compulsionFlagValue = true
            return this@WRITE_EXTERNAL_STORAGE
        }
    };

    abstract fun getManifestPermission(): String
    abstract fun setRequired(): PermissionName
    abstract fun getRequired(): Boolean
    protected var compulsionFlagValue = false
}
