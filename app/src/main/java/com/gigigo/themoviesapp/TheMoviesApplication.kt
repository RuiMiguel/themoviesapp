package com.gigigo.themoviesapp

import android.app.Application
import com.gigigo.themoviesapp.base.di.baseModules
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger

class TheMoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initDI()
    }

    private fun initDI() {
        val extraProperties = HashMap<String, String>()
        startKoin(
            androidContext = this,
            modules = listOf(baseModules),
            extraProperties = extraProperties,
            loadPropertiesFromFile = false,
            logger = AndroidLogger()
        )
    }
}