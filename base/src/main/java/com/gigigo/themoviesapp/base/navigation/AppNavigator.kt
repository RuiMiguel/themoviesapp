package com.gigigo.themoviesapp.base.navigation

import android.view.View

abstract class AppNavigator : BaseNavigator.AppBaseNavigator() {
    companion object Arguments {
        const val MOVIE_ARG = "MOVIE_ARG"
    }

    abstract fun goHome(clearBackStack: Boolean)

    abstract fun goDetail(
        movieId: Int,
        transitions: List<Pair<View?, String>>,
        clearBackStack: Boolean
    )
}