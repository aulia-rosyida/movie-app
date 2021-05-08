package com.dicoding.auliarosyida.moviesapp.model.source

import com.dicoding.auliarosyida.moviesapp.model.MovieEntity

interface MovieDataSource {
    fun getAllMovies(): List<MovieEntity>

    fun getAllTvShows(): List<MovieEntity>

    fun getDetail(courseId: String): MovieEntity
}