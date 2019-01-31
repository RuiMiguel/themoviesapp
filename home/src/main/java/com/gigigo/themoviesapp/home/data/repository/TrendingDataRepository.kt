package com.gigigo.themoviesapp.home.data.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.data.source.NetworkDataSource
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.repository.TrendingRepository

class TrendingDataRepository(
    private val networkDataSource: NetworkDataSource
) : TrendingRepository {
    override fun getTrending(media: Int, time: Int): Either<Failure, Page> {
        return networkDataSource.getTrending(media, time)
    }
}