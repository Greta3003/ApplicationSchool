package com.example.applicationschool.common

import android.view.View
import android.widget.ProgressBar
// Objekt i vetëm (singleton) për menaxhimin e një ProgressBar-i
object LoadingSpinner {
    // Funksion për të shfaqur spinner-in
    fun show(progressBar: ProgressBar) {
        progressBar.visibility = View.VISIBLE
    }
    // Vendos komponentin në gjendjen e dukshme (VISIBLE)
    fun hide(progressBar: ProgressBar) {
        progressBar.visibility = View.GONE
    }
}
