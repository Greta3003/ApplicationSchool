package com.example.applicationschool.common

import android.view.View
import android.widget.ProgressBar

object LoadingSpinner {

    fun show(progressBar: ProgressBar) {
        progressBar.visibility = View.VISIBLE
    }

    fun hide(progressBar: ProgressBar) {
        progressBar.visibility = View.GONE
    }
}
