package com.gigigo.themoviesapp.home.data.source

import arrow.core.Either
import arrow.core.Try
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.data.utils.ErrorUtils
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.data.mapper.toPageMovie
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.TrendingMovie

class NetworkDataSource(
    private val apiKey: String,
    private val api: ApiService
) {
    fun getTrending(media: String, time: String): Either<Failure, Page<out TrendingMovie>> {
        return Try {
            api.getTrending(media, time, apiKey).execute()

        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toPageMovie<TrendingMovie>()?.right()
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