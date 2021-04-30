package com.dicoding.auliarosyida.moviesapp.ui.detailpage

import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.moviesapp.model.MovieEntity
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies

class DetailViewModel: ViewModel() {
    private lateinit var detailId: String

    fun setSelectedDetail(detailId: String) {
        this.detailId = detailId
    }

    fun getEntity(): MovieEntity {
        lateinit var entity: MovieEntity
        val listTempMovies = DataMovies.generateMovies()
        val listTempTvShows = DataMovies.generateTvShows()
        when(detailId.first()) {
            'm' -> {
                for (movieEntity in listTempMovies) {
                    if (movieEntity.id == detailId) {
                        entity = movieEntity
                    }
                }}
            't' -> {
                for (tvshowEntity in listTempTvShows) {
                    if (tvshowEntity.id == detailId) {
                        entity = tvshowEntity
                    }
                }}
        }
        return entity
    }
}