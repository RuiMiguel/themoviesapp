package com.gigigo.themoviesapp.home.data.source

import com.gigigo.themoviesapp.home.data.model.ApiLatestTv
import com.gigigo.themoviesapp.home.data.model.ApiPage
import com.gigigo.themoviesapp.home.data.model.ApiTv
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvApiService {
    companion object {
        private const val LATEST = "tv/latest"
        private const val AIRING_TODAY = "tv/airing_today"
        private const val ON_THE_AIR = "tv/on_the_air"
        private const val POPULAR = "tv/popular"
        private const val TOP_RATED = "tv/top_rated"
    }

    @GET(LATEST)
    fun getLatest(
        @Path("language") time: String,
        @Query("api_key") apiKey: String
    ): Call<ApiLatestTv>

    @GET(AIRING_TODAY)
    fun getAiringToday(
        @Path("language") time: String,
        @Path("page") page: Int,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiTv>>

    @GET(ON_THE_AIR)
    fun getOnTheAir(
        @Path("language") time: String,
        @Path("page") page: Int,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiTv>>

    @GET(POPULAR)
    fun getPopular(
        @Path("language") time: String,
        @Path("page") page: Int,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiTv>>

    @GET(TOP_RATED)
    fun getTopRated(
        @Path("language") time: String,
        @Path("page") page: Int,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiTv>>
}