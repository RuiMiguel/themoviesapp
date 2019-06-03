package com.gigigo.themoviesapp.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
) : ViewModel(), CoroutineScope {

    private val _job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + _job

    private val _loading = MediatorLiveData<MutableMap<String, Boolean>>()
    val isLoading: LiveData<MutableMap<String, Boolean>>
        get() = _loading

    private val _loadingTrendingMovies = MutableLiveData<Boolean>()
    private val _loadingLatestMovie = MutableLiveData<Boolean>()
    private val _loadingNowPlayingMovies = MutableLiveData<Boolean>()
    private val _loadingPopularMovies = MutableLiveData<Boolean>()
    private val _loadingTopRatedMovies = MutableLiveData<Boolean>()
    private val _loadingUpcomingMovies = MutableLiveData<Boolean>()

    private val _trendingMovies = MutableLiveData<List<Movie>>()
    val trendingMovies: LiveData<List<Movie>>
        get() = _trendingMovies

    private val _latestMovie = MutableLiveData<List<LatestMovie>>()
    val latestMovie: LiveData<List<LatestMovie>>
        get() = _latestMovie

    private val _nowPlayingMovies = MutableLiveData<List<Movie>>()
    val nowPlayingMovies: LiveData<List<Movie>>
        get() = _nowPlayingMovies

    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>>
        get() = _popularMovies

    private val _topRatedMovies = MutableLiveData<List<Movie>>()
    val topRatedMovies: LiveData<List<Movie>>
        get() = _topRatedMovies

    private val _upcomingMovies = MutableLiveData<List<Movie>>()
    val upcomingMovies: LiveData<List<Movie>>
        get() = _upcomingMovies


    init {
        initLoading()

        loadTrendings()
        loadLatestMovie()
        loadNowPlaying()
        loadPopular()
        loadTopRated()
        loadUpcoming()
    }

    object Loading {
        const val LATEST = "latest"
        const val NOW_PLAYING = "now_playing"
        const val POPULAR = "popular"
        const val TOP_RATED = "top_rated"
        const val TRENDING = "trending"
        const val UPCOMING = "upcoming"
    }

    fun initLoading() {
        _loading.addSource(_loadingLatestMovie) { value ->
            val map = _loading.value ?: mutableMapOf()
            val oldValue = map[Loading.LATEST]
            if (oldValue != value) {
                map[Loading.LATEST] = value
                _loading.value = map
            }
        }

        _loading.addSource(_loadingNowPlayingMovies) { value ->
            val map = _loading.value ?: mutableMapOf()
            val oldValue = map[Loading.NOW_PLAYING]
            if (oldValue != value) {
                map[Loading.NOW_PLAYING] = value
                _loading.value = map
            }
        }

        _loading.addSource(_loadingPopularMovies) { value ->
            val map = _loading.value ?: mutableMapOf()
            val oldValue = map[Loading.POPULAR]
            if (oldValue != value) {
                map[Loading.POPULAR] = value
                _loading.value = map
            }
        }

        _loading.addSource(_loadingTopRatedMovies) { value ->
            val map = _loading.value ?: mutableMapOf()
            val oldValue = map[Loading.TOP_RATED]
            if (oldValue != value) {
                map[Loading.TOP_RATED] = value
                _loading.value = map
            }
        }

        _loading.addSource(_loadingTrendingMovies) { value ->
            val map = _loading.value ?: mutableMapOf()
            val oldValue = map[Loading.TRENDING]
            if (oldValue != value) {
                map[Loading.TRENDING] = value
                _loading.value = map
            }
        }

        _loading.addSource(_loadingUpcomingMovies) { value ->
            val map = _loading.value ?: mutableMapOf()
            val oldValue = map[Loading.UPCOMING]
            if (oldValue != value) {
                map[Loading.UPCOMING] = value
                _loading.value = map
            }
        }
    }

    fun loadLatestMovie() {
        launch {
            _loadingLatestMovie.postValue(true)

            getLatestMovie().fold(
                {
                    _loadingLatestMovie.postValue(false)

                },
                {
                    _loadingLatestMovie.postValue(false)
                    _latestMovie.postValue(listOf(it))
                }
            )
        }
    }

    fun loadNowPlaying() {
        launch {
            _loadingNowPlayingMovies.postValue(true)

            getNowPlayingMovies().fold(
                {
                    _loadingNowPlayingMovies.postValue(false)

                },
                {
                    _loadingNowPlayingMovies.postValue(false)
                    _nowPlayingMovies.postValue(it)
                }
            )
        }
    }

    fun loadPopular() {
        launch {
            _loadingPopularMovies.postValue(true)

            getPopularMovies().fold(
                {
                    _loadingPopularMovies.postValue(false)

                },
                {
                    _loadingPopularMovies.postValue(false)
                    _popularMovies.postValue(it)
                }
            )
        }
    }

    fun loadTopRated() {
        launch {
            _loadingTopRatedMovies.postValue(true)

            getTopRatedMovies().fold(
                {
                    _loadingTopRatedMovies.postValue(false)

                },
                {
                    _loadingTopRatedMovies.postValue(false)
                    _topRatedMovies.postValue(it)
                }
            )
        }
    }

    fun loadTrendings() {
        launch {
            _loadingTrendingMovies.postValue(true)

            getTrendingMovies().fold(
                {
                    _loadingTrendingMovies.postValue(false)

                },
                {
                    _loadingTrendingMovies.postValue(false)
                    _trendingMovies.postValue(it)
                }
            )
        }
    }

    fun loadUpcoming() {
        launch {
            _loadingUpcomingMovies.postValue(true)

            getUpcomingMovies().fold(
                {
                    _loadingUpcomingMovies.postValue(false)

                },
                {
                    _loadingUpcomingMovies.postValue(false)
                    _upcomingMovies.postValue(it)
                }
            )
        }
    }


    override fun onCleared() {
        super.onCleared()
        _job.cancel()
        Timber.d("HomeViewModel onCleared")
    }
}