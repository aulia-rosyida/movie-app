package com.dicoding.auliarosyida.moviesapp.ui.movietab

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieResponse>> = movieRepository.getAllMovies()
}