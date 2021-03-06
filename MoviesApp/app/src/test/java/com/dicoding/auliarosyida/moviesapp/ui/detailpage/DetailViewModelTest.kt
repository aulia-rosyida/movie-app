package com.dicoding.auliarosyida.moviesapp.ui.detailpage

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataMovies.generateMovies()[0]
    private val dummyTvShow = DataMovies.generateTvShows()[0]
    private val tempMovieId = dummyMovie.id
    private val tempTvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var detailObserver: Observer<MovieResponse>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
        viewModel.setSelectedDetail(tempMovieId)
    }

    @Test
    fun testGetMovieEntity() {
        val movie = MutableLiveData<MovieResponse>()
        movie.value = dummyMovie

        `when`(movieRepository.getDetailMovie(tempMovieId)).thenReturn(movie)
        val movieEntity = viewModel.getEntity().value as MovieResponse
        verify(movieRepository).getDetailMovie(tempMovieId)

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

        viewModel.getEntity().observeForever(detailObserver)
        verify(detailObserver).onChanged(dummyMovie)
    }

    @Test
    fun testGetTvShowEntity() {
        viewModel.setSelectedDetail(tempTvShowId)
        val tvShow = MutableLiveData<MovieResponse>()
        tvShow.value = dummyTvShow

        `when`(movieRepository.getDetailTvShow(tempTvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getEntity().value as MovieResponse
        verify(movieRepository).getDetailTvShow(tempTvShowId)

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

        viewModel.getEntity().observeForever(detailObserver)
        verify(detailObserver).onChanged(dummyTvShow)
    }
}