package com.gigigo.themoviesapp.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigigo.themoviesapp.base.ui.Result
import com.gigigo.themoviesapp.base.viewmodel.BaseViewModel
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.usecases.GetLatestMovie
import com.gigigo.themoviesapp.home.domain.usecases.GetNowPlayingMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetPopularMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetTopRatedMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetTrendingMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetUpcomingMovies
import com.gigigo.themoviesapp.home.viewmodel.navigation.HomeCoordinator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val coordinator: HomeCoordinator,
    private val getTrendingMovies: GetTrendingMovies,
    private val getLatestMovie: GetLatestMovie,
    private val getNowPlayingMovies: GetNowPlayingMovies,
    private val getPopularMovies: GetPopularMovies,
    private val getTopRatedMovies: GetTopRatedMovies,
    private val getUpcomingMovies: GetUpcomingMovies
) : BaseViewModel() {

    private val _trendingMovies = MutableLiveData<Result<List<Movie>>>()
    val trendingMovies: LiveData<Result<List<Movie>>>
        get() = _trendingMovies

    private val _latestMovie = MutableLiveData<Result<List<LatestMovie>>>()
    val latestMovie: LiveData<Result<List<LatestMovie>>>
        get() = _latestMovie

    private val _nowPlayingMovies = MutableLiveData<Result<List<Movie>>>()
    val nowPlayingMovies: LiveData<Result<List<Movie>>>
        get() = _nowPlayingMovies

    private val _popularMovies = MutableLiveData<Result<List<Movie>>>()
    val popularMovies: LiveData<Result<List<Movie>>>
        get() = _popularMovies

    private val _topRatedMovies = MutableLiveData<Result<List<Movie>>>()
    val topRatedMovies: LiveData<Result<List<Movie>>>
        get() = _topRatedMovies

    private val _upcomingMovies = MutableLiveData<Result<List<Movie>>>()
    val upcomingMovies: LiveData<Result<List<Movie>>>
        get() = _upcomingMovies


    init {
        loadTrendings()
        loadLatestMovie()
        loadNowPlaying()
        loadPopular()
        loadTopRated()
        loadUpcoming()
    }

    fun loadLatestMovie() {
        scope.launch {
            _latestMovie.postValue(Result.Loading)

            getLatestMovie().fold(
                {
                    _latestMovie.postValue(Result.Error(it))
                },
                {
                    _latestMovie.postValue(Result.Success(listOf(it)))
                }
            )
        }
    }

    fun loadNowPlaying() {
        scope.launch {
            _nowPlayingMovies.postValue(Result.Loading)

            getNowPlayingMovies().fold(
                {
                    _nowPlayingMovies.postValue(Result.Error(it))
                },
                {
                    _nowPlayingMovies.postValue(Result.Success(it))
                }
            )
        }
    }

    fun loadPopular() {
        scope.launch {
            _popularMovies.postValue(Result.Loading)

            getPopularMovies().fold(
                {
                    _popularMovies.postValue(Result.Error(it))
                },
                {
                    _popularMovies.postValue(Result.Success(it))
                }
            )
        }
    }

    fun loadTopRated() {
        scope.launch {
            _topRatedMovies.postValue(Result.Loading)

            getTopRatedMovies().fold(
                {
                    _topRatedMovies.postValue(Result.Error(it))
                },
                {
                    _topRatedMovies.postValue(Result.Success(it))
                }
            )
        }
    }

    fun loadTrendings() {
        scope.launch {
            _trendingMovies.postValue(Result.Loading)

            getTrendingMovies().fold(
                {
                    _trendingMovies.postValue(Result.Error(it))
                },
                {
                    _trendingMovies.postValue(Result.Success(it))
                }
            )
        }
    }

    fun loadUpcoming() {
        scope.launch {
            _upcomingMovies.postValue(Result.Loading)

            getUpcomingMovies().fold(
                {
                    _upcomingMovies.postValue(Result.Error(it))
                },
                {
                    _upcomingMovies.postValue(Result.Success(it))
                }
            )
        }
    }

    fun handledMovieItemSelected(elementId: Int) {
        coordinator.goDetail()
    }
}