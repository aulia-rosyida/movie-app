package com.dicoding.auliarosyida.moviesapp.ui.movietab

import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.moviesapp.model.MovieEntity
import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): List<MovieResponse> = movieRepository.getAllMovies()
}