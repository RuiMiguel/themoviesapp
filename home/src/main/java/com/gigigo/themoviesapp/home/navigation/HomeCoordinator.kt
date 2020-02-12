package com.gigigo.themoviesapp.home.navigation

import android.view.View
import com.gigigo.themoviesapp.base.navigation.AppNavigator

class HomeCoordinator(
    private val navigator: HomeNavigator,
    private val appNavigator: AppNavigator
) {

    fun goDetail(movieId: Int, transitions: List<Pair<View?, String>>) {
        appNavigator.goDetail(movieId, transitions, false)
    }
}