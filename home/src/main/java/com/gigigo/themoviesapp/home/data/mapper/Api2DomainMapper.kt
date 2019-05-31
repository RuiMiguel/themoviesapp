package com.gigigo.themoviesapp.home.data.mapper

import com.gigigo.themoviesapp.home.data.model.ApiLatestMovie
import com.gigigo.themoviesapp.home.data.model.ApiLatestTv
import com.gigigo.themoviesapp.home.data.model.ApiMovie
import com.gigigo.themoviesapp.home.data.model.ApiPage
import com.gigigo.themoviesapp.home.data.model.ApiTv
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.LatestTv
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.Tv

fun ApiPage<ApiMovie>.toPageMovie(): Page<Movie> {
    return Page(
        page = this.page ?: 0,
        results = this.results?.map { it.toMovie() } ?: emptyList(),
        totalPages = this.total_pages ?: 0,
        totalResults = this.total_results ?: 0
    )
}

fun ApiPage<ApiTv>.toPageTv(): Page<Tv> {
    return Page(
        page = this.page ?: 0,
        results = this.results?.map { it.toTv() } ?: emptyList(),
        totalPages = this.total_pages ?: 0,
        totalResults = this.total_results ?: 0
    )
}

fun ApiMovie.toMovie(): Movie {
    return Movie(
        adult = this.adult ?: false,
        backdropPath = this.backdropPath ?: "",
        genreIds = this.genreIds ?: emptyList(),
        id = this.id ?: 0,
        originalLanguage = this.originalLanguage ?: "",
        originalTitle = this.originalTitle ?: "",
        overview = this.overview ?: "",
        popularity = this.popularity ?: 0.0,
        posterPath = this.posterPath ?: "",
        releaseDate = this.releaseDate ?: "",
        title = this.title ?: "",
        video = this.video ?: false,
        voteAverage = this.voteAverage ?: 0.0,
        voteCount = this.voteCount ?: 0
    )
}

fun ApiTv.toTv(): Tv {
    return Tv(
        backdropPath = this.backdropPath ?: "",
        firstAirDate = this.firstAirDate ?: "",
        genreIds = this.genreIds ?: emptyList(),
        id = this.id ?: 0,
        name = this.name ?: "",
        originCountry = this.originCountry ?: emptyList(),
        originalLanguage = this.originalLanguage ?: "",
        originalName = this.originalName ?: "",
        overview = this.overview ?: "",
        popularity = this.popularity ?: 0.0,
        posterPath = this.posterPath ?: "",
        voteAverage = this.voteAverage ?: 0.0,
        voteCount = this.voteCount ?: 0
    )
}

fun ApiLatestMovie.toLatestMovie(): LatestMovie {
    return LatestMovie(
        adult = this.adult ?: false,
        backdropPath = this.backdropPath ?: "",
        belongsToCollection = this.belongsToCollection ?: "",
        budget = this.budget ?: 0,
        genres = this.genres?.map { it.toGenre() } ?: emptyList(),
        homepage = this.homepage ?: "",
        id = this.id ?: 0,
        imdbId = this.imdbId ?: "",
        originalLanguage = this.originalLanguage ?: "",
        originalTitle = this.originalTitle ?: "",
        overview = this.overview ?: "",
        popularity = this.popularity ?: 0,
        posterPath = this.posterPath ?: "",
        productionCompanies = this.productionCompanies ?: emptyList(),
        productionCountries = this.productionCountries ?: emptyList(),
        releaseDate = this.releaseDate ?: "",
        revenue = this.revenue ?: 0,
        runtime = this.runtime ?: 0,
        spokenLanguages = this.spokenLanguages ?: emptyList(),
        status = this.status ?: "",
        tagLine = this.tagLine ?: "",
        title = this.title ?: "",
        video = this.video ?: false,
        voteAverage = this.voteAverage ?: 0.0,
        voteCount = this.voteCount ?: 0
    )
}

fun ApiLatestTv.toLatestTv(): LatestTv {
    return LatestTv(
        backdropPath = this.backdropPath ?: "",
        createdBy = this.createdBy ?: emptyList(),
        episodeRunTime = this.episodeRunTime ?: emptyList(),
        firstAirDate = this.firstAirDate ?: "",
        genres = this.genres?.map { it.toGenre() } ?: emptyList(),
        homepage = this.homepage ?: "",
        id = this.id ?: 0,
        inProduction = this.inProduction ?: false,
        languages = this.languages ?: emptyList(),
        lastAirDate = this.lastAirDate ?: "",
        name = this.name ?: "",
        networks = this.networks?.map { it.toNetwork() } ?: emptyList(),
        numberOfEpisodes = this.numberOfEpisodes ?: 0,
        numberOfSeasons = this.numberOfSeasons ?: 0,
        originCountry = this.originCountry ?: emptyList(),
        originalLanguage = this.originalLanguage ?: "",
        originalName = this.originalName ?: "",
        overview = this.overview ?: "",
        popularity = this.popularity ?: 0,
        posterPath = this.posterPath ?: "",
        productionCompanies = this.productionCompanies ?: emptyList(),
        seasons = this.seasons?.map { it.toSeason() } ?: emptyList(),
        status = this.status ?: "",
        type = this.type ?: "",
        voteAverage = this.voteAverage ?: 0.0,
        voteCount = this.voteCount ?: 0
    )
}

fun ApiLatestMovie.ApiGenre.toGenre(): LatestMovie.Genre {
    return LatestMovie.Genre(
        id = this.id ?: 0,
        name = this.name ?: ""
    )
}

fun ApiLatestTv.ApiGenre.toGenre(): LatestTv.Genre {
    return LatestTv.Genre(
        id = this.id ?: 0,
        name = this.name ?: ""
    )
}

fun ApiLatestTv.ApiNetwork.toNetwork(): LatestTv.Network {
    return LatestTv.Network(
        id = this.id ?: 0,
        name = this.name ?: ""
    )
}

fun ApiLatestTv.ApiSeason.toSeason(): LatestTv.Season {
    return LatestTv.Season(
        airDate = this.airDate ?: "",
        episodeCount = this.episodeCount ?: 0,
        id = this.id ?: 0,
        posterPath = this.posterPath ?: "",
        seasonNumber = this.seasonNumber ?: 0
    )
}