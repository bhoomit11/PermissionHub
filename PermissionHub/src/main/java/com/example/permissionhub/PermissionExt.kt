package com.example.permissionhub

import androidx.appcompat.widget.AppCompatTextView


fun AppCompatTextView.setAvailable(isAvailable: Boolean) {
    if (isAvailable) {
        this.alpha = 0.5f
        this.isEnabled = false
        this.text = PermissionButtonAction.ALLOWED.name
    } else {
        this.alpha = 1.0f
        this.isEnabled = true
        this.text = PermissionButtonAction.ALLOW.name
    }
}
