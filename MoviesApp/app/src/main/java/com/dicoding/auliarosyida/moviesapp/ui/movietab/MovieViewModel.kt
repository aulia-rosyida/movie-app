package com.dicoding.auliarosyida.moviesapp.ui.movietab

import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.moviesapp.model.MovieEntity
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies

class MovieViewModel : ViewModel() {

    fun getMovies(): List<MovieEntity> = DataMovies.generateMovies()
}