package com.gigigo.themoviesapp.base.navigation

import android.view.View
import androidx.core.util.Pair as AndroidPair

abstract class AppNavigator : BaseNavigator.AppBaseNavigator() {
    companion object Arguments {
        const val MOVIE_ARG = "MOVIE_ARG"
    }

    abstract fun goHome(clearBackStack: Boolean)

    abstract fun goDetail(movieId: Int, clearBackStack: Boolean, vararg transitions: AndroidPair<View, String>)
}