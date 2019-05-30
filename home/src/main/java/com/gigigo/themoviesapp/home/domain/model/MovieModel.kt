package com.gigigo.themoviesapp.home.domain.model

import java.io.Serializable

data class Movie(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

data class LatestMovie (
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Int,
    val posterPath: String,
    val productionCompanies: List<Any> ,
    val productionCountries: List<Any>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<Any>,
    val status: String,
    val tagLine: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Int,
    val voteCount: Int
) {
    data class Genre(
        val id: Int,
        val name: String
    )
}

enum class MediaType constructor(val type: String) : Serializable {
    ALL("all"),
    MOVIE("movie"),
    TV("tv"),
    PERSON("person");

    companion object {
        fun convertStringToEnum(str: String?): MediaType {
            MediaType.values().forEach { mediaType ->
                return mediaType.type.takeIf { it.equals(str, ignoreCase = true) }.let { mediaType }
            }
            return ALL
        }
    }
}

enum class TimeWindow constructor(val time: String) : Serializable {
    DAY("day"),
    WEEK("week");

    companion object {
        fun convertStringToEnum(str: String?): TimeWindow {
            TimeWindow.values().forEach { timeWindow ->
                return timeWindow.time.takeIf { it.equals(str, ignoreCase = true) }
                    .let { timeWindow }
            }
            return WEEK
        }
    }
}

