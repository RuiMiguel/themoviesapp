package com.gigigo.themoviesapp.splash.data.source

import com.gigigo.themoviesapp.splash.data.model.ApiConfiguration
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("configuration")
    fun getConfiguration(
        @Query("api_key") apiKey: String
    ): Call<ApiConfiguration>
}