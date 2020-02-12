package com.gigigo.themoviesapp.home.ui.viewholder

import android.content.Context
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.TextView
import com.gigigo.themoviesapp.home.R
import com.gigigo.themoviesapp.home.domain.model.TopRatedMovie

class TopRatedMovieViewHolder(
    private val context: Context,
    parent: ViewGroup,
    size: DisplayMetrics,
    apiImageUrl: String
) :
    MovieViewHolder<TopRatedMovie>(
        context,
        parent,
        size,
        apiImageUrl,
        R.layout.item_top_rated_movie
    ) {

    private val voteAverage = itemView.findViewById<TextView>(R.id.movie_vote_average)
    private val voteCount = itemView.findViewById<TextView>(R.id.movie_vote_count)

    override fun bindTo(data: TopRatedMovie, position: Int) {
        super.bindTo(data, position)

        voteAverage?.text = data.voteAverage.toString()
        voteCount?.text = "${data.voteCount} votes"
    }
}