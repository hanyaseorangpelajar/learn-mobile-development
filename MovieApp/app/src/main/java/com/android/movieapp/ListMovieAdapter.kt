package com.android.movieapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.content.Context
import java.security.AccessController.getContext

class ListMovieAdapter(list: ArrayList<Movie>?) :
    RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {
    private var listMovies: ArrayList<Movie>? = null

    init {
        listMovies = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie,
            parent, false
        )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ListMovieAdapter.ListViewHolder,
        position: Int
    ){
        val movie = listMovies!![position]
        Glide.with(holder.itemView.context)
            .load(movie.getPosterImage())
            .into(holder.ivMoviePoster!!)
        holder.tvMovieTitle!!.text = movie.getTitle()
        holder.tvMovieDescription!!.text = movie.getDescription()
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            // Pass movie details to the detail activity
            intent.putExtra("title", movie.getTitle())
            intent.putExtra("description", movie.getDescription())
            intent.putExtra("posterImage", movie.getPosterImage())

            holder.itemView.context.startActivity(intent)

        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public var ivMoviePoster: ImageView? = null
        public var tvMovieTitle: TextView? = null
        public var tvMovieDescription: android.widget.TextView? = null

        init {
            ivMoviePoster = itemView.findViewById(R.id.iv_movie_poster);
            tvMovieTitle = itemView.findViewById(R.id.tv_movie_title);
            tvMovieDescription = itemView.findViewById(R.id.tv_movie_description);
        }
    }

    override fun getItemCount(): Int {
        return listMovies!!.size
    }

}
