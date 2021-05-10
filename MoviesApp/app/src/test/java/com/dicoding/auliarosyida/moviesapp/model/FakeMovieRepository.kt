package com.dicoding.auliarosyida.moviesapp.model

import com.dicoding.auliarosyida.moviesapp.model.source.InterfaceMovieDataSource
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.RemoteMovieDataSource
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

/**
 *  MovieRepository sebagai filter antara remote dan local
 *  agar apa yang ada di View tidak banyak berubah
 * */
class FakeMovieRepository (private val remoteMovieDataSource: RemoteMovieDataSource) :
    InterfaceMovieDataSource {

    override fun getAllMovies(): List<MovieResponse> {
        val movieResponses = remoteMovieDataSource.getAllMovies()
        val movieList = ArrayList<MovieResponse>()

        movieList.addAll(movieResponses)
        return movieList
    }

    override fun getAllTvShows(): List<MovieResponse> {
        val tvShowResponses = remoteMovieDataSource.getAllTvShows()
        val tvShowList = ArrayList<MovieResponse>()

        tvShowList.addAll(tvShowResponses)
        return tvShowList
    }

    override fun getDetailMovie(movieId: String): MovieResponse {
        val movieResponses = remoteMovieDataSource.getAllMovies()
        lateinit var movie: MovieResponse
        for (response in movieResponses) {
            if (response.id == movieId) {
                movie = response
            }
        }
        return movie
    }

    override fun getDetailTvShow(tvShowId: String): MovieResponse {
        val tvShowResponses = remoteMovieDataSource.getAllTvShows()
        lateinit var tvShow: MovieResponse
        for (response in tvShowResponses) {
            if (response.id == tvShowId) {
                tvShow = response
            }
        }
        return tvShow
    }
}