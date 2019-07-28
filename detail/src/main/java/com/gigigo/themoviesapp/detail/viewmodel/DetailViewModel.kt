package com.gigigo.themoviesapp.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gigigo.themoviesapp.base.ui.Result
import com.gigigo.themoviesapp.base.viewmodel.BaseViewModel
import com.gigigo.themoviesapp.detail.domain.model.MovieDetail
import com.gigigo.themoviesapp.detail.domain.usecases.GetMovieDetail
import com.gigigo.themoviesapp.home.navigation.DetailCoordinator
import kotlinx.coroutines.launch

class DetailViewModel(
    private val coordinator: DetailCoordinator,
    private val getMovieDetail: GetMovieDetail
) : BaseViewModel() {

    private val _movieDetail = MutableLiveData<Result<MovieDetail>>()
    val movieDetail: LiveData<Result<MovieDetail>>
        get() = _movieDetail

    fun loadMovieDetail(movieId: Int) {
        scope.launch {
            _movieDetail.postValue(Result.Loading)

            getMovieDetail(GetMovieDetail.Params.withParams(movieId)).fold(
                {
                    _movieDetail.postValue(Result.Error(it))
                },
                {
                    _movieDetail.postValue(Result.Success(it))
                }
            )
        }
    }
}