package com.gigigo.themoviesapp.base.ui.utils.extensions

import android.view.View

fun View.show(visible: Boolean = true) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.hide(visible: Boolean = true) {
    show(!visible)
}