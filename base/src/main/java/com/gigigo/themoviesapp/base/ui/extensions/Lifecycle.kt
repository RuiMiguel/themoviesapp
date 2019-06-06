package com.gigigo.themoviesapp.base.ui.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any?, L : LiveData<T>> Fragment.observe(liveData: L, body: (T?) -> Unit) {
    try {
        observeViewLifecycleOwner(liveData, body, viewLifecycleOwner)
    } catch (exception: IllegalStateException) {
        observeViewLifecycleOwner(liveData, body, this)
    }
}

private fun <T : Any?, L : LiveData<T>> observeViewLifecycleOwner(
    liveData: L,
    body: (T?) -> Unit,
    lifecycleOwner: LifecycleOwner
) {
    liveData.removeObservers(lifecycleOwner)
    liveData.observe(lifecycleOwner, Observer(body))
}