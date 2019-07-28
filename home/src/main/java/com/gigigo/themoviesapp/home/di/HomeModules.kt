package com.gigigo.themoviesapp.home.di

import com.gigigo.themoviesapp.base.di.Property
import com.gigigo.themoviesapp.base.di.createApiService
import com.gigigo.themoviesapp.home.data.repository.MovieDataRepository
import com.gigigo.themoviesapp.home.data.repository.TrendingDataRepository
import com.gigigo.themoviesapp.home.data.source.ApiService
import com.gigigo.themoviesapp.home.data.source.MovieApiService
import com.gigigo.themoviesapp.home.data.source.MovieNetworkDataSource
import com.gigigo.themoviesapp.home.data.source.NetworkDataSource
import com.gigigo.themoviesapp.home.data.source.TvApiService
import com.gigigo.themoviesapp.home.data.source.TvNetworkDataSource
import com.gigigo.themoviesapp.home.domain.repository.MovieRepository
import com.gigigo.themoviesapp.home.domain.repository.TrendingRepository
import com.gigigo.themoviesapp.home.domain.usecases.GetLatestMovie
import com.gigigo.themoviesapp.home.domain.usecases.GetNowPlayingMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetPopularMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetTopRatedMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetTrendingMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetUpcomingMovies
import com.gigigo.themoviesapp.home.navigation.HomeCoordinator
import com.gigigo.themoviesapp.home.navigation.HomeNavigator
import com.gigigo.themoviesapp.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


@JvmField
val homePresentationModule: Module = module {
    viewModel {
        HomeViewModel(
            coordinator = get(),
            getTrendingMovies = get(),
            getLatestMovie = get(),
            getNowPlayingMovies = get(),
            getPopularMovies = get(),
            getTopRatedMovies = get(),
            getUpcomingMovies = get()
        )
    }

    single { HomeNavigator() }
    single {
        HomeCoordinator(
            navigator = get(),
            appNavigator = get()
        )
    }
}

@JvmField
val homeDomainModule: Module = module {
    factory { GetTrendingMovies(trendingRepository = get()) }
    factory { GetLatestMovie(movieRepository = get()) }
    factory { GetNowPlayingMovies(movieRepository = get()) }
    factory { GetPopularMovies(movieRepository = get()) }
    factory { GetTopRatedMovies(movieRepository = get()) }
    factory { GetUpcomingMovies(movieRepository = get()) }
}

@JvmField
val homeDataModule: Module = module {
    single<TrendingRepository> { TrendingDataRepository(networkDataSource = get()) }
    single<MovieRepository> { MovieDataRepository(networkDataSource = get()) }

    single {
        NetworkDataSource(
            apiKey = getProperty(Property.API_KEY),
            api = get()
        )
    }

    single {
        MovieNetworkDataSource(
            apiKey = getProperty(Property.API_KEY),
            api = get()
        )
    }

    single {
        TvNetworkDataSource(
            apiKey = getProperty(Property.API_KEY),
            api = get()
        )
    }

    single<ApiService> { createApiService<ApiService>(retrofit = get()) }
    single<MovieApiService> { createApiService<MovieApiService>(retrofit = get()) }
    single<TvApiService> { createApiService<TvApiService>(retrofit = get()) }
}

@JvmField
val homeModules = listOf(homePresentationModule, homeDomainModule, homeDataModule)