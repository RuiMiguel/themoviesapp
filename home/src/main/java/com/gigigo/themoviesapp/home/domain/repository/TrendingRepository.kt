package com.gigigo.themoviesapp.home.domain.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.domain.model.MediaType
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.TimeWindow

interface TrendingRepository {
    fun getTrending(mediaType: MediaType, timeWindow: TimeWindow): Either<Failure, Page>
}