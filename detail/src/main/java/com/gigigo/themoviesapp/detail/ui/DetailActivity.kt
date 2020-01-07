package com.gigigo.themoviesapp.detail.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gigigo.themoviesapp.base.navigation.AppNavigator.Arguments.MOVIE_ARG
import com.gigigo.themoviesapp.base.ui.Result
import com.gigigo.themoviesapp.base.ui.extensions.observe
import com.gigigo.themoviesapp.detail.R
import com.gigigo.themoviesapp.detail.viewmodel.DetailViewModel
import com.gigigo.themoviesapp.home.di.detailModules
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
        title = "Movies"
    }

    private fun initDetailView() {
        val movieId = intent.extras.get(MOVIE_ARG) as Int
        viewModel.loadMovieDetail(movieId)
    }

    private fun initViewModel() {
        observe(viewModel.movieDetail) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    title = result.data.title
                }
                is Result.Error -> {

                }
            }
        }
    }
}
