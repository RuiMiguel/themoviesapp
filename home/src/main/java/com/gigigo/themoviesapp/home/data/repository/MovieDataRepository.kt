package com.gigigo.themoviesapp.home.data.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.data.source.MovieNetworkDataSource
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.repository.MovieRepository

class MovieDataRepository(
    private val networkDataSource: MovieNetworkDataSource
) : MovieRepository {

    override fun getLatest(language: String): Either<Failure, LatestMovie> {
        return networkDataSource.getLatest(language)
    }

    override fun getNowPlaying(
        language: String,
        page: Int,
        region: String
    ): Either<Failure, Page<Movie>> {
        return networkDataSource.getNowPlaying(language, page, region)
    }

    override fun getPopular(
        language: String,
        page: Int,
        region: String
    ): Either<Failure, Page<Movie>> {
        return networkDataSource.getPopular(language, page, region)
    }

    override fun getTopRated(
        language: String,
        page: Int,
        region: String
    ): Either<Failure, Page<Movie>> {
        return networkDataSource.getTopRated(language, page, region)
    }

    override fun getUpcoming(
        language: String,
        page: Int,
        region: String
    ): Either<Failure, Page<Movie>> {
        return networkDataSource.getUpcoming(language, page, region)
    }
}