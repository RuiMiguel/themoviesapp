package com.gigigo.themoviesapp.base.data.mapper

import com.gigigo.themoviesapp.base.data.model.ApiCompany
import com.gigigo.themoviesapp.base.data.model.ApiCountry
import com.gigigo.themoviesapp.base.data.model.ApiGenre
import com.gigigo.themoviesapp.base.data.model.ApiLanguage
import com.gigigo.themoviesapp.base.domain.model.Company
import com.gigigo.themoviesapp.base.domain.model.Country
import com.gigigo.themoviesapp.base.domain.model.Genre
import com.gigigo.themoviesapp.base.domain.model.Language

fun ApiGenre.toGenre(): Genre {
    return Genre(
        id = this.id ?: 0,
        name = this.name ?: ""
    )
}

fun ApiLanguage.toLanguage(): Language {
    return Language(
        id = this.id ?: "",
        name = this.name ?: ""
    )
}

fun ApiCountry.toCountry(): Country {
    return Country(
        id = this.id ?: "",
        name = this.name ?: ""
    )
}

fun ApiCompany.toCompany(): Company {
    return Company(
        id = this.id ?: 0,
        name = this.name ?: "",
        logoPath = this.logoPath ?: "",
        originCountry = this.originCountry ?: ""
    )
}