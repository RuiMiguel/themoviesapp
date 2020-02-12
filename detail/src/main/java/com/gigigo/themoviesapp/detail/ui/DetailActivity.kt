package com.gigigo.themoviesapp.detail.ui

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.transition.ChangeBounds
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.gigigo.themoviesapp.base.navigation.AppNavigator.Arguments.MOVIE_ARG
import com.gigigo.themoviesapp.base.ui.Result
import com.gigigo.themoviesapp.base.ui.extensions.observe
import com.gigigo.themoviesapp.detail.R
import com.gigigo.themoviesapp.detail.viewmodel.DetailViewModel
import com.gigigo.themoviesapp.home.di.detailModules
import kotlinx.android.synthetic.main.activity_detail.movie_image
import kotlinx.android.synthetic.main.activity_detail.movie_tag
import kotlinx.android.synthetic.main.activity_detail.toolbar
import kotlinx.android.synthetic.main.content_scrolling.movie_description
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class DetailActivity : AppCompatActivity() {
    private val viewModel by viewModel<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailModules.forEach { loadKoinModules(it) }

        initUI()
        initViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(detailModules)
    }

    private fun initUI() {
        initToolbar()
        initDetailView()
    }

    private fun initToolbar() {
        //setSupportActionBar(toolbar)
        //title = "Movies"
    }

    private fun initDetailView() {
        val movieId = intent?.extras?.get(MOVIE_ARG) as Int
        viewModel.loadMovieDetail(movieId)
    }

    private fun initViewModel() {
        observe(viewModel.movieDetail) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    with(result.data) {
                        toolbar.title = title
                        movie_tag.text = tagline
                        movie_description.text = overview

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            movie_image.transitionName = "$id"//"${resources.getString(R.string.movie_image_transition_name)}_${id}"
                        }

                        movie_image?.let {
                            val apiImageUrl = "https://image.tmdb.org/t/p/"

                            Glide.with(baseContext)
                                .load("${apiImageUrl}w500${posterPath}")
                                .into(it)
                        }
                    }
                }
                is Result.Error -> {

                }
            }
        }
    }
}
