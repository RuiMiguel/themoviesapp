package com.gigigo.themoviesapp.base.data.model

import com.google.gson.annotations.SerializedName

data class ApiPage<Data>(
    val page: Int? = null,
    val results: List<Data>? = null,
    @SerializedName("total_pages") val total_pages: Int? = null,
    @SerializedName("total_results") val total_results: Int? = null
)

data class ApiGenre(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null
)

data class ApiLanguage(
    @SerializedName("iso_639_1") val id: String? = null,
    @SerializedName("name") val name: String? = null
)

data class ApiCountry(
    @SerializedName("iso_3166_1") val id: String? = null,
    @SerializedName("name") val name: String? = null
)

data class ApiCompany(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("logo_path") val logoPath: String? = null,
    @SerializedName("origin_country") val originCountry: String? = null
)