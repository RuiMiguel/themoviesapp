package com.gigigo.themoviesapp.base.ui

import com.gigigo.themoviesapp.base.domain.error.Failure

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Failure) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[error=$error]"
            Loading -> "Loading"
        }
    }

    val succeeded
        get() = this is Success && data != null
}