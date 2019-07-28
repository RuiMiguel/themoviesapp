package com.gigigo.themoviesapp.di

import com.gigigo.themoviesapp.base.navigation.BaseNavigator
import com.gigigo.themoviesapp.navigation.TheMoviesNavigator
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

@JvmField
val appPresentationModule: Module = module {
    single { TheMoviesNavigator() } bind BaseNavigator.AppBaseNavigator::class
}

@JvmField
val appDomainModule: Module = module {

}

@JvmField
val appDataModule: Module = module {

}


@JvmField
val appModules = listOf(appPresentationModule, appDomainModule, appDataModule)