package com.gigigo.themoviesapp.detail.domain.model

import com.gigigo.themoviesapp.base.domain.model.Company
import com.gigigo.themoviesapp.base.domain.model.Country
import com.gigigo.themoviesapp.base.domain.model.Genre
import com.gigigo.themoviesapp.base.domain.model.Language

data class MovieDetail(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    val productionCompanies: List<Company>,
    val productionCountries: List<Country>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<Language>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)