package com.gigigo.themoviesapp.splash.domain.usecases

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.splash.domain.model.Configuration
import com.gigigo.themoviesapp.splash.domain.repository.ConfigurationRepository
import com.gigigo.themoviesapp.base.domain.usecases.UseCase

class GetConfiguration(private val configurationRepository: ConfigurationRepository) :
    UseCase<Configuration, Unit>() {
    override fun run(params: Unit?): Either<Failure, Configuration> {
        val response =
            configurationRepository.getConfiguration()
        return response.fold(::onHandleError, ::onHandleSuccess)

        /*
        return Try {
            val trendingParams = params ?: defaultParams()
            trendingRepository.getTrending(trendingParams.media, trendingParams.time)
        }.getOrElse {
            Left(Failure.GenericError(it.message))
        }
        */
    }

    private fun onHandleError(failure: Failure): Either<Failure, Configuration> = failure.left()
    private fun onHandleSuccess(data: Configuration): Either<Failure, Configuration> = data.right()
}