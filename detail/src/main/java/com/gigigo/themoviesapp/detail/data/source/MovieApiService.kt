package com.gigigo.themoviesapp.detail.data.source

import com.gigigo.themoviesapp.detail.data.model.ApiMovieDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    companion object {
        private const val DETAIL = "movie/{movie_id}"
    }

    @GET(DETAIL)
    fun getDetail(
        @Path("movie_id") movieId: Int,
        @Query("language") time: String,
        @Query("api_key") apiKey: String
    ): Call<ApiMovieDetail>
}