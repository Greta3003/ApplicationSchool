package com.example.applicationschool.common

import android.app.AlertDialog
import android.content.Context
// Objekt i vetëm (singleton) që shfaq një dritare gabimi
object ErrorDialog {
// Funksion për të shfaqur një dialog me mesazh gabimi.
    fun show(context: Context, message: String, onDismiss: (() -> Unit)? = null) {
        AlertDialog.Builder(context)  // Ndërtimi i një AlertDialog me titullin "Error" dhe mesazhin e dhënë
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->//mbyll dialogun
                dialog.dismiss()
                onDismiss?.invoke()// thërret funksionin që kalon si parametër (nëse ekziston)
            }
            .create()
            .show()
    }
}
