package com.gigigo.themoviesapp.base.domain.model

data class Page<Data>(
    val page: Int,
    val results: List<Data>,
    val totalPages: Int,
    val totalResults: Int
)

data class Genre(
    val id: Int,
    val name: String
)

data class Language(
    val id: String,
    val name: String
)

data class Country(
    val id: String,
    val name: String
)

data class Company(
    val id: Int,
    val name: String,
    val logoPath: String,
    val originCountry: String
)