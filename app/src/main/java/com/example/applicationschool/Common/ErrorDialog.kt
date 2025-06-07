package com.example.applicationschool.common

import android.app.AlertDialog
import android.content.Context

object ErrorDialog {

    fun show(context: Context, message: String, onDismiss: (() -> Unit)? = null) {
        AlertDialog.Builder(context)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                onDismiss?.invoke()
            }
            .create()
            .show()
    }
}
