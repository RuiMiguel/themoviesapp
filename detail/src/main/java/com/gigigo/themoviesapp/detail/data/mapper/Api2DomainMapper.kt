package com.gigigo.themoviesapp.detail.data.mapper

import com.gigigo.themoviesapp.base.data.mapper.toCompany
import com.gigigo.themoviesapp.base.data.mapper.toCountry
import com.gigigo.themoviesapp.base.data.mapper.toGenre
import com.gigigo.themoviesapp.base.data.mapper.toLanguage
import com.gigigo.themoviesapp.detail.data.model.ApiMovieDetail
import com.gigigo.themoviesapp.detail.domain.model.MovieDetail

fun ApiMovieDetail.toMovieDetail(): MovieDetail {
    return MovieDetail(
        adult = adult ?: false,
        backdropPath = backdropPath ?: "",
        belongsToCollection = belongsToCollection ?: "",
        budget = budget ?: 0,
        genres = this.genres?.map { it.toGenre() } ?: emptyList(),
        homepage = homepage ?: "",
        id = id ?: 0,
        imdbId = imdbId ?: "", //minLength: 9 maxLength: 9 pattern: ^tt[0-9]{7}
        originalLanguage = originalLanguage ?: "",
        originalTitle = originalTitle ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        posterPath = posterPath ?: "",
        productionCompanies = this.productionCompanies?.map { it.toCompany() } ?: emptyList(),
        productionCountries = this.productionCountries?.map { it.toCountry() } ?: emptyList(),
        releaseDate = releaseDate ?: "",
        revenue = revenue ?: 0,
        runtime = runtime ?: 0,
        spokenLanguages = this.spokenLanguages?.map { it.toLanguage() } ?: emptyList(),
        status = status ?: "",
        tagline = tagline ?: "",
        title = title ?: "",
        video = video ?: false,
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0
    )
}