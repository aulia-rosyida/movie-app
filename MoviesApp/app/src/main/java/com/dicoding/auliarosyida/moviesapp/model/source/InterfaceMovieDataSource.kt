package com.dicoding.auliarosyida.moviesapp.model.source

import androidx.lifecycle.LiveData
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

interface InterfaceMovieDataSource {
    fun getAllMovies(): LiveData<List<MovieResponse>>

    fun getAllTvShows(): LiveData<List<MovieResponse>>

    fun getDetailMovie(movieId: String): LiveData<MovieResponse>

    fun getDetailTvShow(tvShowId: String): LiveData<MovieResponse>
}