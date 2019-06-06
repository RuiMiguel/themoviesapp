package com.gigigo.themoviesapp.home.data.source

import arrow.core.Either
import arrow.core.Try
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.data.utils.ErrorUtils
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.data.mapper.toLatestMovie
import com.gigigo.themoviesapp.home.data.mapper.toPageMovie
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.NowPlayingMovie
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.PopularMovie
import com.gigigo.themoviesapp.home.domain.model.TopRatedMovie
import com.gigigo.themoviesapp.home.domain.model.UpcomingMovie

class MovieNetworkDataSource(
    private val apiKey: String,
    private val api: MovieApiService
) {

    fun getLatest(language: String): Either<Failure, LatestMovie> {
        return Try {
            api.getLatest(language, apiKey).execute()
        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toLatestMovie()?.right()
                        ?: Failure.ServerError("Response error").left()
                } else {
                    val message =
                        ErrorUtils.parseError(response)?.statusMessage ?: "Error on response data"
                    Failure.ServerError(message).left()
                }
            }
        )
    }

    fun getNowPlaying(
        language: String,
        page: Int,
        region: String
    ): Either<Failure, Page<out NowPlayingMovie>> {
        return Try {
            api.getNowPlaying(language, page, region, apiKey).execute()
        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toPageMovie<NowPlayingMovie>()?.right()
                        ?: Failure.ServerError("Response error").left()
                } else {
                    val message =
                        ErrorUtils.parseError(response)?.statusMessage ?: "Error on response data"
                    Failure.ServerError(message).left()
                }
            }
        )
    }

    fun getPopular(
        language: String,
        page: Int,
        region: String
    ): Either<Failure, Page<out PopularMovie>> {
        return Try {
            api.getPopular(language, page, region, apiKey).execute()
        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toPageMovie<PopularMovie>()?.right()
                        ?: Failure.ServerError("Response error").left()
                } else {
                    val message =
                        ErrorUtils.parseError(response)?.statusMessage ?: "Error on response data"
                    Failure.ServerError(message).left()
                }
            }
        )
    }

    fun getTopRated(
        language: String,
        page: Int,
        region: String
    ): Either<Failure, Page<out TopRatedMovie>> {
        return Try {
            api.getTopRated(language, page, region, apiKey).execute()
        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toPageMovie<TopRatedMovie>()?.right()
                        ?: Failure.ServerError("Response error").left()
                } else {
                    val message =
                        ErrorUtils.parseError(response)?.statusMessage ?: "Error on response data"
                    Failure.ServerError(message).left()
                }
            }
        )
    }

    fun getUpcoming(
        language: String,
        page: Int,
        region: String
    ): Either<Failure, Page<out UpcomingMovie>> {
        return Try {
            api.getUpcoming(language, page, region, apiKey).execute()
        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toPageMovie<UpcomingMovie>()?.right()
                        ?: Failure.ServerError("Response error").left()
                } else {
                    val message =
                        ErrorUtils.parseError(response)?.statusMessage ?: "Error on response data"
                    Failure.ServerError(message).left()
                }
            }
        )
    }
}