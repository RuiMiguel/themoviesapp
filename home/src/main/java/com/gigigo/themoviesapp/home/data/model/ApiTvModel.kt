package com.gigigo.themoviesapp.home.data.model

import com.google.gson.annotations.SerializedName

data class ApiTv(
    @SerializedName("backdrop_path") val backdropPath: String = "",
    @SerializedName("first_air_date") val firstAirDate: String = "",
    @SerializedName("genre_ids") val genreIds: List<Int> = listOf(),
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("origin_country") val originCountry: List<String> = listOf(),
    @SerializedName("original_language") val originalLanguage: String = "",
    @SerializedName("original_name") val originalName: String = "",
    @SerializedName("overview") val overview: String = "",
    @SerializedName("popularity") val popularity: Double = 0.0,
    @SerializedName("poster_path") val posterPath: String = "",
    @SerializedName("vote_average") val voteAverage: Int = 0,
    @SerializedName("vote_count") val voteCount: Int = 0
)

data class ApiLatestTv(
    @SerializedName("backdrop_path") val backdropPath: Any? = Any(),
    @SerializedName("created_by") val createdBy: List<Any> = listOf(),
    @SerializedName("episode_run_time") val episodeRunTime: List<Int> = listOf(),
    @SerializedName("first_air_date") val firstAirDate: String = "",
    @SerializedName("genres") val genres: List<Genre> = listOf(),
    @SerializedName("homepage") val homepage: String = "",
    @SerializedName("id") val id: Int = 0,
    @SerializedName("in_production") val inProduction: Boolean = false,
    @SerializedName("languages") val languages: List<String> = listOf(),
    @SerializedName("last_air_date") val lastAirDate: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("networks") val networks: List<Network> = listOf(),
    @SerializedName("number_of_episodes") val numberOfEpisodes: Int = 0,
    @SerializedName("number_of_seasons") val numberOfSeasons: Int = 0,
    @SerializedName("origin_country") val originCountry: List<String> = listOf(),
    @SerializedName("original_language") val originalLanguage: String = "",
    @SerializedName("original_name") val originalName: String = "",
    @SerializedName("overview") val overview: Any? = Any(),
    @SerializedName("popularity") val popularity: Int = 0,
    @SerializedName("poster_path") val posterPath: Any? = Any(),
    @SerializedName("production_companies") val productionCompanies: List<Any> = listOf(),
    @SerializedName("seasons") val seasons: List<Season> = listOf(),
    @SerializedName("status") val status: String = "",
    @SerializedName("type") val type: String = "",
    @SerializedName("vote_average") val voteAverage: Int = 0,
    @SerializedName("vote_count") val voteCount: Int = 0
) {
    data class Network(
        @SerializedName("id") val id: Int = 0,
        @SerializedName("name") val name: String = ""
    )

    data class Season(
        @SerializedName("air_date") val airDate: String = "",
        @SerializedName("episode_count") val episodeCount: Int = 0,
        @SerializedName("id") val id: Int = 0,
        @SerializedName("poster_path") val posterPath: Any? = Any(),
        @SerializedName("season_number") val seasonNumber: Int = 0
    )

    data class Genre(
        @SerializedName("id") val id: Int = 0,
        @SerializedName("name") val name: String = ""
    )
}