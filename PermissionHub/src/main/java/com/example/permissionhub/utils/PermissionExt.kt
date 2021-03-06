package com.example.permissionhub

import android.app.Activity
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import java.util.*


fun AppCompatTextView.setAvailable(isAvailable: Boolean) {
    if (isAvailable) {
        this.alpha = 0.5f
        this.isEnabled = false
        this.text = PermissionButtonAction.ALLOWED.name.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    } else {
        this.alpha = 1.0f
        this.isEnabled = true
        this.text = PermissionButtonAction.ALLOW.name.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }
}

fun <T> Fragment.getFromArgument(key: String, defaultValue: T): T {
    if (arguments != null && arguments?.containsKey(key) == true) {
        return arguments!!.get(key) as T
    }
    return defaultValue
}

fun <T> Activity.getFromIntent(key: String, defaultValue: T): T {
    if (intent.extras != null && intent.extras?.containsKey(key) == true) {
        return intent.extras!!.get(key) as T
    }
    return defaultValue
}