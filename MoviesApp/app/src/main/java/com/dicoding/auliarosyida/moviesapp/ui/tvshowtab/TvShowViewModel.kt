package com.dicoding.auliarosyida.moviesapp.ui.tvshowtab

import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.moviesapp.model.MovieEntity
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies

class TvShowViewModel : ViewModel() {

    fun getTvShows(): List<MovieEntity> = DataMovies.generateTvShows()
}