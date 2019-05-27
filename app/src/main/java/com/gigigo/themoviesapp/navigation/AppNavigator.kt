package com.gigigo.themoviesapp.navigation

import android.content.Intent
import com.gigigo.themoviesapp.base.ui.navigation.Navigator
import com.gigigo.themoviesapp.home.ui.MainActivity

class AppNavigator() : Navigator() {
    override fun goHome() {
        activity?.startActivity(Intent(activity, MainActivity::class.java))
    }

    override fun goDetail() {
        //activity?.startActivity()
    }
}