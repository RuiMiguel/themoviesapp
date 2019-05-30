package com.gigigo.themoviesapp.home.data.source

import com.gigigo.themoviesapp.home.data.model.ApiLatestMovie
import com.gigigo.themoviesapp.home.data.model.ApiMovie
import com.gigigo.themoviesapp.home.data.model.ApiPage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    companion object {
        private const val LATEST = "movie/latest"
        private const val NOW_PLAYING = "movie/now_playing"
        private const val POPULAR = "movie/popular"
        private const val TOP_RATED = "movie/top_rated"
        private const val UPCOMING = "movie/upcoming"
    }

    @GET(LATEST)
    fun getLatest(
        @Path("language") time: String,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiLatestMovie>>

    @GET(NOW_PLAYING)
    fun getNowPlaying(
        @Path("language") time: String,
        @Path("page") page: Int,
        @Path("region") region: String,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiMovie>>

    @GET(POPULAR)
    fun getPopular(
        @Path("language") time: String,
        @Path("page") page: Int,
        @Path("region") region: String,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiMovie>>

    @GET(TOP_RATED)
    fun getTopRated(
        @Path("language") time: String,
        @Path("page") page: Int,
        @Path("region") region: String,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiMovie>>

    @GET(UPCOMING)
    fun getUpcoming(
        @Path("language") time: String,
        @Path("page") page: Int,
        @Path("region") region: String,
        @Query("api_key") apiKey: String
    ): Call<ApiPage<ApiMovie>>
}