package com.dicoding.auliarosyida.moviesapp.model.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.RemoteMovieDataSource
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.RemoteMovieDataSource.LoadMoviesCallback
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

/**
 *  MovieRepository sebagai filter antara remote dan local
 *  agar apa yang ada di View tidak banyak berubah
 * */
class MovieRepository private constructor(private val remoteMovieDataSource: RemoteMovieDataSource) : InterfaceMovieDataSource {

    companion object {
        @Volatile
//        @JvmStatic
        private var instance: MovieRepository? = null

        // filter antara remote dan local
        fun getInstance(remoteData: RemoteMovieDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<MovieResponse>> {
        val movieResults = MutableLiveData<List<MovieResponse>>()

        remoteMovieDataSource.getAllMovies(object : LoadMoviesCallback {
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

        remoteMovieDataSource.getAllTvShows(object : LoadMoviesCallback {
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

        remoteMovieDataSource.getAllMovies(object : LoadMoviesCallback {
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

        remoteMovieDataSource.getAllTvShows(object : LoadMoviesCallback {
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