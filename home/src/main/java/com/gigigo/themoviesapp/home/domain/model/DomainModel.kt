package com.gigigo.themoviesapp.home.domain.model

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