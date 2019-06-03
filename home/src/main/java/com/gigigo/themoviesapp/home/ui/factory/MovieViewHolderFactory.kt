package com.gigigo.themoviesapp.home.ui.factory

import android.content.Context
import android.util.DisplayMetrics
import android.view.ViewGroup
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolder
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolderFactory
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.ui.viewholder.LatestMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.MovieViewHolder

class MovieViewHolderFactory(
    context: Context,
    private val size: DisplayMetrics,
    private val apiImageUrl: String
) : BaseViewHolderFactory(context) {

    override fun create(valueClass: Class<*>, parent: ViewGroup): BaseViewHolder<*> {
        return when (valueClass) {
            Movie::class.java -> MovieViewHolder(
                context,
                parent,
                size,
                apiImageUrl
            )
            LatestMovie::class.java -> LatestMovieViewHolder(
                context,
                parent,
                size,
                apiImageUrl
            )
            else -> super.create(valueClass, parent)
        }
    }
}