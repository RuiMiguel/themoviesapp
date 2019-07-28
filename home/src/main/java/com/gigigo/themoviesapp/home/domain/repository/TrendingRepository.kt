package com.gigigo.themoviesapp.home.domain.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.domain.model.MediaType
import com.gigigo.themoviesapp.base.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.TimeWindow
import com.gigigo.themoviesapp.home.domain.model.TrendingMovie

interface TrendingRepository {
    fun getTrending(
        mediaType: MediaType,
        timeWindow: TimeWindow
    ): Either<Failure, Page<out TrendingMovie>>
}