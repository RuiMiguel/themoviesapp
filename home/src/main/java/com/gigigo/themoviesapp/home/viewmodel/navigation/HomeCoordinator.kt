package com.gigigo.themoviesapp.home.viewmodel.navigation

import com.gigigo.themoviesapp.base.ui.navigation.Navigator

class HomeCoordinator(val navigation: Navigator) {

    fun goDetail(movieId: Int) {
        navigation.goDetail(movieId, clearBackStack = false)
    }
}