package com.gigigo.themoviesapp.base.ui.utils.extensions

import android.app.Activity
import android.util.DisplayMetrics
import android.view.View

fun View.show(visible: Boolean = true) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.hide(visible: Boolean = true) {
    show(!visible)
}

fun View?.visible() {
    this ?: return
    this.visibility = View.VISIBLE
}

fun View?.invisible() {
    this ?: return
    this.visibility = View.INVISIBLE
}

fun View?.gone() {
    this ?: return
    this.visibility = View.GONE
}

fun Activity.screenSize(): DisplayMetrics {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics
}