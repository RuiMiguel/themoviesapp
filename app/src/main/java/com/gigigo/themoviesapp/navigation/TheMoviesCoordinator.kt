package com.gigigo.themoviesapp.navigation

import android.view.View
import androidx.core.util.Pair

class TheMoviesCoordinator(
    private val navigator: TheMoviesNavigator
) {
    fun goHome(clearBackStack: Boolean) {
        navigator.goHome(clearBackStack)
    }

    fun goDetail(movieId: Int, transitions: Pair<View, String>, clearBackStack: Boolean) {
        navigator.goDetail(movieId, clearBackStack, transitions)
    }
}