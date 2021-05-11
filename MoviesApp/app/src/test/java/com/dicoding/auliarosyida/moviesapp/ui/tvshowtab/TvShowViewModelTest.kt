package com.dicoding.auliarosyida.moviesapp.ui.tvshowtab

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.auliarosyida.moviesapp.model.source.MovieRepository
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
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

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var tvShowOserver: Observer<List<MovieResponse>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun testGetTvShows() {
        val dummyTvShows = DataMovies.generateTvShows()
        val tvShows = MutableLiveData<List<MovieResponse>>()
        tvShows.value = dummyTvShows

        `when`(movieRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShows().value
        verify(movieRepository).getAllTvShows()

        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(10, tvShowEntities?.size)

        viewModel.getTvShows().observeForever(tvShowOserver)
        verify(tvShowOserver).onChanged(dummyTvShows)
    }
}