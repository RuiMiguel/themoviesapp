package com.gigigo.themoviesapp.base.navigation

import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.gigigo.themoviesapp.base.ui.extensions.addFragment
import com.gigigo.themoviesapp.base.ui.extensions.addFragmentToBackStack
import com.gigigo.themoviesapp.base.ui.extensions.replaceFragment
import com.gigigo.themoviesapp.base.ui.extensions.replaceFragmentIntoBackStack
import org.koin.core.KoinComponent
import org.koin.core.inject

enum class ReplaceOrAdd { REPLACE, ADD }

sealed class BaseNavigator : KoinComponent {
    abstract class AppBaseNavigator : BaseNavigator()
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
        clearBackStack: Boolean,
        replaceOrAdd: ReplaceOrAdd = ReplaceOrAdd.REPLACE
    ) {
        navigatorLifecycle.activity?.apply {
            if (clearBackStack) {
                when (replaceOrAdd) {
                    ReplaceOrAdd.REPLACE -> replaceFragment(fragment, frameId)
                    ReplaceOrAdd.ADD -> addFragment(fragment, frameId)
                }
            } else {
                when (replaceOrAdd) {
                    ReplaceOrAdd.REPLACE -> replaceFragmentIntoBackStack(fragment, frameId)
                    ReplaceOrAdd.ADD -> addFragmentToBackStack(fragment, frameId)
                }
            }
        }
    }
/*
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
 */
}