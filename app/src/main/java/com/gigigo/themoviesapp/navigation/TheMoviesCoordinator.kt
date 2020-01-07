package com.gigigo.themoviesapp.navigation

class TheMoviesCoordinator(
    private val navigator: TheMoviesNavigator
) {
    fun goHome(clearBackStack: Boolean) {
        navigator.goHome(clearBackStack)
    }

    fun goDetail(movieId: Int, clearBackStack: Boolean) {
        navigator.goDetail(movieId, clearBackStack)
    }
}