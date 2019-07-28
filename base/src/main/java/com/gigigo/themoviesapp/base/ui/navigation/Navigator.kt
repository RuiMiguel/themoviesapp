package com.gigigo.themoviesapp.base.ui.navigation

import androidx.fragment.app.FragmentActivity

abstract class Navigator() {
    var activity: FragmentActivity? = null

    abstract fun goHome(clearBackStack: Boolean)
    abstract fun goDetail(movieId: Int, clearBackStack: Boolean)
}