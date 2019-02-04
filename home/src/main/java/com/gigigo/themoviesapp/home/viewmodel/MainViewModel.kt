package com.gigigo.themoviesapp.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.usecases.GetTrending
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val getTrending: GetTrending) : ViewModel(), CoroutineScope {
    private val _job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + _job

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _loading

    private val _trendingMovies = MutableLiveData<List<Movie>>()
    val trendingMovies: LiveData<List<Movie>>
        get() = _trendingMovies

    fun loadTrendings() {
        launch {
            _loading.postValue(true)

            getTrending().fold(
                {
                    _loading.postValue(false)

                },
                {
                    _loading.postValue(false)
                    _trendingMovies.postValue(it)
                }
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        _job.cancel()
    }
}