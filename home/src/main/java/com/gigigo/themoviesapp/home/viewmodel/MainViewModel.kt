package com.gigigo.themoviesapp.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.usecases.GetLatestMovie
import com.gigigo.themoviesapp.home.domain.usecases.GetNowPlayingMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetPopularMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetTopRatedMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetTrending
import com.gigigo.themoviesapp.home.domain.usecases.GetUpcomingMovies
import com.gigigo.themoviesapp.home.viewmodel.navigation.HomeCoordinator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    private val coordinator: HomeCoordinator,
    private val getTrending: GetTrending,
    private val getLatestMovie: GetLatestMovie,
    private val getNowPlayingMovies: GetNowPlayingMovies,
    private val getPopularMovies: GetPopularMovies,
    private val getTopRatedMovies: GetTopRatedMovies,
    private val getUpcomingMovies: GetUpcomingMovies
) : ViewModel(), CoroutineScope {
    private val _job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + _job

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _loading

    private val _trendingMovies = MutableLiveData<List<Movie>>()
    val trendingMovies: LiveData<List<Movie>>
        get() = _trendingMovies

    init {
        loadTrendings()
    }

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
        Timber.d("MainViewModel onCleared")
    }
}