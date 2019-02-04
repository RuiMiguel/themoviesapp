package com.gigigo.themoviesapp.home.ui

import android.content.Context
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolder
import com.gigigo.themoviesapp.home.R
import com.gigigo.themoviesapp.home.domain.model.Movie

class MovieViewHolder(
    private val context: Context,
    parent: ViewGroup,
    val size: DisplayMetrics,
    private val apiImageUrl: String
) :
    BaseViewHolder<Movie>(context, parent, R.layout.item_movie) {

    private val image = itemView.findViewById<ImageView>(R.id.movie_thumbnail)

    override fun bindTo(data: Movie, position: Int) {
        Glide.with(context)
            .load("${apiImageUrl}w500${data.posterPath}")
            .fitCenter()
            .dontAnimate()
            //.placeholder(R.drawable.placeholder_movie)
            .into(image)
    }
}