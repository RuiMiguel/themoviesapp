package com.gigigo.themoviesapp.home.data.mapper

import com.gigigo.themoviesapp.base.data.mapper.toCompany
import com.gigigo.themoviesapp.base.data.mapper.toCountry
import com.gigigo.themoviesapp.base.data.mapper.toGenre
import com.gigigo.themoviesapp.base.data.mapper.toLanguage
import com.gigigo.themoviesapp.home.data.model.ApiLatestMovie
import com.gigigo.themoviesapp.home.data.model.ApiLatestTv
import com.gigigo.themoviesapp.home.data.model.ApiMovie
import com.gigigo.themoviesapp.base.data.model.ApiPage
import com.gigigo.themoviesapp.home.data.model.ApiTv
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.LatestTv
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.NowPlayingMovie
import com.gigigo.themoviesapp.base.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.PopularMovie
import com.gigigo.themoviesapp.home.domain.model.TopRatedMovie
import com.gigigo.themoviesapp.home.domain.model.TrendingMovie
import com.gigigo.themoviesapp.home.domain.model.Tv
import com.gigigo.themoviesapp.home.domain.model.UpcomingMovie

inline fun <reified T : Movie> ApiPage<ApiMovie>.toPageMovie(): Page<T> {
    return Page(
        page = this.page ?: 0,
        results = this.results?.map { it.toMovie<T>() } ?: emptyList(),
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

inline fun <reified T : Movie> ApiMovie.toMovie(): T {
    return when (T::class) {
        NowPlayingMovie::class -> this.toNowPlayingMovie()
        PopularMovie::class -> this.toPopularMovie()
        TopRatedMovie::class -> this.toTopRatedMovie()
        TrendingMovie::class -> this.toTrendingMovie()
        UpcomingMovie::class -> this.toUpcomingMovie()
        else -> null
    } as T
}

fun ApiMovie.toNowPlayingMovie(): NowPlayingMovie {
    return NowPlayingMovie(
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

fun ApiMovie.toPopularMovie(): PopularMovie {
    return PopularMovie(
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

fun ApiMovie.toTopRatedMovie(): TopRatedMovie {
    return TopRatedMovie(
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

fun ApiMovie.toTrendingMovie(): TrendingMovie {
    return TrendingMovie(
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

fun ApiMovie.toUpcomingMovie(): UpcomingMovie {
    return UpcomingMovie(
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
        productionCompanies = this.productionCompanies?.map { it.toCompany() } ?: emptyList(),
        productionCountries = this.productionCountries?.map { it.toCountry() } ?: emptyList(),
        releaseDate = this.releaseDate ?: "",
        revenue = this.revenue ?: 0,
        runtime = this.runtime ?: 0,
        spokenLanguages = this.spokenLanguages?.map { it.toLanguage() } ?: emptyList(),
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