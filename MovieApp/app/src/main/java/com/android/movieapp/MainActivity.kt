package com.android.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var rvMovies: RecyclerView
    private var listMovies = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listMovies.addAll(MoviesData.getMovies())
        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)
        rvMovies.layoutManager = LinearLayoutManager(this)

        val listMovieAdapter = ListMovieAdapter(listMovies)
        rvMovies.adapter = listMovieAdapter
    }
}
