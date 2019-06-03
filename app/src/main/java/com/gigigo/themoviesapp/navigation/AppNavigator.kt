package com.gigigo.themoviesapp.navigation

import android.content.Intent
import com.gigigo.themoviesapp.base.ui.navigation.Navigator
import com.gigigo.themoviesapp.home.ui.HomeActivity

class AppNavigator() : Navigator() {
    override fun goHome() {
        activity?.startActivity(
            Intent(activity, HomeActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        )
        activity?.finish()
    }

    override fun goDetail() {
        //activity?.startActivity()
    }
}