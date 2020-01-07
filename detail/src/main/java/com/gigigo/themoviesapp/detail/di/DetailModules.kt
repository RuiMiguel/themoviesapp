package com.gigigo.themoviesapp.home.di

import com.gigigo.themoviesapp.base.di.Property
import com.gigigo.themoviesapp.base.di.createApiService
import com.gigigo.themoviesapp.detail.data.repository.MovieDataRepository
import com.gigigo.themoviesapp.detail.data.source.MovieApiService
import com.gigigo.themoviesapp.detail.data.source.MovieNetworkDataSource
import com.gigigo.themoviesapp.detail.domain.repository.MovieRepository
import com.gigigo.themoviesapp.detail.domain.usecases.GetMovieDetail
import com.gigigo.themoviesapp.detail.navigation.DetailNavigator
import com.gigigo.themoviesapp.detail.viewmodel.DetailViewModel
import com.gigigo.themoviesapp.detail.navigation.DetailCoordinator
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

@JvmField
val detailPresentationModule: Module = module {
    viewModel {
        DetailViewModel(
            coordinator = get(),
            getMovieDetail = get()
        )
    }

    single { DetailNavigator() }
    single {
        DetailCoordinator(
            navigator = get(),
            appNavigator = get()
        )
    }
}

@JvmField
val detailDomainModule: Module = module {
    factory { GetMovieDetail(movieRepository = get()) }
}

@JvmField
val detailDataModule: Module = module {
    single<MovieRepository> { MovieDataRepository(networkDataSource = get()) }

    single {
        MovieNetworkDataSource(
            apiKey = getProperty(Property.API_KEY),
            api = get()
        )
    }

    single<MovieApiService> { createApiService<MovieApiService>(retrofit = get()) }
}

@JvmField
val detailModules = listOf(detailPresentationModule, detailDomainModule, detailDataModule)