package com.gigigo.themoviesapp.splash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigigo.themoviesapp.splash.domain.usecases.GetConfiguration
import com.gigigo.themoviesapp.splash.viewmodel.navigation.SplashCoordinator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class SplashViewModel(
    private val coordinator: SplashCoordinator,
    private val getConfiguration: GetConfiguration
) : ViewModel(),
    CoroutineScope {
    private val _job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + _job

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _loading

    init {
        loadConfiguration()
    }

    private fun loadConfiguration() {
        launch {
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

    override fun onCleared() {
        super.onCleared()
        _job.cancel()
        Timber.d("SplashViewModel onCleared")
    }
}