package com.dicoding.auliarosyida.moviesapp.model.source

import com.dicoding.auliarosyida.moviesapp.model.FakeMovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.RemoteMovieDataSource
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class MovieRepositoryTest {

    private val remote = Mockito.mock(RemoteMovieDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponses = DataMovies.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].id

    private val tvShowResponses = DataMovies.generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponses[0].id

    @Test
    fun testGetAllMovies() {
        `when`(remote.getAllMovies()).thenReturn(movieResponses)
        val movieEntities = movieRepository.getAllMovies()
        verify(remote).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun testGetAllTvShows() {
        `when`(remote.getAllTvShows()).thenReturn(tvShowResponses)
        val tvShowEntities = movieRepository.getAllTvShows()
        verify(remote).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun testGetDetailMovie() {
        `when`(remote.getAllMovies()).thenReturn(movieResponses)
        val resultMovie = movieRepository.getDetailMovie(movieId)
        verify(remote).getAllMovies()
        assertNotNull(resultMovie)
        assertEquals(movieResponses[0].genre, resultMovie.genre)
    }

    @Test
    fun testGetDetailTvShow() {
        `when`(remote.getAllTvShows()).thenReturn(tvShowResponses)
        val resultTvShow = movieRepository.getDetailTvShow(tvShowId)
        verify(remote).getAllTvShows()
        assertNotNull(resultTvShow)
        assertEquals(tvShowResponses[0].genre, resultTvShow.genre)
    }
}