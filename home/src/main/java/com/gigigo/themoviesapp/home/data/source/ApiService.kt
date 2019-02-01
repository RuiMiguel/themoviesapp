package com.gigigo.themoviesapp.home.data.source

import com.gigigo.themoviesapp.home.data.model.ApiPage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("trending/{media_type}/{time_window}")
    fun getTrending(@Path("media_type") media: String, @Path("time_window") time: String, @Query("api_key") apiKey: String): Call<ApiPage>
}