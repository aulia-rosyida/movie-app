package com.dicoding.auliarosyida.moviesapp.ui.detailpage

import com.dicoding.auliarosyida.moviesapp.utils.DataMovies
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataMovies.generateMovies()[0]
    private val dummyTvShow = DataMovies.generateTvShows()[0]
    private val tempId = dummyMovie.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedDetail(tempId)
    }

    @Test
    fun testGetMovieEntity() {
        viewModel.setSelectedDetail(dummyMovie.id)
        val movieEntity = viewModel.getEntity()

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.poster, movieEntity.poster)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.quote, movieEntity.quote)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.releaseYear, movieEntity.releaseYear)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.status, movieEntity.status)
        assertEquals(dummyMovie.originalLanguage, movieEntity.originalLanguage)
    }

    @Test
    fun testGetTvShowEntity() {
        viewModel.setSelectedDetail(dummyTvShow.id)
        val tvShowEntity = viewModel.getEntity()

        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.poster, tvShowEntity.poster)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.quote, tvShowEntity.quote)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.releaseYear, tvShowEntity.releaseYear)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.duration, tvShowEntity.duration)
        assertEquals(dummyTvShow.status, tvShowEntity.status)
        assertEquals(dummyTvShow.originalLanguage, tvShowEntity.originalLanguage)
    }
}