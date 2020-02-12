package com.gigigo.themoviesapp.home.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gigigo.themoviesapp.base.ui.Result
import com.gigigo.themoviesapp.base.viewmodel.BaseViewModel
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.model.NowPlayingMovie
import com.gigigo.themoviesapp.home.domain.model.PopularMovie
import com.gigigo.themoviesapp.home.domain.model.TopRatedMovie
import com.gigigo.themoviesapp.home.domain.model.TrendingMovie
import com.gigigo.themoviesapp.home.domain.model.UpcomingMovie
import com.gigigo.themoviesapp.home.domain.usecases.GetLatestMovie
import com.gigigo.themoviesapp.home.domain.usecases.GetNowPlayingMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetPopularMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetTopRatedMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetTrendingMovies
import com.gigigo.themoviesapp.home.domain.usecases.GetUpcomingMovies
import com.gigigo.themoviesapp.home.navigation.HomeCoordinator
import kotlinx.coroutines.launch

class HomeViewModel(
    private val coordinator: HomeCoordinator,
    private val getTrendingMovies: GetTrendingMovies,
    private val getLatestMovie: GetLatestMovie,
    private val getNowPlayingMovies: GetNowPlayingMovies,
    private val getPopularMovies: GetPopularMovies,
    private val getTopRatedMovies: GetTopRatedMovies,
    private val getUpcomingMovies: GetUpcomingMovies
) : BaseViewModel() {

    private val _trendingMovies = MutableLiveData<Result<List<TrendingMovie>>>()
    val trendingMovies: LiveData<Result<List<TrendingMovie>>>
        get() = _trendingMovies

    private val _latestMovie = MutableLiveData<Result<List<LatestMovie>>>()
    val latestMovie: LiveData<Result<List<LatestMovie>>>
        get() = _latestMovie

    private val _nowPlayingMovies = MutableLiveData<Result<List<NowPlayingMovie>>>()
    val nowPlayingMovies: LiveData<Result<List<NowPlayingMovie>>>
        get() = _nowPlayingMovies

    private val _popularMovies = MutableLiveData<Result<List<PopularMovie>>>()
    val popularMovies: LiveData<Result<List<PopularMovie>>>
        get() = _popularMovies

    private val _topRatedMovies = MutableLiveData<Result<List<TopRatedMovie>>>()
    val topRatedMovies: LiveData<Result<List<TopRatedMovie>>>
        get() = _topRatedMovies

    private val _upcomingMovies = MutableLiveData<Result<List<UpcomingMovie>>>()
    val upcomingMovies: LiveData<Result<List<UpcomingMovie>>>
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

    fun handledMovieItemSelected(view: View?, movieId: Int) {
        val transition = view to movieId.toString()
        coordinator.goDetail(movieId, listOf(transition))
    }
}