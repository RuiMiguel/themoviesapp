package com.gigigo.themoviesapp.home.ui.viewholder

import android.content.Context
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolder
import com.gigigo.themoviesapp.home.R
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.Movie

class LatestMovieViewHolder(
    private val context: Context,
    parent: ViewGroup,
    val size: DisplayMetrics,
    private val apiImageUrl: String
) :
    BaseViewHolder<LatestMovie>(context, parent, R.layout.item_movie) {

    private val image = itemView.findViewById<ImageView>(R.id.movie_thumbnail)

    override fun bindTo(data: LatestMovie, position: Int) {
        val requestOption = RequestOptions()
            .placeholder(R.drawable.ic_movie_placeholder).centerCrop()

        val imageWidthRatio = if (size.widthPixels < size.heightPixels) 3 else 4
        val imageHeightRatio = 3.0/2.0

        image.layoutParams.width = size.widthPixels/imageWidthRatio
        image.layoutParams.height = (imageHeightRatio*image.layoutParams.width).toInt()

        Glide.with(context)
            .load("${apiImageUrl}w500${data.posterPath}")
            .transition(DrawableTransitionOptions.withCrossFade())
            .thumbnail(Glide.with(context).load("").apply(requestOption))
            .apply(requestOption)
            .into(image)
    }
}