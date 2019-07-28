package com.gigigo.themoviesapp.splash.di

import com.gigigo.themoviesapp.base.di.Property
import com.gigigo.themoviesapp.base.di.createApiService
import com.gigigo.themoviesapp.splash.data.repository.ConfigurationDataRepository
import com.gigigo.themoviesapp.splash.data.source.ApiService
import com.gigigo.themoviesapp.splash.data.source.NetworkDataSource
import com.gigigo.themoviesapp.splash.domain.repository.ConfigurationRepository
import com.gigigo.themoviesapp.splash.domain.usecases.GetConfiguration
import com.gigigo.themoviesapp.splash.navigation.SplashCoordinator
import com.gigigo.themoviesapp.splash.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

@JvmField
val splashPresentationModule: Module = module {
    viewModel {
        SplashViewModel(
            coordinator = get(),
            getConfiguration = get()
        )
    }

    single { SplashCoordinator(appNavigator = get()) }
}

@JvmField
val splashDomainModule: Module = module {
    factory { GetConfiguration(configurationRepository = get()) }
}

@JvmField
val splashDataModule: Module = module {
    single<ConfigurationRepository> { ConfigurationDataRepository(networkDataSource = get()) }
    single {
        NetworkDataSource(
            apiKey = getProperty(Property.API_KEY),
            api = get()
        )
    }

    single { createApiService<ApiService>(get()) } bind ApiService::class
}

@JvmField
val splashModules = listOf(splashPresentationModule, splashDomainModule, splashDataModule)