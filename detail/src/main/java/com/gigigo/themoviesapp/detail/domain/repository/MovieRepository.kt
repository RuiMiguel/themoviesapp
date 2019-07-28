package com.gigigo.themoviesapp.detail.domain.repository

import arrow.core.Either
import com.gigigo.themoviesapp.base.domain.error.Failure
import com.gigigo.themoviesapp.detail.domain.model.MovieDetail

interface MovieRepository {
    fun getDetail(movieId: Int, language: String): Either<Failure, MovieDetail>
}