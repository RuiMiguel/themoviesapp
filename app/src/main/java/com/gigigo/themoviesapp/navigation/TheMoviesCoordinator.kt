package com.gigigo.themoviesapp.navigation

import android.view.View

class TheMoviesCoordinator(
    private val navigator: TheMoviesNavigator
) {
    fun goHome(clearBackStack: Boolean) {
        navigator.goHome(clearBackStack)
    }

    fun goDetail(movieId: Int, transitions: List<Pair<View, String>>, clearBackStack: Boolean) {
        navigator.goDetail(movieId, transitions, clearBackStack)
    }
}