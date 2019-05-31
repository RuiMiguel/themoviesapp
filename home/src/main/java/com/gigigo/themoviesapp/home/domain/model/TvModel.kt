package com.gigigo.themoviesapp.home.domain.model

data class Tv(
    val backdropPath: String,
    val firstAirDate: String,
    val genreIds: List<Int>,
    val id: Int,
    val name: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)

data class LatestTv(
    val backdropPath: String,
    val createdBy: List<String>,
    val episodeRunTime: List<Int>,
    val firstAirDate: String,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val inProduction: Boolean,
    val languages: List<String>,
    val lastAirDate: String,
    val name: String,
    val networks: List<Network>,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Int,
    val posterPath: String,
    val productionCompanies: List<String>,
    val seasons: List<Season>,
    val status: String,
    val type: String,
    val voteAverage: Double,
    val voteCount: Int
) {
    data class Network(
        val id: Int,
        val name: String
    )

    data class Season(
        val airDate: String,
        val episodeCount: Int,
        val id: Int,
        val posterPath: String,
        val seasonNumber: Int
    )

    data class Genre(
        val id: Int,
        val name: String
    )
}