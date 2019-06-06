package com.gigigo.themoviesapp.home.domain.usecases

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.base.domain.usecases.UseCase
import com.gigigo.themoviesapp.home.domain.model.MediaType
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.TimeWindow
import com.gigigo.themoviesapp.home.domain.model.TrendingMovie
import com.gigigo.themoviesapp.home.domain.repository.TrendingRepository

class GetTrendingMovies(private val trendingRepository: TrendingRepository) :
    UseCase<List<TrendingMovie>, GetTrendingMovies.Params>() {
    override fun run(params: GetTrendingMovies.Params?): Either<Failure, List<TrendingMovie>> {
        val trendingParams = initParams(params)
        val response =
            trendingRepository.getTrending(trendingParams.mediaType, trendingParams.timeWindow)
        return response.fold(::onHandleError, ::onHandleSuccess)
    }

    private fun onHandleError(failure: Failure): Either<Failure, List<TrendingMovie>> =
        failure.left()

    private fun onHandleSuccess(data: Page<out TrendingMovie>): Either<Failure, List<TrendingMovie>> =
        data.results.right()

    class Params private constructor(val mediaType: MediaType, val timeWindow: TimeWindow) {
        companion object {
            @JvmStatic
            fun withParams(mediaType: MediaType, timeWindow: TimeWindow): Params {
                return Params(mediaType, timeWindow)
            }
        }
    }

    private fun initParams(params: Params?): Params {
        val mediaType = params?.mediaType ?: MediaType.ALL
        val timeWindow = params?.timeWindow ?: TimeWindow.WEEK
        return Params.withParams(mediaType, timeWindow)
    }
}