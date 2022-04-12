package com.example.permissionhub.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.DialogFragment

object DialogUtils {

    fun showSimpleDialog(
        activity: Activity,
        title: String,
        message: String,
        isCancellable: Boolean = true,
        yesText: String,
        yesCallback: (dialog: DialogInterface) -> Unit,
        noText: String = "",
        noCallback: (dialog: DialogInterface) -> Unit = {},
    ) {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(message)
            .setTitle(title)
            .setCancelable(isCancellable)
            .setPositiveButton(yesText) { dialog, id ->
                dialog.dismiss()
                yesCallback.invoke(dialog)
            }
        if (noText.isNotEmpty()) {
            builder.setNegativeButton(noText) { dialog, id ->
                dialog.dismiss()
                noCallback.invoke(dialog)
            }
        }
        builder.create().apply {
            show()
        }
    }
}