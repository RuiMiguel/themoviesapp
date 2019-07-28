package com.gigigo.themoviesapp.home.di

import com.gigigo.themoviesapp.base.di.Property
import com.gigigo.themoviesapp.base.di.createApiService
import com.gigigo.themoviesapp.detail.data.repository.MovieDataRepository
import com.gigigo.themoviesapp.detail.data.source.MovieApiService
import com.gigigo.themoviesapp.detail.data.source.MovieNetworkDataSource
import com.gigigo.themoviesapp.detail.domain.repository.MovieRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

@JvmField
val detailPresentationModule: Module = module {
    /*
    viewModel {
        DetailViewModel(
            coordinator = get(),
            getTrendingMovies = get(),
            getLatestMovie = get(),
            getNowPlayingMovies = get(),
            getPopularMovies = get(),
            getTopRatedMovies = get(),
            getUpcomingMovies = get()
        )
    }
    */

    /*
    single {
        DetailCoordinator(
            navigation = get()
        )
    }
    */
}

@JvmField
val detailDomainModule: Module = module {
    /*factory { GetMovieDetail(movieDetailRepository = get()) }*/
}

@JvmField
val detailDataModule: Module = module {
    single {
        MovieDataRepository(networkDataSource = get())
    } bind MovieRepository::class

    single {
        MovieNetworkDataSource(
            apiKey = getProperty(Property.API_KEY),
            api = get()
        )
    }

    single { createApiService<MovieApiService>(get()) } bind MovieApiService::class
}

@JvmField
val detailModules = listOf(detailPresentationModule, detailDomainModule, detailDataModule)