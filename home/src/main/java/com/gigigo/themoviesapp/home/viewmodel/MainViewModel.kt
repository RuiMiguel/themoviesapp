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
        val params = GetTrending.Params.forMediaTime(1,1)
        getTrending(params).fold(
            {

            },
            {

            }
        )
    }

}