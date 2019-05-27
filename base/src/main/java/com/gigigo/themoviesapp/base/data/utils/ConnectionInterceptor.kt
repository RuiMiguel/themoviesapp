package com.gigigo.themoviesapp.base.data.utils

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectionInterceptor(private val networkHandler: NetworkHandler) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        when (networkHandler.isConnected) {
            true -> {
                val request = chain.request()
                return chain.proceed(request)
            }
            false -> {
                throw IOException("Network not connected!")
            }
        }
    }
}