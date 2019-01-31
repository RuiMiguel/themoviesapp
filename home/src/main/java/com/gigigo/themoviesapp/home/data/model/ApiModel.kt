package com.gigigo.themoviesapp.home.data.model

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("status_message") val statusMessage: String?,
    val success: Boolean?,
    @SerializedName("status_code") val statusCode: Int?
)

data class ApiPage(
    val page: Int?,
    val results: List<ApiMovie>?,
    @SerializedName("total_pages") val total_pages: Int?,
    @SerializedName("total_results") val total_results: Int?
)

data class ApiMovie(
    val adult: Boolean?,
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName("first_air_date") val first_air_date: String?,
    @SerializedName("genre_ids") val genre_ids: List<Int>?,
    val id: Int?,
    val name: String?,
    @SerializedName("origin_country") val origin_country: List<String>?,
    @SerializedName("original_language") val original_language: String?,
    @SerializedName("original_name") val original_name: String?,
    @SerializedName("original_title") val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    @SerializedName("poster_path") val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    @SerializedName("vote_average") val vote_average: Double?,
    @SerializedName("vote_count") val vote_count: Int?
)