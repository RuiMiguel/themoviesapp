package com.gigigo.themoviesapp.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.domain.usecases.GetTrending
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val getTrending: GetTrending) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _loading

    private val _trendingMovies = MutableLiveData<List<Movie>>()
    val trendingMovies: LiveData<List<Movie>>
        get() = _trendingMovies

    fun loadTrendings() {
        GlobalScope.launch(Dispatchers.IO) {
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

}