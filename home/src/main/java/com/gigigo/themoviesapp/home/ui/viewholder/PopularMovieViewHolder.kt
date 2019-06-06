package com.gigigo.themoviesapp.home.ui.viewholder

import android.content.Context
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.TextView
import com.gigigo.themoviesapp.home.R
import com.gigigo.themoviesapp.home.domain.model.PopularMovie

class PopularMovieViewHolder(
    context: Context,
    parent: ViewGroup,
    size: DisplayMetrics,
    apiImageUrl: String
) :
    MovieViewHolder<PopularMovie>(context, parent, size, apiImageUrl, R.layout.item_popular_movie) {

    private val popularity = itemView.findViewById<TextView>(R.id.movie_popularity)

    override fun bindTo(data: PopularMovie, position: Int) {
        super.bindTo(data, position)

        popularity?.text = data.popularity.toString()
    }
}