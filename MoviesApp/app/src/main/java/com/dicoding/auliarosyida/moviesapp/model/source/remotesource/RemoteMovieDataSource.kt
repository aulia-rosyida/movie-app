package com.dicoding.auliarosyida.moviesapp.model.source.remotesource

import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse
import com.dicoding.auliarosyida.moviesapp.utils.JsonResponseHelper

class RemoteMovieDataSource private constructor(private val jsonResponseHelper: JsonResponseHelper) {

    companion object {
        @Volatile
        private var instance: RemoteMovieDataSource? = null

        fun getInstance(helper: JsonResponseHelper): RemoteMovieDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteMovieDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): List<MovieResponse> = jsonResponseHelper.loadMovies()

    fun getAllTvShows(): List<MovieResponse> = jsonResponseHelper.loadTvShows()
}