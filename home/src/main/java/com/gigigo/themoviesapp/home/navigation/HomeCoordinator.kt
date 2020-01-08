package com.gigigo.themoviesapp.home.navigation

import android.view.View
import androidx.core.util.Pair as AndroidPair
import com.gigigo.themoviesapp.base.navigation.AppNavigator

class HomeCoordinator(
    private val navigator: HomeNavigator,
    private val appNavigator: AppNavigator
) {

    fun goDetail(movieId: Int, vararg transitions: AndroidPair<View, String>) {
        appNavigator.goDetail(movieId, false, *transitions)
    }
}