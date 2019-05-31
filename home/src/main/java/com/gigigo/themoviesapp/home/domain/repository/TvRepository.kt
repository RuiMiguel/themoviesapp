package com.gigigo.themoviesapp.home.domain.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.domain.model.LatestTv
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.Tv

interface TvRepository {
    fun getLatest(time: String): Either<Failure, LatestTv>

    fun getAiringToday(language: String, page: Int): Either<Failure, Page<Tv>>

    fun getOnTheAir(language: String, page: Int): Either<Failure, Page<Tv>>

    fun getPopular(language: String, page: Int): Either<Failure, Page<Tv>>

    fun getTopRated(language: String, page: Int): Either<Failure, Page<Tv>>
}