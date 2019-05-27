package com.gigigo.themoviesapp.splash.data.model

import com.gigigo.themoviesapp.splash.domain.model.Configuration
import com.gigigo.themoviesapp.splash.domain.model.Images

fun ApiConfiguration.toConfiguration(): Configuration {
    return Configuration(
        images = this.images?.toImages() ?: emptyImages(),
        changeKeys = this.changeKeys?.map { it } ?: emptyList()
    )
}

private fun emptyImages() =
    Images(
        "",
        "",
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList()
    )

fun ApiImages.toImages(): Images {
    return Images(
        baseUrl = this.baseUrl ?: "",
        secureBaseUrl = this.secureBaseUrl ?: "",
        backdropSizes = this.backdropSizes ?: emptyList(),
        logoSizes = this.logoSizes ?: emptyList(),
        posterSizes = this.posterSizes ?: emptyList(),
        profileSizes = this.profileSizes ?: emptyList(),
        stillSizes = this.stillSizes ?: emptyList()
    )
}