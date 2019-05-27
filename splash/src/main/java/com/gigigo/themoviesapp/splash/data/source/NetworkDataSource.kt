package com.gigigo.themoviesapp.splash.data.source

import arrow.core.Either
import arrow.core.Try
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.data.utils.ErrorUtils
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.splash.data.model.toConfiguration
import com.gigigo.themoviesapp.splash.domain.model.Configuration

class NetworkDataSource(
    private val apiKey: String,
    private val api: ApiService
) {
    fun getConfiguration(): Either<Failure, Configuration> {
        return Try {
            api.getConfiguration(apiKey).execute()
        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toConfiguration()?.right()
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