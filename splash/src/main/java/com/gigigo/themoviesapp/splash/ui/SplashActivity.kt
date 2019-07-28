package com.gigigo.themoviesapp.splash.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gigigo.themoviesapp.base.ui.navigation.Navigator
import com.gigigo.themoviesapp.base.ui.utils.extensions.hide
import com.gigigo.themoviesapp.base.ui.utils.extensions.show
import com.gigigo.themoviesapp.splash.R
import com.gigigo.themoviesapp.splash.di.splashModules
import com.gigigo.themoviesapp.splash.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.progress_bar
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class SplashActivity : AppCompatActivity() {
    private val navigator: Navigator by inject()

    private val viewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashModules.forEach { loadKoinModules(it) }
        initViewModel()

        navigator.activity = this
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(splashModules)
        navigator.activity = null
    }

    private fun initViewModel() {
        viewModel.isLoading.observe(this, Observer {
            showLoading(it)
        })
    }

    private fun showLoading(loading: Boolean) {
        when (loading) {
            true -> {
                progress_bar.show()
            }
            false -> {
                progress_bar.hide()
            }
        }
    }
}
