package com.example.permissionhub

enum class PermissionName {
    ACCESS_LOCATION_EXTRA_COMMANDS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_LOCATION_EXTRA_COMMANDS
        }
    },
    ACCESS_NETWORK_STATE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_NETWORK_STATE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_NETWORK_STATE
        }
    },
    ACCESS_NOTIFICATION_POLICY {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_NOTIFICATION_POLICY
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_NOTIFICATION_POLICY
        }
    },
    ACCESS_WIFI_STATE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_WIFI_STATE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_WIFI_STATE
        }
    },
    BLUETOOTH {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.BLUETOOTH
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@BLUETOOTH
        }
    },
    BLUETOOTH_ADMIN {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.BLUETOOTH_ADMIN
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@BLUETOOTH_ADMIN
        }
    },
    BROADCAST_STICKY {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.BROADCAST_STICKY
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@BROADCAST_STICKY
        }
    },
    CHANGE_NETWORK_STATE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.CHANGE_NETWORK_STATE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@CHANGE_NETWORK_STATE
        }
    },
    CHANGE_WIFI_MULTICAST_STATE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.CHANGE_WIFI_MULTICAST_STATE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@CHANGE_WIFI_MULTICAST_STATE
        }
    },
    CHANGE_WIFI_STATE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.CHANGE_WIFI_STATE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@CHANGE_WIFI_STATE
        }
    },
    DISABLE_KEYGUARD {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.DISABLE_KEYGUARD
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@DISABLE_KEYGUARD
        }
    },
    EXPAND_STATUS_BAR {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.EXPAND_STATUS_BAR
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@EXPAND_STATUS_BAR
        }
    },
    GET_PACKAGE_SIZE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.GET_PACKAGE_SIZE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@GET_PACKAGE_SIZE
        }
    },
    INSTALL_SHORTCUT {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.INSTALL_SHORTCUT
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@INSTALL_SHORTCUT
        }
    },
    INTERNET {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.INTERNET
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@INTERNET
        }
    },
    KILL_BACKGROUND_PROCESSES {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.KILL_BACKGROUND_PROCESSES
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@KILL_BACKGROUND_PROCESSES
        }
    },
    MODIFY_AUDIO_SETTINGS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.MODIFY_AUDIO_SETTINGS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@MODIFY_AUDIO_SETTINGS
        }
    },
    NFC {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.NFC
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@NFC
        }
    },
    READ_SYNC_SETTINGS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_SYNC_SETTINGS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@READ_SYNC_SETTINGS
        }
    },
    READ_SYNC_STATS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_SYNC_STATS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@READ_SYNC_STATS
        }
    },
    RECEIVE_BOOT_COMPLETED {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.RECEIVE_BOOT_COMPLETED
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@RECEIVE_BOOT_COMPLETED
        }
    },
    REORDER_TASKS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.REORDER_TASKS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@REORDER_TASKS
        }
    },
    REQUEST_IGNORE_BATTERY_OPTIMIZATIONS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
        }
    },
    REQUEST_INSTALL_PACKAGES {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.REQUEST_INSTALL_PACKAGES
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@REQUEST_INSTALL_PACKAGES
        }
    },
    SET_ALARM {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.SET_ALARM
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@SET_ALARM
        }
    },
    SET_TIME_ZONE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.SET_TIME_ZONE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@SET_TIME_ZONE
        }
    },
    SET_WALLPAPER {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.SET_WALLPAPER
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@SET_WALLPAPER
        }
    },
    SET_WALLPAPER_HINTS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.SET_WALLPAPER_HINTS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@SET_WALLPAPER_HINTS
        }
    },
    TRANSMIT_IR {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.TRANSMIT_IR
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@TRANSMIT_IR
        }
    },
    UNINSTALL_SHORTCUT {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.UNINSTALL_SHORTCUT
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@UNINSTALL_SHORTCUT
        }
    },
    USE_FINGERPRINT {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.USE_FINGERPRINT
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@USE_FINGERPRINT
        }
    },
    VIBRATE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.VIBRATE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@VIBRATE
        }
    },
    WAKE_LOCK {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WAKE_LOCK
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@WAKE_LOCK
        }
    },
    WRITE_SYNC_SETTINGS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WRITE_SYNC_SETTINGS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@WRITE_SYNC_SETTINGS
        }
    },
    READ_CALENDAR {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_CALENDAR
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@READ_CALENDAR
        }
    },
    WRITE_CALENDAR {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WRITE_CALENDAR
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@WRITE_CALENDAR
        }
    },
    CAMERA {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.CAMERA
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@CAMERA
        }
    },
    READ_CONTACTS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_CONTACTS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@READ_CONTACTS
        }
    },
    WRITE_CONTACTS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WRITE_CONTACTS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@WRITE_CONTACTS
        }
    },
    GET_ACCOUNTS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.GET_ACCOUNTS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@GET_ACCOUNTS
        }
    },
    ACCESS_FINE_LOCATION {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_FINE_LOCATION
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_FINE_LOCATION
        }
    },
    ACCESS_COARSE_LOCATION {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_COARSE_LOCATION
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_COARSE_LOCATION
        }
    },
    RECORD_AUDIO {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.RECORD_AUDIO
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@RECORD_AUDIO
        }
    },
    READ_PHONE_STATE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_PHONE_STATE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@READ_PHONE_STATE
        }
    },
    READ_PHONE_NUMBERS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_PHONE_NUMBERS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@READ_PHONE_NUMBERS
        }
    },
    CALL_PHONE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.CALL_PHONE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@CALL_PHONE
        }
    },
    ANSWER_PHONE_CALLS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ANSWER_PHONE_CALLS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ANSWER_PHONE_CALLS
        }
    },
    READ_CALL_LOG {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_CALL_LOG
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@READ_CALL_LOG
        }
    },
    WRITE_CALL_LOG {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WRITE_CALL_LOG
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@WRITE_CALL_LOG
        }
    },
    ADD_VOICEMAIL {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ADD_VOICEMAIL
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ADD_VOICEMAIL
        }
    },
    USE_SIP {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.USE_SIP
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@USE_SIP
        }
    },
    PROCESS_OUTGOING_CALLS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.PROCESS_OUTGOING_CALLS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@PROCESS_OUTGOING_CALLS
        }
    },
    BODY_SENSORS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.BODY_SENSORS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@BODY_SENSORS
        }
    },
    SEND_SMS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.SEND_SMS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@SEND_SMS
        }
    },
    RECEIVE_SMS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.RECEIVE_SMS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@RECEIVE_SMS
        }
    },
    READ_SMS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_SMS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@READ_SMS
        }
    },
    RECEIVE_WAP_PUSH {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.RECEIVE_WAP_PUSH
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@RECEIVE_WAP_PUSH
        }
    },
    RECEIVE_MMS {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.RECEIVE_MMS
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@RECEIVE_MMS
        }
    },
    READ_EXTERNAL_STORAGE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.READ_EXTERNAL_STORAGE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@READ_EXTERNAL_STORAGE
        }
    },
    WRITE_EXTERNAL_STORAGE {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@WRITE_EXTERNAL_STORAGE
        }
    },
    ACCESS_MEDIA_LOCATION {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_MEDIA_LOCATION
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_MEDIA_LOCATION
        }
    },
    ACCEPT_HANDOVER {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCEPT_HANDOVER
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACCEPT_HANDOVER
        }
    },
    ACCESS_BACKGROUND_LOCATION {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACCESS_BACKGROUND_LOCATION
        }
    },
    ACTIVITY_RECOGNITION {
        override fun getManifestPermission(): String {
            return android.Manifest.permission.ACTIVITY_RECOGNITION
        }

        override fun getCompulsion(): Boolean {
            return compulsionFlagValue
        }
        override fun setCompulsion(): PermissionName {
            compulsionFlagValue = true
            return this@ACTIVITY_RECOGNITION
        }
    };

    abstract fun getManifestPermission(): String
    abstract fun setCompulsion(): PermissionName
    abstract fun getCompulsion(): Boolean
    protected var compulsionFlagValue = false
}

class PermissionEnum {
    fun abc() {
        var a = PermissionName.ACTIVITY_RECOGNITION.setCompulsion()
    }
}