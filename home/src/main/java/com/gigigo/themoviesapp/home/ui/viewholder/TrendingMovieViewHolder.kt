package com.gigigo.themoviesapp.home.ui.viewholder

import android.content.Context
import android.util.DisplayMetrics
import android.view.ViewGroup
import com.gigigo.themoviesapp.home.R
import com.gigigo.themoviesapp.home.domain.model.TrendingMovie

class TrendingMovieViewHolder(
    private val context: Context,
    parent: ViewGroup,
    size: DisplayMetrics,
    apiImageUrl: String
) :
    MovieViewHolder<TrendingMovie>(
        context,
        parent,
        size,
        apiImageUrl,
        R.layout.item_trending_movie
    )