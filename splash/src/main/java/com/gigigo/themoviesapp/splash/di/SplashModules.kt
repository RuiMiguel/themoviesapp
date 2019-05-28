package com.gigigo.themoviesapp.splash.di

import com.gigigo.themoviesapp.base.di.Property
import com.gigigo.themoviesapp.base.di.createApiService
import com.gigigo.themoviesapp.splash.domain.repository.ConfigurationRepository
import com.gigigo.themoviesapp.splash.domain.usecases.GetConfiguration
import com.gigigo.themoviesapp.splash.data.repository.ConfigurationDataRepository
import com.gigigo.themoviesapp.splash.data.source.ApiService
import com.gigigo.themoviesapp.splash.data.source.NetworkDataSource
import com.gigigo.themoviesapp.splash.viewmodel.SplashViewModel
import com.gigigo.themoviesapp.splash.viewmodel.navigation.SplashCoordinator
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

@JvmField
val splashPresentationModule: Module = module {
    viewModel(override = true) {
        SplashViewModel(
            coordinator = get(),
            getConfiguration = get()
        )
    }

    single(override = true) {
        SplashCoordinator(
            navigation = get()
        )
    }
}

@JvmField
val splashDomainModule: Module = module {
    factory(override = true)  {
        GetConfiguration(
            configurationRepository = get()
        )
    }
}

@JvmField
val splashDataModule: Module = module {
    single(override = true)  {
        ConfigurationDataRepository(networkDataSource = get())
    } bind (ConfigurationRepository::class)

    single(override = true) {
        NetworkDataSource(
            apiKey = getProperty(Property.API_KEY),
            api = get()
        )
    }

    single(override = true) { createApiService<ApiService>(get()) } bind (ApiService::class)
}

@JvmField
val splashModules = listOf(splashPresentationModule, splashDomainModule, splashDataModule)