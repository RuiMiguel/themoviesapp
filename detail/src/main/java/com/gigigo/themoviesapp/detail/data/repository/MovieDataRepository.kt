package com.gigigo.themoviesapp.detail.data.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.detail.data.source.MovieNetworkDataSource
import com.gigigo.themoviesapp.detail.domain.model.MovieDetail
import com.gigigo.themoviesapp.detail.domain.repository.MovieRepository

class MovieDataRepository(
    private val networkDataSource: MovieNetworkDataSource
) : MovieRepository {

    override fun getDetail(movieId: Int, language: String): Either<Failure, MovieDetail> {
        return networkDataSource.getDetail(movieId, language)
    }
}