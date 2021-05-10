package com.dicoding.auliarosyida.moviesapp.ui.detailpage

import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {
    private lateinit var detailId: String

    fun setSelectedDetail(detailId: String) {
        this.detailId = detailId
    }

    fun getEntity(): MovieResponse {
        lateinit var entity: MovieResponse

        when(detailId.first()) {
            'm' -> entity = movieRepository.getDetailMovie(detailId)
            't' -> entity = movieRepository.getDetailTvShow(detailId)
        }
        return entity
    }
}