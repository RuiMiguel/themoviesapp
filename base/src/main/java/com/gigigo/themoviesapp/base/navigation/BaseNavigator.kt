package com.gigigo.themoviesapp.base.navigation

import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.gigigo.themoviesapp.base.ui.utils.extensions.addFragment
import com.gigigo.themoviesapp.base.ui.utils.extensions.replaceFragment
import org.koin.core.KoinComponent
import org.koin.core.inject

sealed class BaseNavigator : KoinComponent {
    abstract class AppBaseNavigator : BaseNavigator() {
        //TODO: better way to put these abstract functions and arguments??

        companion object Arguments {
            const val MOVIE_ARG = "MOVIE_ARG"
        }

        abstract fun goHome(clearBackStack: Boolean)
        abstract fun goDetail(movieId: Int, clearBackStack: Boolean)
    }

    abstract class FeatureBaseNavigator : BaseNavigator()

    private val navigatorLifecycle: NavigatorLifecycle by inject()

    protected var activity: FragmentActivity?
        get() = navigatorLifecycle.activity
        set(value) {
            navigatorLifecycle.activity = value
        }

    protected fun navigateToActivityForResult(
        intent: Intent,
        requestCode: Int
    ) {
        activity?.apply {
            startActivityForResult(intent, requestCode)
        }
    }

    protected fun returnFromActivityForResult(
        resultCode: Int,
        intent: Intent
    ) {

        activity?.setResult(resultCode, intent)
        activity?.finish()
    }

    protected fun navigateToActivity(
        intent: Intent,
        clearBackStack: Boolean,
        options: Bundle? = null
    ) {
        activity?.apply {
            startActivity(intent, options)
            clearBackStack.takeIf { it }?.let { finish() }
        }
    }

    protected fun navigateToFragment(
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