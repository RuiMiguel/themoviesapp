package com.gigigo.themoviesapp.base.data.utils

import com.gigigo.themoviesapp.base.data.model.ApiError
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

object ErrorUtils: KoinComponent {
    private val retrofit: Retrofit by inject()

    fun parseError(response: Response<*>): ApiError? {
        val converter = retrofit.responseBodyConverter<ApiError>(ApiError::class.java, arrayOf())

        return try {
            converter.convert(response.errorBody())
        }
        catch (error: IOException) {
            ApiError()
        }
    }
}