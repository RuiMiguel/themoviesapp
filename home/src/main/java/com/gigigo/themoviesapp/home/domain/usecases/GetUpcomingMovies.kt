package com.gigigo.themoviesapp.home.domain.usecases

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.base.domain.usecases.UseCase
import com.gigigo.themoviesapp.home.domain.model.MediaType
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.TimeWindow
import com.gigigo.themoviesapp.home.domain.repository.MovieRepository
import com.gigigo.themoviesapp.home.domain.repository.TrendingRepository

class GetUpcomingMovies(private val movieRepository: MovieRepository) :
    UseCase<List<Movie>, GetUpcomingMovies.Params>() {
    override fun run(params: GetUpcomingMovies.Params?): Either<Failure, List<Movie>> {
        val upcomingParams = initParams(params)
        val response = movieRepository.getUpcoming(upcomingParams.language, upcomingParams.page, upcomingParams.region)
        return response.fold(::onHandleError, ::onHandleSuccess)
    }

    private fun onHandleError(failure: Failure): Either<Failure, List<Movie>> = failure.left()
    private fun onHandleSuccess(data: Page<Movie>): Either<Failure, List<Movie>> = data.results.right()

    class Params private constructor(val language: String, val page: Int, val region: String) {
        companion object {
            @JvmStatic
            fun withParams(language: String, page: Int, region: String): Params {
                return Params(language, page, region)
            }
        }
    }

    private fun initParams(params: Params?): Params {
        val language = params?.language ?: "en-US"
        val page = params?.page ?: 1 //page 1..1000 default 1
        val region = params?.region ?: "" //region ISO3166-1 uppercase ^[A-Z](2)$

        return Params.withParams(language, page, region)
    }
}