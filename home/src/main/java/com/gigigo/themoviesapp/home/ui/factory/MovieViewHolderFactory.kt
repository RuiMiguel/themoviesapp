package com.gigigo.themoviesapp.home.ui.factory

import android.content.Context
import android.util.DisplayMetrics
import android.view.ViewGroup
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolder
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolderFactory
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.NowPlayingMovie
import com.gigigo.themoviesapp.home.domain.model.PopularMovie
import com.gigigo.themoviesapp.home.domain.model.TopRatedMovie
import com.gigigo.themoviesapp.home.domain.model.TrendingMovie
import com.gigigo.themoviesapp.home.domain.model.UpcomingMovie
import com.gigigo.themoviesapp.home.ui.viewholder.LatestMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.NowPlayingMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.PopularMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.TopRatedMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.TrendingMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.UpcomingMovieViewHolder

class MovieViewHolderFactory(
    context: Context,
    private val size: DisplayMetrics,
    private val apiImageUrl: String
) : BaseViewHolderFactory(context) {

    override fun create(valueClass: Class<*>, parent: ViewGroup): BaseViewHolder<*> {
        return when (valueClass) {
            NowPlayingMovie::class.java -> NowPlayingMovieViewHolder(
                context,
                parent,
                size,
                apiImageUrl
            )
            PopularMovie::class.java -> PopularMovieViewHolder(
                context,
                parent,
                size,
                apiImageUrl
            )
            TopRatedMovie::class.java -> TopRatedMovieViewHolder(
                context,
                parent,
                size,
                apiImageUrl
            )
            TrendingMovie::class.java -> TrendingMovieViewHolder(
                context,
                parent,
                size,
                apiImageUrl
            )
            UpcomingMovie::class.java -> UpcomingMovieViewHolder(
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