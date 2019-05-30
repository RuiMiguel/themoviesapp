package com.gigigo.themoviesapp.home.data.model

import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.Page

fun ApiPage.toPage(): Page {
    return Page(
        page = this.page ?: 1,
        results = this.results?.map { it.toMovie() } ?: emptyList(),
        totalPages = this.total_pages ?: 1,
        totalResults = this.total_results ?: 0
    )
}

fun ApiMovie.toMovie(): Movie {
    return Movie(
        adult = this.adult ?: false,
        backdropPath = this.backdrop_path ?: "",
        firstAirDate = this.first_air_date ?: "",
        genreIds = this.genre_ids?.map { it } ?: emptyList(),
        id = this.id ?: 0,
        name = this.name ?: "",
        originCountry = this.origin_country ?: emptyList(),
        originalLanguage = this.original_language ?: "",
        originalName = this.original_name ?: "",
        originalTitle = this.original_title ?: "",
        overview = this.overview ?: "",
        popularity = this.popularity ?: 0.0,
        posterPath = this.poster_path ?: "",
        releaseDate = this.release_date ?: "",
        title = this.title ?: "",
        video = this.video ?: false,
        voteAverage = this.vote_average ?: 0.0,
        voteCount = this.vote_count ?: 0
    )
}