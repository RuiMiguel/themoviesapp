package com.gigigo.themoviesapp.home.data.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.home.data.source.TvNetworkDataSource
import com.gigigo.themoviesapp.home.domain.model.LatestTv
import com.gigigo.themoviesapp.home.domain.model.Page
import com.gigigo.themoviesapp.home.domain.model.Tv
import com.gigigo.themoviesapp.home.domain.repository.TvRepository

class TvDataRepository(
    private val networkDataSource: TvNetworkDataSource
) : TvRepository {

    override fun getLatest(time: String): Either<Failure, LatestTv> {
        return networkDataSource.getLatest(time)
    }

    override fun getAiringToday(
        language: String,
        page: Int
    ): Either<Failure, Page<Tv>> {
        return networkDataSource.getAiringToday(language, page)
    }

    override fun getOnTheAir(
        language: String,
        page: Int
    ): Either<Failure, Page<Tv>> {
        return networkDataSource.getOnTheAir(language, page)
    }

    override fun getPopular(
        language: String,
        page: Int
    ): Either<Failure, Page<Tv>> {
        return networkDataSource.getPopular(language, page)
    }

    override fun getTopRated(
        language: String,
        page: Int
    ): Either<Failure, Page<Tv>> {
        return networkDataSource.getTopRated(language, page)
    }
}