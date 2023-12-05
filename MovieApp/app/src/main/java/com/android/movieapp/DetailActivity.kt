package com.android.movieapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val posterImage = intent.getIntExtra("posterImage", R.drawable.movie_1)

        val tvDetailTitle = findViewById<TextView>(R.id.tvDetailTitle)
        tvDetailTitle.text = title

        val tvDetailDescription = findViewById<TextView>(R.id.tvDetailDescription)
        tvDetailDescription.text = description

        val imageViewDetailPoster = findViewById<ImageView>(R.id.imageViewDetailPoster)
        Glide.with(this)
            .load(posterImage)
            .into(imageViewDetailPoster)

         val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            onBackButtonClick()
        }

    }

    // Handle back button click
    private fun onBackButtonClick() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Optional: Finish the current activity
    }

}
