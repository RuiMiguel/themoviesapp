package com.gigigo.themoviesapp.base.ui.utils.extensions

import android.graphics.Color
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.gigigo.themoviesapp.base.R
import com.google.android.material.snackbar.Snackbar

fun View.snackbar(message: CharSequence, actionText: String = "", action: (View) -> Unit = {}) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
        .apply {
            val textView =
                this.view.findViewById<TextView>(R.id.snackbar_text)
            textView?.setTextColor(Color.WHITE)
        }
    snackbar.takeUnless { actionText.isNullOrEmpty() }?.apply { setAction(actionText, action) }
    snackbar.show()
}

fun View.longSnackbar(message: CharSequence, actionText: String = "", action: (View) -> Unit = {}) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .apply {
            val textView =
                this.view.findViewById<TextView>(R.id.snackbar_text)
            textView?.setTextColor(Color.WHITE)
        }
    snackbar.takeUnless { actionText.isNullOrEmpty() }?.apply { setAction(actionText, action) }
    return snackbar.show()
}

fun View.indefiniteSnackbar(
    message: CharSequence,
    actionText: String = "",
    action: (View) -> Unit = {}
) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)
        .apply {
            val textView =
                this.view.findViewById<TextView>(R.id.snackbar_text)
            textView.setTextColor(Color.WHITE)
        }
    snackbar.takeUnless { actionText.isNullOrEmpty() }?.apply { setAction(actionText, action) }
    snackbar.show()
}

fun View.toast(msg: String?, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(context, msg, duration).show()
}