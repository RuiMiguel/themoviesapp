package com.gigigo.themoviesapp.home.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gigigo.baserecycleradapter.adapter.BaseRecyclerAdapter
import com.gigigo.themoviesapp.base.ui.navigation.Navigator
import com.gigigo.themoviesapp.base.ui.utils.extensions.hide
import com.gigigo.themoviesapp.base.ui.utils.extensions.screenSize
import com.gigigo.themoviesapp.base.ui.utils.extensions.show
import com.gigigo.themoviesapp.home.R
import com.gigigo.themoviesapp.home.di.homeModules
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.ui.decoration.PaddingDecoration
import com.gigigo.themoviesapp.home.ui.factory.MovieViewHolderFactory
import com.gigigo.themoviesapp.home.ui.viewholder.LatestMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.MovieViewHolder
import com.gigigo.themoviesapp.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.drawer_layout
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.app_bar_main.toolbar
import kotlinx.android.synthetic.main.content_main.latest_movies_list
import kotlinx.android.synthetic.main.content_main.now_playing_movies_list
import kotlinx.android.synthetic.main.content_main.popular_movies_list
import kotlinx.android.synthetic.main.content_main.progress_bar_layout
import kotlinx.android.synthetic.main.content_main.top_rated_movies_list
import kotlinx.android.synthetic.main.content_main.trending_movies_list
import kotlinx.android.synthetic.main.content_main.upcoming_movies_list
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import kotlin.coroutines.CoroutineContext

class HomeActivity : AppCompatActivity(), CoroutineScope {
    private val _job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + _job

    private val navigator: Navigator by inject()

    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var lastestAdapter: BaseRecyclerAdapter<LatestMovie>
    private lateinit var nowPlayingAdapter: BaseRecyclerAdapter<Movie>
    private lateinit var popularAdapter: BaseRecyclerAdapter<Movie>
    private lateinit var topRatedAdapter: BaseRecyclerAdapter<Movie>
    private lateinit var trendingAdapter: BaseRecyclerAdapter<Movie>
    private lateinit var upcomingAdapter: BaseRecyclerAdapter<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeModules.forEach { loadKoinModules(it) }

        initUI()
        initViewModel()

        navigator.activity = this
    }

    override fun onDestroy() {
        super.onDestroy()
        _job.cancel()
        unloadKoinModules(homeModules)
        navigator.activity = null
    }

    private fun initUI() {
        initToolbar()

        initNavigationView()

        initRecyclerView()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        title = "Movies"
    }

    private fun initNavigationView() {
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_movies -> {

                }
                R.id.nav_tv_shows -> {

                }
                R.id.nav_settings -> {

                }
                R.id.nav_share -> {

                }
            }

            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun initRecyclerView() {
        initLatestRecycler()
        initNowPlayingRecycler()
        initPopularRecycler()
        initTopRatedRecycler()
        initTrendingRecycler()
        initUpcomingRecycler()
    }

    private fun initLatestRecycler() {
        val size = screenSize()

        lastestAdapter =
            BaseRecyclerAdapter(
                MovieViewHolderFactory(
                    this,
                    size,
                    "https://image.tmdb.org/t/p/"
                )
            )
        lastestAdapter.bind<LatestMovie, LatestMovieViewHolder>()

        latest_movies_list.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        latest_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        latest_movies_list.setHasFixedSize(true)
        latest_movies_list.adapter = lastestAdapter
    }

    private fun initNowPlayingRecycler() {
        val size = screenSize()

        nowPlayingAdapter =
            BaseRecyclerAdapter(
                MovieViewHolderFactory(
                    this,
                    size,
                    "https://image.tmdb.org/t/p/"
                )
            )
        nowPlayingAdapter.bind<Movie, MovieViewHolder>()

        now_playing_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        now_playing_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        now_playing_movies_list.setHasFixedSize(true)
        now_playing_movies_list.adapter = nowPlayingAdapter
    }

    private fun initPopularRecycler() {
        val size = screenSize()

        popularAdapter =
            BaseRecyclerAdapter(
                MovieViewHolderFactory(
                    this,
                    size,
                    "https://image.tmdb.org/t/p/"
                )
            )
        popularAdapter.bind<Movie, MovieViewHolder>()

        popular_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        popular_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        popular_movies_list.setHasFixedSize(true)
        popular_movies_list.adapter = popularAdapter
    }

    private fun initTopRatedRecycler() {
        val size = screenSize()

        topRatedAdapter =
            BaseRecyclerAdapter(
                MovieViewHolderFactory(
                    this,
                    size,
                    "https://image.tmdb.org/t/p/"
                )
            )
        topRatedAdapter.bind<Movie, MovieViewHolder>()

        top_rated_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        top_rated_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        top_rated_movies_list.setHasFixedSize(true)
        top_rated_movies_list.adapter = topRatedAdapter
    }

    private fun initTrendingRecycler() {
        val size = screenSize()

        trendingAdapter =
            BaseRecyclerAdapter(
                MovieViewHolderFactory(
                    this,
                    size,
                    "https://image.tmdb.org/t/p/"
                )
            )
        trendingAdapter.bind<Movie, MovieViewHolder>()

        trending_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        trending_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        trending_movies_list.setHasFixedSize(true)
        trending_movies_list.adapter = trendingAdapter
    }

    private fun initUpcomingRecycler() {
        val size = screenSize()

        upcomingAdapter =
            BaseRecyclerAdapter(
                MovieViewHolderFactory(
                    this,
                    size,
                    "https://image.tmdb.org/t/p/"
                )
            )
        upcomingAdapter.bind<Movie, MovieViewHolder>()

        upcoming_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        upcoming_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        upcoming_movies_list.setHasFixedSize(true)
        upcoming_movies_list.adapter = upcomingAdapter
    }

    private fun initViewModel() {
        viewModel.isLoading.observe(this, Observer { loadingMap ->
            val loadingLatestMovie = loadingMap?.get(HomeViewModel.Loading.LATEST) ?: false
            val loadingNowPlayingMovies =
                loadingMap?.get(HomeViewModel.Loading.NOW_PLAYING) ?: false
            val loadingPopularMovies = loadingMap?.get(HomeViewModel.Loading.POPULAR) ?: false
            val loadingTopRatedMovies = loadingMap?.get(HomeViewModel.Loading.TOP_RATED) ?: false
            val loadingTrendingMovies = loadingMap?.get(HomeViewModel.Loading.TRENDING) ?: false
            val loadingUpcomingMovies = loadingMap?.get(HomeViewModel.Loading.UPCOMING) ?: false
        })

        viewModel.latestMovie.observe(this, Observer {
            launch {
                lastestAdapter.addAll(it)
            }
        })
        viewModel.nowPlayingMovies.observe(this, Observer {
            launch {
                nowPlayingAdapter.addAll(it)
            }
        })
        viewModel.popularMovies.observe(this, Observer {
            launch {
                popularAdapter.addAll(it)
            }
        })
        viewModel.topRatedMovies.observe(this, Observer {
            launch {
                topRatedAdapter.addAll(it)
            }
        })
        viewModel.trendingMovies.observe(this, Observer {
            launch {
                trendingAdapter.addAll(it)
            }
        })
        viewModel.upcomingMovies.observe(this, Observer {
            launch {
                upcomingAdapter.addAll(it)
            }
        })
    }

    private fun showLoading(loading: Boolean) {
        launch(Dispatchers.Main) {
            when (loading) {
                true -> {
                    progress_bar_layout.show()
                }
                false -> {
                    progress_bar_layout.hide()
                }
            }
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
