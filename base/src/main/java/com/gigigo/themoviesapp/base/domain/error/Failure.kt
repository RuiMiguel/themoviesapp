package com.gigigo.themoviesapp.base.domain.error

sealed class Failure {
    class GenericError(message: String? = null) : Failure()
    class ServerError(message: String?) : Failure()
    class NetworkFailure(message: String?) : Failure()

    abstract class FeatureFailure(message: String?) : Failure()
}