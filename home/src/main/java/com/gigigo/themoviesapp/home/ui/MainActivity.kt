package com.gigigo.themoviesapp.home.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gigigo.baserecycleradapter.adapter.BaseRecyclerAdapter
import com.gigigo.themoviesapp.base.ui.navigation.Navigator
import com.gigigo.themoviesapp.base.ui.utils.extensions.hide
import com.gigigo.themoviesapp.base.ui.utils.extensions.screenSize
import com.gigigo.themoviesapp.base.ui.utils.extensions.show
import com.gigigo.themoviesapp.home.R
import com.gigigo.themoviesapp.home.di.homeDataModule
import com.gigigo.themoviesapp.home.di.homeDomainModule
import com.gigigo.themoviesapp.home.di.homeModules
import com.gigigo.themoviesapp.home.di.homePresentationModule
import com.gigigo.themoviesapp.home.domain.model.Movie
import com.gigigo.themoviesapp.home.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.drawer_layout
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.app_bar_main.toolbar
import kotlinx.android.synthetic.main.content_main.movies_list
import kotlinx.android.synthetic.main.content_main.progress_bar_layout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private val _job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + _job

    private val navigator: Navigator by inject()

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var adapter: BaseRecyclerAdapter<Movie>

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
        setSupportActionBar(toolbar)

        initNavigationView()

        initRecyclerView()
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
                R.id.nav_camera -> {
                    // Handle the camera action
                }
                R.id.nav_gallery -> {

                }
                R.id.nav_slideshow -> {

                }
                R.id.nav_manage -> {

                }
                R.id.nav_share -> {

                }
                R.id.nav_send -> {

                }
            }

            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun initRecyclerView() {
        val size = screenSize()

        val itemDecoratorVertical = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val itemDecoratorHorizontal = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        //itemDecoratorHorizontal.setDrawable(ContextCompat.getDrawable(this, R.))

        adapter =
            BaseRecyclerAdapter(MovieViewHolderFactory(this, size, "https://image.tmdb.org/t/p/"))
        adapter.bind<Movie, MovieViewHolder>()

        val spanCount = if (size.widthPixels < size.heightPixels) 3 else 4
        //movies_list.layoutManager = GridLayoutManager(this, spanCount, RecyclerView.VERTICAL, false)
        movies_list.layoutManager =
            StaggeredGridLayoutManager(spanCount, GridLayoutManager.VERTICAL)

        movies_list.addItemDecoration(itemDecoratorVertical)
        movies_list.addItemDecoration(itemDecoratorHorizontal)

        movies_list.setHasFixedSize(true)
        movies_list.adapter = adapter
    }

    private fun initViewModel() {
        viewModel.isLoading.observe(this, Observer {
            showLoading(it)
        })
        viewModel.trendingMovies.observe(this, Observer {
            launch(Dispatchers.Main) {
                adapter.addAll(it)
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
