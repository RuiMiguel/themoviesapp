package com.gigigo.themoviesapp.home.ui.viewholder

import android.content.Context
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.TextView
import com.gigigo.themoviesapp.home.R
import com.gigigo.themoviesapp.home.domain.model.UpcomingMovie

class UpcomingMovieViewHolder(
    context: Context,
    parent: ViewGroup,
    size: DisplayMetrics,
    apiImageUrl: String
) :
    MovieViewHolder<UpcomingMovie>(
        context,
        parent,
        size,
        apiImageUrl,
        R.layout.item_upcoming_movie
    ) {

    private val releaseDate = itemView.findViewById<TextView>(R.id.movie_release_date)

    override fun bindTo(data: UpcomingMovie, position: Int) {
        super.bindTo(data, position)

        releaseDate?.text = data.releaseDate
    }
}