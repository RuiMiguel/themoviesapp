package com.gigigo.themoviesapp.home.data.source

import com.gigigo.themoviesapp.home.data.model.ApiMovie
import com.gigigo.themoviesapp.base.data.model.ApiPage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    companion object {
        private const val TRENDING = "trending/{media_type}/{time_window}"
    }

    @GET(TRENDING)
    fun getTrending(
        @Path("media_type") media: String,
        @Path("time_window") time: String,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiMovie>>
}