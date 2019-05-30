package com.gigigo.themoviesapp.di

import com.gigigo.themoviesapp.base.ui.navigation.Navigator
import com.gigigo.themoviesapp.navigation.AppNavigator
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

@JvmField
val appPresentationModule: Module = module {
    single {
        AppNavigator()
    } bind Navigator::class
}

@JvmField
val appDomainModule: Module = module {

}

@JvmField
val appDataModule: Module = module {

}


@JvmField
val appModules = listOf(appPresentationModule, appDomainModule, appDataModule)