package com.gigigo.themoviesapp.home.navigation

import com.gigigo.themoviesapp.base.navigation.AppNavigator

class HomeCoordinator(
    private val navigator: HomeNavigator,
    private val appNavigator: AppNavigator
) {

    fun goDetail(movieId: Int) {
        appNavigator.goDetail(movieId, clearBackStack = false)
    }
}