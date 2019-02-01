package com.gigigo.themoviesapp.base.data.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkHandler(private val context: Context) {
    val isConnected get() = getNetworkInfo(context)?.isConnected ?: false

    private fun getNetworkInfo(context: Context): NetworkInfo? {
        return context.connectivityManager.activeNetworkInfo
    }
}

val Context.connectivityManager: ConnectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager