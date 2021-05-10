package com.dicoding.auliarosyida.moviesapp.model.source

import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

interface InterfaceMovieDataSource {
    fun getAllMovies(): List<MovieResponse>

    fun getAllTvShows(): List<MovieResponse>

    fun getDetailMovie(movieId: String): MovieResponse

    fun getDetailTvShow(tvShowId: String): MovieResponse
}