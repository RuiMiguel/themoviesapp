package com.gigigo.themoviesapp.home.data.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.data.source.NetworkDataSource
import com.gigigo.themoviesapp.home.domain.model.MediaType
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.TimeWindow
import com.gigigo.themoviesapp.home.domain.repository.TrendingRepository

class TrendingDataRepository(
    private val networkDataSource: NetworkDataSource
) : TrendingRepository {
    override fun getTrending(mediaType: MediaType, timeWindow: TimeWindow): Either<Failure, Page<Movie>> {
        return networkDataSource.getTrending(mediaType.type, timeWindow.time)
    }
}