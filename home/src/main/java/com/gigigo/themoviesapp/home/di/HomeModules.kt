package com.gigigo.themoviesapp.home.di

import com.gigigo.themoviesapp.base.di.createApiService
import com.gigigo.themoviesapp.home.data.repository.TrendingDataRepository
import com.gigigo.themoviesapp.home.data.source.ApiService
import com.gigigo.themoviesapp.home.data.source.NetworkDataSource
import com.gigigo.themoviesapp.home.domain.repository.TrendingRepository
import com.gigigo.themoviesapp.home.domain.usecases.GetTrending
import com.gigigo.themoviesapp.home.viewmodel.MainViewModel
import com.gigigo.themoviesapp.home.viewmodel.factory.MainViewModelFactory
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

@JvmField
val homePresentationModule: Module = module {
    single {
        MainViewModelFactory(getTrending = get())
    }

    factory {
        MainViewModel(getTrending = get())
    }
}

@JvmField
val homeDomainModule: Module = module {
    factory { GetTrending(trendingRepository = get()) }
}

@JvmField
val homeDataModule: Module = module {
    single {
        TrendingDataRepository(networkDataSource = get())
    } bind (TrendingRepository::class)

    single {
        NetworkDataSource(
            api = get(),
            networkHandler = get()
        )
    }

    single { createApiService<ApiService>(get()) } bind (ApiService::class)
}

@JvmField
val homeModules = listOf(homePresentationModule, homeDomainModule, homeDataModule)