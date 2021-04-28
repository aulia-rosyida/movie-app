package com.dicoding.auliarosyida.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.auliarosyida.moviesapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var detailMovieBinding: ActivityDetailBinding

    companion object {
        const val extraMovie = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailMovieBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailMovieBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}