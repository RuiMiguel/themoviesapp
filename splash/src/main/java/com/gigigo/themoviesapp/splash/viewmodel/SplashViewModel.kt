package com.gigigo.themoviesapp.splash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gigigo.themoviesapp.base.viewmodel.BaseViewModel
import com.gigigo.themoviesapp.splash.domain.usecases.GetConfiguration
import com.gigigo.themoviesapp.splash.navigation.SplashCoordinator
import kotlinx.coroutines.launch

class SplashViewModel(
    private val coordinator: SplashCoordinator,
    private val getConfiguration: GetConfiguration
) : BaseViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _loading

    init {
        loadConfiguration()
    }

    private fun loadConfiguration() {
        scope.launch {
            _loading.postValue(true)

            getConfiguration().fold(
                {
                    _loading.postValue(false)

                },
                {
                    _loading.postValue(false)
                    coordinator.goHome()
                }
            )
        }
    }
}