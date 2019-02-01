package com.gigigo.themoviesapp.home.data.source

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.data.utils.ErrorUtils
import com.gigigo.themoviesapp.base.data.utils.NetworkHandler
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.data.model.toPage
import com.gigigo.themoviesapp.home.domain.model.Page

class NetworkDataSource(private val api: ApiService, private val networkHandler: NetworkHandler) {
    fun getTrending(media: Int, time: Int): Either<Failure, Page> {
        return when (networkHandler.isConnected) {
            true -> {
                val response =
                    api.getTrending(media, time, "72db0ed95f9ff0a4bb3c18f69780ef1").execute()
                if (response.isSuccessful) {
                    response.body()?.toPage()?.right()
                        ?: Failure.ServerError("Response error").left()
                } else {
                    val message = ErrorUtils.parseError(response).statusMessage ?: "Error on response data"
                    Failure.ServerError(message).left()
                }
            }
            false -> {
                Failure.NetworkFailure("Not connected").left()
            }
        }
    }
}