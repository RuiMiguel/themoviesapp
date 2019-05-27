package com.gigigo.themoviesapp.splash.data.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.splash.domain.model.Configuration
import com.gigigo.themoviesapp.splash.domain.repository.ConfigurationRepository
import com.gigigo.themoviesapp.splash.data.source.NetworkDataSource

class ConfigurationDataRepository(
    private val networkDataSource: NetworkDataSource
) : ConfigurationRepository {
    override fun getConfiguration(): Either<Failure, Configuration> {
        return networkDataSource.getConfiguration()
    }
}