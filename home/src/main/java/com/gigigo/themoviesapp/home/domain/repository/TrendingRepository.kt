package com.gigigo.themoviesapp.home.domain.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.domain.model.Page

interface TrendingRepository {
    fun getTrending(media: Int, time: Int): Either<Failure, Page>
}