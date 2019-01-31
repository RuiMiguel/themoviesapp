package com.gigigo.themoviesapp.home.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gigigo.themoviesapp.home.domain.usecases.GetTrending
import com.gigigo.themoviesapp.home.viewmodel.MainViewModel

class MainViewModelFactory(private val getTrending: GetTrending) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(getTrending) as T
            }
            else -> throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}