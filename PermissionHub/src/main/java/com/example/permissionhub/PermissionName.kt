package com.example.permissionhub

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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_location
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_location
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_voicemail
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_directions
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_call
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_camera
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_person
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_calendar
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_perm_phone
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_person
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_storage
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_call
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_sms
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_mms
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_sms
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
        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_sms
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
        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_mic_none
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
        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_sms
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

        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_call
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
        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_calendar
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
        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_perm_phone
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
        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_person
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
        override fun getPermissionIconResource(): Int {
            return R.drawable.ic_outline_call
        }
    };

    abstract fun getManifestPermission(): String
    open fun getPermissionIconResource(): Int {
        return -1
    }

    abstract fun setRequired(): PermissionName
    abstract fun getRequired(): Boolean
    protected var compulsionFlagValue = false
}
