package com.gigigo.themoviesapp.home.domain.model

import com.gigigo.themoviesapp.base.domain.model.Company
import com.gigigo.themoviesapp.base.domain.model.Country
import com.gigigo.themoviesapp.base.domain.model.Genre
import com.gigigo.themoviesapp.base.domain.model.Language
import java.io.Serializable

open class Movie(
    open val adult: Boolean,
    open val backdropPath: String,
    open val genreIds: List<Int>,
    open val id: Int,
    open val originalLanguage: String,
    open val originalTitle: String,
    open val overview: String,
    open val popularity: Double,
    open val posterPath: String,
    open val releaseDate: String,
    open val title: String,
    open val video: Boolean,
    open val voteAverage: Double,
    open val voteCount: Int
)

data class NowPlayingMovie(
    override val adult: Boolean,
    override val backdropPath: String,
    override val genreIds: List<Int>,
    override val id: Int,
    override val originalLanguage: String,
    override val originalTitle: String,
    override val overview: String,
    override val popularity: Double,
    override val posterPath: String,
    override val releaseDate: String,
    override val title: String,
    override val video: Boolean,
    override val voteAverage: Double,
    override val voteCount: Int
) : Movie(
    adult,
    backdropPath,
    genreIds,
    id,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    releaseDate,
    title,
    video,
    voteAverage,
    voteCount
)

data class PopularMovie(
    override val adult: Boolean,
    override val backdropPath: String,
    override val genreIds: List<Int>,
    override val id: Int,
    override val originalLanguage: String,
    override val originalTitle: String,
    override val overview: String,
    override val popularity: Double,
    override val posterPath: String,
    override val releaseDate: String,
    override val title: String,
    override val video: Boolean,
    override val voteAverage: Double,
    override val voteCount: Int
) : Movie(
    adult,
    backdropPath,
    genreIds,
    id,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    releaseDate,
    title,
    video,
    voteAverage,
    voteCount
)

data class TopRatedMovie(
    override val adult: Boolean,
    override val backdropPath: String,
    override val genreIds: List<Int>,
    override val id: Int,
    override val originalLanguage: String,
    override val originalTitle: String,
    override val overview: String,
    override val popularity: Double,
    override val posterPath: String,
    override val releaseDate: String,
    override val title: String,
    override val video: Boolean,
    override val voteAverage: Double,
    override val voteCount: Int
) : Movie(
    adult,
    backdropPath,
    genreIds,
    id,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    releaseDate,
    title,
    video,
    voteAverage,
    voteCount
)

data class TrendingMovie(
    override val adult: Boolean,
    override val backdropPath: String,
    override val genreIds: List<Int>,
    override val id: Int,
    override val originalLanguage: String,
    override val originalTitle: String,
    override val overview: String,
    override val popularity: Double,
    override val posterPath: String,
    override val releaseDate: String,
    override val title: String,
    override val video: Boolean,
    override val voteAverage: Double,
    override val voteCount: Int
) : Movie(
    adult,
    backdropPath,
    genreIds,
    id,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    releaseDate,
    title,
    video,
    voteAverage,
    voteCount
)

data class UpcomingMovie(
    override val adult: Boolean,
    override val backdropPath: String,
    override val genreIds: List<Int>,
    override val id: Int,
    override val originalLanguage: String,
    override val originalTitle: String,
    override val overview: String,
    override val popularity: Double,
    override val posterPath: String,
    override val releaseDate: String,
    override val title: String,
    override val video: Boolean,
    override val voteAverage: Double,
    override val voteCount: Int
) : Movie(
    adult,
    backdropPath,
    genreIds,
    id,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    releaseDate,
    title,
    video,
    voteAverage,
    voteCount
)

data class LatestMovie(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: String,
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
    val productionCompanies: List<Company>,
    val productionCountries: List<Country>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<Language>,
    val status: String,
    val tagLine: String,
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
                return timeWindow.time.takeIf { it.equals(str, ignoreCase = true) }
                    .let { timeWindow }
            }
            return WEEK
        }
    }
}

