package com.gigigo.themoviesapp.home.data.source

import com.gigigo.themoviesapp.home.data.model.ApiPage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/trending/{media_type}/{time_window}")
    fun getTrending(@Path("media_type") media: Int, @Path("time_window") time: Int): Call<ApiPage>
}