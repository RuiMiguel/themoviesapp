package com.gigigo.themoviesapp.base.ui.navigation

import androidx.fragment.app.FragmentActivity

abstract class Navigator() {
    var activity: FragmentActivity? = null

    abstract fun goHome()
    abstract fun goDetail()
}