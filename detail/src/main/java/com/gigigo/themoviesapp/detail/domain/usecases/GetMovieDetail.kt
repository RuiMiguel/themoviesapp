package com.gigigo.themoviesapp.detail.domain.usecases

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.base.domain.usecases.UseCase
import com.gigigo.themoviesapp.detail.domain.model.MovieDetail
import com.gigigo.themoviesapp.detail.domain.repository.MovieRepository

class GetMovieDetail(private val movieRepository: MovieRepository) :
    UseCase<MovieDetail, GetMovieDetail.Params>() {
    override fun run(params: Params?): Either<Failure, MovieDetail> {
        return when (params) {
            is Params -> {
                val movieDetailParams = initParams(params)
                val response = movieRepository.getDetail(
                    movieDetailParams.movieId,
                    movieDetailParams.language!!
                )
                response.fold(::onHandleError, ::onHandleSuccess)
            }
            else -> {
                onHandleError(Failure.MissingParameter("movieId"))
            }
        }
    }

    private fun onHandleError(failure: Failure): Either<Failure, MovieDetail> =
        failure.left()

    private fun onHandleSuccess(data: MovieDetail): Either<Failure, MovieDetail> =
        data.right()

    class Params private constructor(val movieId: Int, val language: String?) {
        companion object {
            @JvmStatic
            fun withParams(movieId: Int, language: String? = null): Params {
                return Params(movieId, language)
            }
        }
    }

    private fun initParams(params: Params): Params {
        val language = params.language ?: "en-US"
        return Params.withParams(params.movieId, language)
    }
}