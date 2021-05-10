package com.dicoding.auliarosyida.moviesapp.ui.movietab

import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }
    
    @Test
    fun testGetMovies() {
        `when`(movieRepository.getAllMovies()).thenReturn(DataMovies.generateMovies() as ArrayList<MovieResponse>)
        val movieEntities = viewModel.getMovies()
        verify(movieRepository).getAllMovies()

        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}