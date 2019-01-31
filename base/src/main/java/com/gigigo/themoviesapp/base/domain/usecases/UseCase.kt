package com.gigigo.themoviesapp.base.domain.usecases

import com.gigigo.themoviesapp.base.domain.error.Failure
import arrow.core.Either

abstract class UseCase<out Type, in Params> where Type : Any? {
    abstract fun run(params: Params? = null): Either<Failure, Type>

    @JvmOverloads
    operator fun invoke(
        params: Params? = null
    ): Either<Failure, Type> {
        return run(params)
    }
}