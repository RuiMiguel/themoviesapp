package com.gigigo.themoviesapp.home.data.model

import com.google.gson.annotations.SerializedName

data class ApiMovie(
    @SerializedName("adult") val adult: Boolean? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("genre_ids") val genreIds: List<Int>? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("popularity") val popularity: Double? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("video") val video: Boolean? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null
)

data class ApiLatestMovie(
    @SerializedName("adult") val adult: Boolean? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("belongs_to_collection") val belongsToCollection: String? = null,
    @SerializedName("budget") val budget: Int? = null,
    @SerializedName("genres") val genres: List<ApiGenre>? = null,
    @SerializedName("homepage") val homepage: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("imdb_id") val imdbId: String? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("popularity") val popularity: Int? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("production_companies") val productionCompanies: List<String>? = null,
    @SerializedName("production_countries") val productionCountries: List<ApiCountry>? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("revenue") val revenue: Int? = null,
    @SerializedName("runtime") val runtime: Int? = null,
    @SerializedName("spoken_languages") val spokenLanguages: List<String>? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("tagline") val tagLine: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("video") val video: Boolean? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null
) {
    data class ApiGenre(
        @SerializedName("id") val id: Int? = null,
        @SerializedName("name") val name: String? = null
    )

    data class ApiCountry(
        @SerializedName("iso_3166_1") val id: String? = null,
        @SerializedName("name") val name: String? = null
    )
}