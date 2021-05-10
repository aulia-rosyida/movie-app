package com.dicoding.auliarosyida.moviesapp.di

import android.content.Context
import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.RemoteMovieDataSource
import com.dicoding.auliarosyida.moviesapp.utils.JsonResponseHelper

object RepoInjection {
    fun provideMovieRepository(context: Context): MovieRepository {

        val remoteMovieDataSource = RemoteMovieDataSource.getInstance(JsonResponseHelper(context))

        return MovieRepository.getInstance(remoteMovieDataSource)
    }
}