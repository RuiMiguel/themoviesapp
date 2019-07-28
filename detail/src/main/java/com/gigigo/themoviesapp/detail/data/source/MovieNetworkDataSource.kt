package com.gigigo.themoviesapp.detail.data.source

import arrow.core.Either
import arrow.core.Try
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.data.utils.ErrorUtils
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.detail.data.mapper.toMovieDetail
import com.gigigo.themoviesapp.detail.domain.model.MovieDetail

class MovieNetworkDataSource(
    private val apiKey: String,
    private val api: MovieApiService
) {

    fun getDetail(movieId: Int, language: String): Either<Failure, MovieDetail> {
        return Try {
            api.getDetail(movieId, language, apiKey).execute()
        }.fold(
            {
                Failure.NetworkFailure(it.message ?: "Network error: ${it.message}").left()
            },
            { response ->
                if (response.isSuccessful) {
                    response.body()?.toMovieDetail()?.right()
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