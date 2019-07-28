package com.gigigo.themoviesapp.splash.viewmodel.navigation

import com.gigigo.themoviesapp.base.ui.navigation.Navigator

class SplashCoordinator(val navigation: Navigator) {

    fun goHome() {
        navigation.goHome(clearBackStack = true)
    }
}