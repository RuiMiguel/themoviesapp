package com.gigigo.themoviesapp.splash.navigation

import com.gigigo.themoviesapp.base.navigation.AppNavigator

class SplashCoordinator(
    private val appNavigator: AppNavigator
) {

    fun goHome() {
        appNavigator.goHome(clearBackStack = true)
    }
}