package com.gigigo.themoviesapp.home.data.source

import arrow.core.Either
import arrow.core.Try
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.data.utils.ErrorUtils
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.data.mapper.toLatestTv
import com.gigigo.themoviesapp.home.data.mapper.toPageTv
import com.gigigo.themoviesapp.home.domain.model.LatestTv
import com.gigigo.themoviesapp.base.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.Tv

class TvNetworkDataSource(
    private val apiKey: String,
    private val api: TvApiService
) {

    fun getLatest(time: String): Either<Failure, LatestTv> {
        return Try {
            api.getLatest(time, apiKey).execute()

        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toLatestTv()?.right()
                        ?: Failure.ServerError("Response error").left()
                } else {
                    val message =
                        ErrorUtils.parseError(response)?.statusMessage ?: "Error on response data"
                    Failure.ServerError(message).left()
                }
            }
        )
    }

    fun getAiringToday(
        language: String,
        page: Int
    ): Either<Failure, Page<Tv>> {
        return Try {
            api.getAiringToday(language, page, apiKey).execute()

        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toPageTv()?.right()
                        ?: Failure.ServerError("Response error").left()
                } else {
                    val message =
                        ErrorUtils.parseError(response)?.statusMessage ?: "Error on response data"
                    Failure.ServerError(message).left()
                }
            }
        )
    }

    fun getOnTheAir(
        language: String,
        page: Int
    ): Either<Failure, Page<Tv>> {
        return Try {
            api.getOnTheAir(language, page, apiKey).execute()

        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toPageTv()?.right()
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
        page: Int
    ): Either<Failure, Page<Tv>> {
        return Try {
            api.getPopular(language, page, apiKey).execute()

        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toPageTv()?.right()
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
        page: Int
    ): Either<Failure, Page<Tv>> {
        return Try {
            api.getTopRated(language, page, apiKey).execute()

        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toPageTv()?.right()
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