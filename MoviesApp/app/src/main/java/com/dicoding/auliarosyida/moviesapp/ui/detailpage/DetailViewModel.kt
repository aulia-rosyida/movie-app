package com.dicoding.auliarosyida.moviesapp.ui.detailpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.moviesapp.SingleEvent
import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

const val prefixIdMovie : Char = 'm'
const val prefixIdTvShow : Char = 't'

class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {
    private lateinit var detailId: String

    fun setSelectedDetail(detailId: String) {
        this.detailId = detailId
    }

    fun getEntity(): LiveData<MovieResponse> {
        lateinit var entity: LiveData<MovieResponse>

        when(detailId.first()) {
            prefixIdMovie -> entity = movieRepository.getDetailMovie(detailId)
            prefixIdTvShow -> entity = movieRepository.getDetailTvShow(detailId)
        }
        return entity
    }
}