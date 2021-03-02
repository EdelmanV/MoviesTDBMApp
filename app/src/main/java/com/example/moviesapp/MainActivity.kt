package com.example.moviesapp


import adapter.MoviesAdapter
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import rest.apiclient
import rest.apiinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    //  insertar  la Llave  de la API themoviedb.org
    private val API_KEY = "c2748f1e4940511dac6a36c7f7c0a07b"

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {

        if (API_KEY.isEmpty()) {
            Toast.makeText(
                getApplicationContext(),
                "Please obtain your API KEY from themoviedb.org first!",
                Toast.LENGTH_LONG
            ).show();
            return;
        }


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)





        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

/*
    val recyclerView = findViewById(R.id.movies_recycler_view) as RecyclerView recyclerView.setLayoutManager(LinearLayoutManager(this))
    val apiService = apiclient.getClient().create(apiinterface::class.java)
    val call = apiService.getTopRatedMovies(API_KEY)call.enqueue(object: Callback<MoviesResponse>() {
        override fun onResponse(call:Call<MoviesResponse>, response: Response<MoviesResponse>) {
            val statusCode = response.code()
            val movies = response.body().getResults()
            recyclerView.setAdapter(MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()))
        }
        fun onFailure(call:Call<MoviesResponse>, t:Throwable) {
            // Log error here since request failed
            Log.e(TAG, t.toString())

    })
  }*/


}




