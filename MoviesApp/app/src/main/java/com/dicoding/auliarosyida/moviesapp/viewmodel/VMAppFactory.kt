package com.dicoding.auliarosyida.moviesapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.auliarosyida.moviesapp.di.RepoInjection
import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.ui.detailpage.DetailViewModel
import com.dicoding.auliarosyida.moviesapp.ui.movietab.MovieViewModel
import com.dicoding.auliarosyida.moviesapp.ui.tvshowtab.TvShowViewModel

class VMAppFactory private constructor(private val mMovieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: VMAppFactory? = null

    fun getInstance(context: Context): VMAppFactory =
        instance ?: synchronized(this) {
            instance ?: VMAppFactory(RepoInjection.provideMovieRepository(context)).apply {
                instance = this
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}