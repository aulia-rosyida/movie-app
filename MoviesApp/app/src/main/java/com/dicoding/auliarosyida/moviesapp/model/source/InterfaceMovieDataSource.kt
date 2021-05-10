package com.dicoding.auliarosyida.moviesapp.model.source

import com.dicoding.auliarosyida.moviesapp.model.MovieEntity

interface InterfaceMovieDataSource {
    fun getAllMovies(): List<MovieEntity>

    fun getAllTvShows(): List<MovieEntity>

    fun getDetailEntity(courseId: String): MovieEntity
}