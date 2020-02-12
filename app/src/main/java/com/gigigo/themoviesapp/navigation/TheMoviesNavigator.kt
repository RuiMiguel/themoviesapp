package com.gigigo.themoviesapp.navigation

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import com.gigigo.themoviesapp.base.navigation.AppNavigator
import com.gigigo.themoviesapp.detail.ui.DetailActivity
import com.gigigo.themoviesapp.home.ui.HomeActivity
import androidx.core.util.Pair as AndroidPair

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

    override fun goDetail(
        movieId: Int,
        transitions: List<Pair<View?, String>>,
        clearBackStack: Boolean
    ) {
        val pairs = transitions.map { pair ->
            AndroidPair(pair.first, pair.second)
        }

        val activityOptionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity as Activity,
                *pairs.toTypedArray()
            ).toBundle()

        val intent = Intent(activity, DetailActivity::class.java).apply {
            putExtra(MOVIE_ARG, movieId)
        }
        navigateToActivity(intent, clearBackStack, activityOptionsCompat)
    }
}