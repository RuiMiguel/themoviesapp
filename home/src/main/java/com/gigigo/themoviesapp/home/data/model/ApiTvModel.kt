package com.gigigo.themoviesapp.home.data.model

import com.gigigo.themoviesapp.base.data.model.ApiGenre
import com.google.gson.annotations.SerializedName

data class ApiTv(
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("first_air_date") val firstAirDate: String? = null,
    @SerializedName("genre_ids") val genreIds: List<Int>? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("origin_country") val originCountry: List<String>? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_name") val originalName: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("popularity") val popularity: Double? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null
)

data class ApiLatestTv(
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("created_by") val createdBy: List<String>? = null,
    @SerializedName("episode_run_time") val episodeRunTime: List<Int>? = null,
    @SerializedName("first_air_date") val firstAirDate: String? = null,
    @SerializedName("genres") val genres: List<ApiGenre>? = null,
    @SerializedName("homepage") val homepage: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("in_production") val inProduction: Boolean? = null,
    @SerializedName("languages") val languages: List<String>? = null,
    @SerializedName("last_air_date") val lastAirDate: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("networks") val networks: List<ApiNetwork>? = null,
    @SerializedName("number_of_episodes") val numberOfEpisodes: Int? = null,
    @SerializedName("number_of_seasons") val numberOfSeasons: Int? = null,
    @SerializedName("origin_country") val originCountry: List<String>? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_name") val originalName: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("popularity") val popularity: Int? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("production_companies") val productionCompanies: List<String>? = null,
    @SerializedName("seasons") val seasons: List<ApiSeason>? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null
) {
    data class ApiNetwork(
        @SerializedName("id") val id: Int? = null,
        @SerializedName("name") val name: String? = null
    )

    data class ApiSeason(
        @SerializedName("air_date") val airDate: String? = null,
        @SerializedName("episode_count") val episodeCount: Int? = null,
        @SerializedName("id") val id: Int? = null,
        @SerializedName("poster_path") val posterPath: String? = null,
        @SerializedName("season_number") val seasonNumber: Int? = null
    )
}