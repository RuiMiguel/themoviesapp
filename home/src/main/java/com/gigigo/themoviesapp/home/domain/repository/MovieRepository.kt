package com.gigigo.themoviesapp.home.domain.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.Page

interface MovieRepository {
    fun getLatest(language: String): Either<Failure, LatestMovie>

    fun getNowPlaying(language: String, page: Int, region: String): Either<Failure, Page<Movie>>

    fun getPopular(language: String, page: Int, region: String): Either<Failure, Page<Movie>>

    fun getTopRated(language: String, page: Int, region: String): Either<Failure, Page<Movie>>

    fun getUpcoming(language: String, page: Int, region: String): Either<Failure, Page<Movie>>
}