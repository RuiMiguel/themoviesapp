package com.gigigo.themoviesapp.home.domain.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.NowPlayingMovie
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.PopularMovie
import com.gigigo.themoviesapp.home.domain.model.TopRatedMovie
import com.gigigo.themoviesapp.home.domain.model.UpcomingMovie

interface MovieRepository {
    fun getLatest(language: String): Either<Failure, LatestMovie>

    fun getNowPlaying(language: String, page: Int, region: String): Either<Failure, Page<out NowPlayingMovie>>

    fun getPopular(language: String, page: Int, region: String): Either<Failure, Page<out PopularMovie>>

    fun getTopRated(language: String, page: Int, region: String): Either<Failure, Page<out TopRatedMovie>>

    fun getUpcoming(language: String, page: Int, region: String): Either<Failure, Page<out UpcomingMovie>>
}