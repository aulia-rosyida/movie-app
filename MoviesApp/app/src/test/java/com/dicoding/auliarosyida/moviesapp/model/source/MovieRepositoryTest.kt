package com.dicoding.auliarosyida.moviesapp.model.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.auliarosyida.moviesapp.model.FakeMovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.RemoteMovieDataSource
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies
import com.dicoding.auliarosyida.moviesapp.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteMovieDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponses = DataMovies.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].id

    private val tvShowResponses = DataMovies.generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponses[0].id

    @Test
    fun testGetAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteMovieDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun testGetAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteMovieDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(tvShowResponses)
            null
        }.`when`(remote).getAllTvShows(any())

        val tvShowEntities = LiveDataTestUtil.getValue(movieRepository.getAllTvShows())
        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun testGetDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteMovieDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())

        val resultMovie = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movieId))
        verify(remote).getAllMovies(any())
        assertNotNull(resultMovie)
        assertEquals(movieResponses[0].genre, resultMovie.genre)
    }

    @Test
    fun testGetDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteMovieDataSource.LoadMoviesCallback)
                    .onAllMoviesReceived(tvShowResponses)
            null
        }.`when`(remote).getAllTvShows(any())

        val resultTvShow = LiveDataTestUtil.getValue(movieRepository.getDetailTvShow(tvShowId))
        verify(remote).getAllTvShows(any())
        assertNotNull(resultTvShow)
        assertEquals(tvShowResponses[0].genre, resultTvShow.genre)
    }
}