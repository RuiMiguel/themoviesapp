package com.gigigo.themoviesapp.home.domain.model

import java.io.Serializable

data class Page(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)

data class Movie(
    val adult: Boolean,
    val backdropPath: String,
    val firstAirDate: String,
    val genreIds: List<Int>,
    val id: Int,
    val name: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
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
                return timeWindow.time.takeIf { it.equals(str, ignoreCase = true) }.let { timeWindow }
            }
            return WEEK
        }
    }
}