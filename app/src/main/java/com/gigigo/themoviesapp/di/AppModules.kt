package com.gigigo.themoviesapp.di

import com.gigigo.themoviesapp.base.navigation.AppNavigator
import com.gigigo.themoviesapp.navigation.TheMoviesCoordinator
import com.gigigo.themoviesapp.navigation.TheMoviesNavigator
import org.koin.core.module.Module
import org.koin.dsl.module

@JvmField
val appPresentationModule: Module = module {
    single { TheMoviesCoordinator(navigator = get()) }
    single<AppNavigator> { TheMoviesNavigator() }
}

@JvmField
val appDomainModule: Module = module {

}

@JvmField
val appDataModule: Module = module {

}


@JvmField
val appModules = listOf(appPresentationModule, appDomainModule, appDataModule)