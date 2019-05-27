package com.gigigo.themoviesapp.splash.domain.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.splash.domain.model.Configuration

interface ConfigurationRepository {
    fun getConfiguration(): Either<Failure, Configuration>
}