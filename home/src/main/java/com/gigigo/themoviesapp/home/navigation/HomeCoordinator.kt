package com.gigigo.themoviesapp.home.navigation

import com.gigigo.themoviesapp.base.navigation.BaseNavigator

class HomeCoordinator(
    private val navigator: HomeNavigator,
    private val appNavigator: BaseNavigator.AppBaseNavigator
) {

    fun goDetail(movieId: Int) {
        appNavigator.goDetail(movieId, clearBackStack = false)
    }
}