package com.gigigo.themoviesapp.home.domain.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure

interface TrendingRepository {
    fun getTrending(media: Int, time: Int): Either<Failure, Unit>
}