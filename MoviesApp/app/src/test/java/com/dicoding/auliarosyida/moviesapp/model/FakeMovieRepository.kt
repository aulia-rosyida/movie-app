package com.dicoding.auliarosyida.moviesapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.auliarosyida.moviesapp.model.source.InterfaceMovieDataSource
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.RemoteMovieDataSource
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

/**
 *  MovieRepository sebagai filter antara remote dan local
 *  agar apa yang ada di View tidak banyak berubah
 * */
class FakeMovieRepository (private val remoteMovieDataSource: RemoteMovieDataSource) :
    InterfaceMovieDataSource {

    override fun getAllMovies(): LiveData<List<MovieResponse>> {
        val movieResults = MutableLiveData<List<MovieResponse>>()

        remoteMovieDataSource.getAllMovies(object : RemoteMovieDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                val movieList = ArrayList<MovieResponse>()
                movieList.addAll(movieResponses)
                movieResults.postValue(movieList)
            }
        })

        return movieResults
    }

    override fun getAllTvShows(): LiveData<List<MovieResponse>> {
        val tvShowResults = MutableLiveData<List<MovieResponse>>()

        remoteMovieDataSource.getAllTvShows(object : RemoteMovieDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                val tvShowList = ArrayList<MovieResponse>()
                tvShowList.addAll(movieResponses)
                tvShowResults.postValue(tvShowList)
            }
        })

        return tvShowResults
    }

    override fun getDetailMovie(movieId: String): LiveData<MovieResponse> {
        val detailMovieResult = MutableLiveData<MovieResponse>()

        remoteMovieDataSource.getAllMovies(object : RemoteMovieDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                lateinit var aMovie: MovieResponse
                for (response in movieResponses) {
                    if (response.id == movieId) {
                        aMovie = response
                    }
                }
                detailMovieResult.postValue(aMovie)
            }
        })
        return detailMovieResult
    }

    override fun getDetailTvShow(tvShowId: String): LiveData<MovieResponse> {
        val detailTvShowResult = MutableLiveData<MovieResponse>()

        remoteMovieDataSource.getAllTvShows(object : RemoteMovieDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(tvShowResponses: List<MovieResponse>) {
                lateinit var aTvShow: MovieResponse
                for (response in tvShowResponses) {
                    if (response.id == tvShowId) {
                        aTvShow = response
                    }
                }
                detailTvShowResult.postValue(aTvShow)
            }
        })
        return detailTvShowResult
    }
}