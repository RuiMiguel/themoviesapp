package com.gigigo.themoviesapp.home.data.model

import com.google.gson.annotations.SerializedName

data class ApiPage<Data>(
    val page: Int = 0,
    val results: List<Data> = emptyList(),
    @SerializedName("total_pages") val total_pages: Int = 0,
    @SerializedName("total_results") val total_results: Int = 0
)