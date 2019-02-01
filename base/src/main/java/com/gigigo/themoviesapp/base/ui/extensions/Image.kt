package com.gigigo.themoviesapp.base.ui.utils.extensions

import android.widget.ImageView

fun ImageView.blackAndWhite() {
    val matrix = android.graphics.ColorMatrix()
    matrix.setSaturation(0f)

    val filter = android.graphics.ColorMatrixColorFilter(matrix)
    this.colorFilter = filter
}