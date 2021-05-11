package com.dicoding.auliarosyida.moviesapp.ui.tvshowtab

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getTvShows(): LiveData<List<MovieResponse>> = movieRepository.getAllTvShows()
}