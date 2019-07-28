package com.gigigo.themoviesapp.navigation

import android.content.Intent
import com.gigigo.themoviesapp.base.navigation.BaseNavigator
import com.gigigo.themoviesapp.detail.ui.DetailActivity
import com.gigigo.themoviesapp.home.ui.HomeActivity

class TheMoviesNavigator : BaseNavigator.AppBaseNavigator() {
    override fun goHome(clearBackStack: Boolean) {
        val intent = Intent(activity, HomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        navigateToActivity(intent, clearBackStack)
    }

    override fun goDetail(movieId: Int, clearBackStack: Boolean) {
        val intent = Intent(activity, DetailActivity::class.java).apply {
            putExtra(MOVIE_ARG, movieId)
        }
        navigateToActivity(intent, clearBackStack)
    }
}