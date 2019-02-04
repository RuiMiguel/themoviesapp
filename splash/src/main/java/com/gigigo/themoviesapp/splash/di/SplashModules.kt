package com.gigigo.themoviesapp.splash.di

import com.gigigo.themoviesapp.base.di.Property
import com.gigigo.themoviesapp.base.di.createApiService
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

@JvmField
val splashPresentationModule: Module = module {
    viewModel(override = true) {
        SplashViewModel(getConfiguration = get())
    }
}

@JvmField
val splashDomainModule: Module = module {
    factory(override = true) { GetConfiguration(configurationRepository = get()) }
}

@JvmField
val splashDataModule: Module = module {
    single(override = true) {
        ConfigurationDataRepository(networkDataSource = get())
    } bind (ConfigurationRepository::class)

    single(override = true) {
        NetworkDataSource(
            apiKey = getProperty(Property.API_KEY),
            api = get(),
            networkHandler = get()
        )
    }

    single(override = true) { createApiService<ApiService>(get()) } bind (ApiService::class)
}

@JvmField
val splashModules = listOf(splashPresentationModule, splashDomainModule, splashDataModule)