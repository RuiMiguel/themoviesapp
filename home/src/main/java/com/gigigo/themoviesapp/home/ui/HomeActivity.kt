package com.gigigo.themoviesapp.home.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gigigo.baserecycleradapter.adapter.BaseRecyclerAdapter
import com.gigigo.themoviesapp.base.ui.Result
import com.gigigo.themoviesapp.base.ui.extensions.observe
import com.gigigo.themoviesapp.base.ui.navigation.Navigator
import com.gigigo.themoviesapp.base.ui.utils.extensions.hide
import com.gigigo.themoviesapp.base.ui.utils.extensions.screenSize
import com.gigigo.themoviesapp.base.ui.utils.extensions.show
import com.gigigo.themoviesapp.home.R
import com.gigigo.themoviesapp.home.di.homeModules
import com.gigigo.themoviesapp.home.domain.model.LatestMovie
import com.gigigo.themoviesapp.home.domain.model.NowPlayingMovie
import com.gigigo.themoviesapp.home.domain.model.PopularMovie
import com.gigigo.themoviesapp.home.domain.model.TopRatedMovie
import com.gigigo.themoviesapp.home.domain.model.TrendingMovie
import com.gigigo.themoviesapp.home.domain.model.UpcomingMovie
import com.gigigo.themoviesapp.home.ui.decoration.PaddingDecoration
import com.gigigo.themoviesapp.home.ui.factory.MovieViewHolderFactory
import com.gigigo.themoviesapp.home.ui.viewholder.LatestMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.NowPlayingMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.PopularMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.TopRatedMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.TrendingMovieViewHolder
import com.gigigo.themoviesapp.home.ui.viewholder.UpcomingMovieViewHolder
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
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class HomeActivity : AppCompatActivity() {
    private val navigator: Navigator by inject()

    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var movieViewHolderFactory: MovieViewHolderFactory
    private lateinit var lastestAdapter: BaseRecyclerAdapter<LatestMovie>
    private lateinit var nowPlayingAdapter: BaseRecyclerAdapter<NowPlayingMovie>
    private lateinit var popularAdapter: BaseRecyclerAdapter<PopularMovie>
    private lateinit var topRatedAdapter: BaseRecyclerAdapter<TopRatedMovie>
    private lateinit var trendingAdapter: BaseRecyclerAdapter<TrendingMovie>
    private lateinit var upcomingAdapter: BaseRecyclerAdapter<UpcomingMovie>

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
        val size = screenSize()
        movieViewHolderFactory = MovieViewHolderFactory(
            this,
            size,
            "https://image.tmdb.org/t/p/"
        )

        initLatestRecycler()
        initNowPlayingRecycler()
        initPopularRecycler()
        initTopRatedRecycler()
        initTrendingRecycler()
        initUpcomingRecycler()
    }

    private fun initLatestRecycler() {
        lastestAdapter = BaseRecyclerAdapter(movieViewHolderFactory)
        lastestAdapter.bind<LatestMovie, LatestMovieViewHolder>()

        latest_movies_list.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        latest_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        latest_movies_list.setHasFixedSize(true)
        lastestAdapter.setItemClickListener { position, view ->
            val element = lastestAdapter.getItem(position)?.let {
                viewModel.handledMovieItemSelected(it.id)
            }
        }
        latest_movies_list.adapter = lastestAdapter
    }

    private fun initNowPlayingRecycler() {
        nowPlayingAdapter = BaseRecyclerAdapter(movieViewHolderFactory)
        nowPlayingAdapter.bind<NowPlayingMovie, NowPlayingMovieViewHolder>()

        now_playing_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        now_playing_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        now_playing_movies_list.setHasFixedSize(true)
        nowPlayingAdapter.setItemClickListener { position, view ->
            val element = nowPlayingAdapter.getItem(position)?.let {
                viewModel.handledMovieItemSelected(it.id)
            }
        }
        now_playing_movies_list.adapter = nowPlayingAdapter
    }

    private fun initPopularRecycler() {
        popularAdapter = BaseRecyclerAdapter(movieViewHolderFactory)
        popularAdapter.bind<PopularMovie, PopularMovieViewHolder>()

        popular_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        popular_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        popular_movies_list.setHasFixedSize(true)
        popularAdapter.setItemClickListener { position, view ->
            val element = popularAdapter.getItem(position)?.let {
                viewModel.handledMovieItemSelected(it.id)
            }
        }
        popular_movies_list.adapter = popularAdapter
    }

    private fun initTopRatedRecycler() {
        topRatedAdapter = BaseRecyclerAdapter(movieViewHolderFactory)
        topRatedAdapter.bind<TopRatedMovie, TopRatedMovieViewHolder>()

        top_rated_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        top_rated_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        top_rated_movies_list.setHasFixedSize(true)
        topRatedAdapter.setItemClickListener { position, view ->
            val element = topRatedAdapter.getItem(position)?.let {
                viewModel.handledMovieItemSelected(it.id)
            }
        }
        top_rated_movies_list.adapter = topRatedAdapter
    }

    private fun initTrendingRecycler() {
        trendingAdapter = BaseRecyclerAdapter(movieViewHolderFactory)
        trendingAdapter.bind<TrendingMovie, TrendingMovieViewHolder>()

        trending_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        trending_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        trending_movies_list.setHasFixedSize(true)
        trendingAdapter.setItemClickListener { position, view ->
            val element = trendingAdapter.getItem(position)?.let {
                viewModel.handledMovieItemSelected(it.id)
            }
        }
        trending_movies_list.adapter = trendingAdapter
    }

    private fun initUpcomingRecycler() {
        upcomingAdapter = BaseRecyclerAdapter(movieViewHolderFactory)
        upcomingAdapter.bind<UpcomingMovie, UpcomingMovieViewHolder>()

        upcoming_movies_list.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        upcoming_movies_list.addItemDecoration(PaddingDecoration(resources, 12, 6, 12))
        upcoming_movies_list.setHasFixedSize(true)
        upcomingAdapter.setItemClickListener { position, view ->
            val element = upcomingAdapter.getItem(position)?.let {
                viewModel.handledMovieItemSelected(it.id)
            }
        }
        upcoming_movies_list.adapter = upcomingAdapter
    }

    private fun initViewModel() {
        observe(viewModel.latestMovie) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    lastestAdapter.addAll(result.data)
                }
                is Result.Error -> {

                }
            }
        }

        observe(viewModel.nowPlayingMovies) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    nowPlayingAdapter.addAll(result.data as List<NowPlayingMovie>)
                }
                is Result.Error -> {

                }
            }
        }

        observe(viewModel.popularMovies) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    popularAdapter.addAll(result.data as List<PopularMovie>)
                }
                is Result.Error -> {

                }
            }
        }

        observe(viewModel.topRatedMovies) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    topRatedAdapter.addAll(result.data as List<TopRatedMovie>)
                }
                is Result.Error -> {

                }
            }
        }

        observe(viewModel.trendingMovies) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    trendingAdapter.addAll(result.data as List<TrendingMovie>)
                }
                is Result.Error -> {

                }
            }
        }

        observe(viewModel.upcomingMovies) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    upcomingAdapter.addAll(result.data as List<UpcomingMovie>)
                }
                is Result.Error -> {

                }
            }
        }
    }

    private fun showLoading(loading: Boolean) {
        when (loading) {
            true -> {
                progress_bar_layout.show()
            }
            false -> {
                progress_bar_layout.hide()
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
