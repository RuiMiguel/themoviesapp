package com.gigigo.themoviesapp.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigigo.themoviesapp.home.domain.usecases.GetTrending

class MainViewModel(private val getTrending: GetTrending) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _loading


    fun loadTrendings() {
        _loading.value = true

        /*
        getTrending().fold(
            {
                _loading.value = false

            },
            {
                _loading.value = false

            }
        )
        */
    }

}