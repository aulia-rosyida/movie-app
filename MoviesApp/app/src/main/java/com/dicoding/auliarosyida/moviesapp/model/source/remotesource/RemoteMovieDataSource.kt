package com.dicoding.auliarosyida.moviesapp.model.source.remotesource

import android.os.Handler
import android.os.Looper
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse
import com.dicoding.auliarosyida.moviesapp.utils.IdlingResourceEspresso
import com.dicoding.auliarosyida.moviesapp.utils.JsonResponseHelper

class RemoteMovieDataSource private constructor(private val jsonResponseHelper: JsonResponseHelper) {

    private val handlerLooper = Handler(Looper.getMainLooper())

    companion object {
        private const val serviceLatencyInMillis: Long = 2000

        @Volatile
        private var instance: RemoteMovieDataSource? = null

        fun getInstance(helper: JsonResponseHelper): RemoteMovieDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteMovieDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(callback: LoadMoviesCallback){
        IdlingResourceEspresso.increment()
        handlerLooper.postDelayed({
            callback.onAllMoviesReceived(jsonResponseHelper.loadMovies())
            IdlingResourceEspresso.decrement()
         }, serviceLatencyInMillis)
    }

    fun getAllTvShows(callback: LoadMoviesCallback){
        IdlingResourceEspresso.increment()
        handlerLooper.postDelayed({
            callback.onAllMoviesReceived(jsonResponseHelper.loadTvShows())
            IdlingResourceEspresso.decrement()
        }, serviceLatencyInMillis)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
    }
}


