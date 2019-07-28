package com.gigigo.themoviesapp.splash.navigation

import com.gigigo.themoviesapp.base.navigation.BaseNavigator

class SplashCoordinator(
    private val appNavigator: BaseNavigator.AppBaseNavigator
) {

    fun goHome() {
        appNavigator.goHome(clearBackStack = true)
    }
}