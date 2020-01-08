package com.gigigo.themoviesapp.navigation

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair as AndroidPair
import com.gigigo.themoviesapp.base.navigation.AppNavigator
import com.gigigo.themoviesapp.detail.ui.DetailActivity
import com.gigigo.themoviesapp.home.ui.HomeActivity

class TheMoviesNavigator : AppNavigator() {
    companion object Arguments {
        const val MOVIE_ARG = "MOVIE_ARG"
    }

    override fun goHome(clearBackStack: Boolean) {
        val intent = Intent(activity, HomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        navigateToActivity(intent, clearBackStack)
    }

    override fun goDetail(movieId: Int, clearBackStack: Boolean, vararg transitions: AndroidPair<View, String>) {
        val activityOptionsCompat: ActivityOptionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity as Activity,
                *transitions
            )

        val intent = Intent(activity, DetailActivity::class.java).apply {
            putExtra(MOVIE_ARG, movieId)
        }
        navigateToActivity(intent, clearBackStack, activityOptionsCompat.toBundle())
    }
}