package com.gigigo.themoviesapp.home.domain.usecases

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.base.domain.usecases.UseCase
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.repository.TrendingRepository

class GetTrending(private val trendingRepository: TrendingRepository) :
    UseCase<List<Movie>, GetTrending.Params>() {
    override fun run(params: GetTrending.Params?): Either<Failure, List<Movie>> {
        val trendingParams = params ?: defaultParams()
        val response = trendingRepository.getTrending(trendingParams.media, trendingParams.time)
        return response.fold(::onHandleError, ::onHandleSuccess)

        /*
        return Try {
            val trendingParams = params ?: defaultParams()
            trendingRepository.getTrending(trendingParams.media, trendingParams.time)
        }.getOrElse {
            Left(Failure.GenericError(it.message))
        }
        */
    }

    private fun onHandleError(failure: Failure): Either<Failure, List<Movie>> = failure.left()
    private fun onHandleSuccess(data: Page): Either<Failure, List<Movie>> = data.results.right()

    class Params private constructor(val media: Int, val time: Int) {
        companion object {
            @JvmStatic
            fun forMediaTime(media: Int, time: Int): Params {
                return Params(media, time)
            }
        }
    }

    private fun defaultParams(): GetTrending.Params = Params.forMediaTime(1, 1)
}