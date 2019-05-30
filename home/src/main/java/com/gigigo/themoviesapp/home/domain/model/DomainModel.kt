package com.gigigo.themoviesapp.home.domain.model

data class Page<Data>(
    val page: Int,
    val results: List<Data>,
    val totalPages: Int,
    val totalResults: Int
)