package com.dicoding.auliarosyida.moviesapp.ui.tvshowtab

import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun testGetTvShows() {
        `when`(movieRepository.getAllTvShows()).thenReturn(DataMovies.generateTvShows() as ArrayList<MovieResponse>)
        val tvShowEntities = viewModel.getTvShows()
        verify(movieRepository).getAllTvShows()

        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(10, tvShowEntities.size)
    }
}