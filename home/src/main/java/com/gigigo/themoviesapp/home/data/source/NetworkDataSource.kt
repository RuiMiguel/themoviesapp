package com.gigigo.themoviesapp.home.data.source

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.data.model.toPage
import com.gigigo.themoviesapp.base.data.utils.NetworkHandler
import com.gigigo.themoviesapp.home.domain.model.Page

class NetworkDataSource(private val api: ApiService, private val networkHandler: NetworkHandler) {
    fun getTrending(media: Int, time: Int): Either<Failure, Page> {
        return when (networkHandler.isConnected) {
            true -> {
                val response = api.getTrending(media, time, "72db0ed95f9ff0a4bb3c18f69780ef14").execute()
                response.body()?.toPage()?.right() ?: Failure.ServerError("Response error").left()
            }
            false -> {
                Failure.NetworkFailure("Not connected").left()
            }
        }
    }
}