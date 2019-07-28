package com.gigigo.themoviesapp.navigation

import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.gigigo.themoviesapp.base.ui.navigation.Navigator
import com.gigigo.themoviesapp.base.ui.utils.extensions.addFragment
import com.gigigo.themoviesapp.base.ui.utils.extensions.replaceFragment
import com.gigigo.themoviesapp.detail.ui.DetailActivity
import com.gigigo.themoviesapp.home.ui.HomeActivity

class AppNavigator() : Navigator() {
    companion object Arguments {
        const val MOVIE_ARG = "MOVIE_ARG"
    }

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

    private fun navigateToActivityForResult(
        intent: Intent,
        requestCode: Int
    ) {
        activity?.apply {
            startActivityForResult(intent, requestCode)
        }
    }

    private fun returnFromActivityForResult(
        resultCode: Int,
        intent: Intent
    ) {

        activity?.setResult(resultCode, intent)
        activity?.finish()
    }

    private fun navigateToActivity(
        intent: Intent,
        clearBackStack: Boolean,
        options: Bundle? = null
    ) {
        activity?.apply {
            startActivity(intent, options)
            clearBackStack.takeIf { it }?.let { finish() }
        }
    }

    private fun navigateToFragment(
        fragment: Fragment,
        @IdRes frameId: Int,
        clearBackStack: Boolean
    ) {
        activity?.apply {
            if (clearBackStack) {
                addFragment(fragment, frameId)
            } else {
                replaceFragment(fragment, frameId)
            }
        }
    }
}