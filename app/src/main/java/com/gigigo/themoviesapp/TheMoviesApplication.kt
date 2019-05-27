package com.gigigo.themoviesapp

import android.app.Application
import com.gigigo.themoviesapp.base.di.Property
import com.gigigo.themoviesapp.base.di.baseModules
import com.gigigo.themoviesapp.di.appModules
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger

class TheMoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initDI()
    }

    private fun initDI() {
        startKoin(
            androidContext = this,
            modules = appModules.union(baseModules).toList(),
            extraProperties = getExtraProperties(),
            loadPropertiesFromFile = false,
            logger = AndroidLogger()
        )
    }

    private fun getExtraProperties(): HashMap<String, String> {
        val extraProperties = HashMap<String, String>()
        extraProperties[Property.API_KEY] = BuildConfig.API_KEY
        extraProperties[Property.API_URL] = BuildConfig.API_URL
        extraProperties[Property.IMAGE_API_URL] = BuildConfig.IMAGE_API_URL
        return extraProperties
    }
}