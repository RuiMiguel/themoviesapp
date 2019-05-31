package com.gigigo.themoviesapp.home.domain.usecases

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.base.domain.usecases.UseCase
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.repository.MovieRepository

class GetLatestMovie(private val movieRepository: MovieRepository) :
    UseCase<LatestMovie, GetLatestMovie.Params>() {
    override fun run(params: GetLatestMovie.Params?): Either<Failure, LatestMovie> {
        val latestParams = initParams(params)
        val response = movieRepository.getLatest(latestParams.language)
        return response.fold(::onHandleError, ::onHandleSuccess)
    }

    private fun onHandleError(failure: Failure): Either<Failure, LatestMovie> = failure.left()
    private fun onHandleSuccess(data: LatestMovie): Either<Failure, LatestMovie> = data.right()

    class Params private constructor(val language: String) {
        companion object {
            @JvmStatic
            fun withParams(language: String): Params {
                return Params(language)
            }
        }
    }

    private fun initParams(params: Params?): Params {
        val language = params?.language ?: "en-US"
        return Params.withParams(language)
    }
}