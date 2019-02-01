package com.gigigo.themoviesapp.base.domain.error

sealed class Failure {
    class GenericError(val message: String? = null) : Failure()
    class ServerError(val message: String?) : Failure()
    class NetworkFailure(val message: String?) : Failure()

    abstract class FeatureFailure(val message: String?) : Failure()
}