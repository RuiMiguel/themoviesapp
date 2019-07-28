package com.gigigo.themoviesapp.base.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import timber.log.Timber

open class BaseViewModel : ViewModel() {
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Timber.e("CoroutineExceptionHandler handled crash $exception")
    }

    protected val scope = CoroutineScope(Dispatchers.IO + SupervisorJob() + coroutineExceptionHandler)

    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}