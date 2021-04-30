package com.dicoding.auliarosyida.moviesapp.ui.tvshowtab

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.auliarosyida.moviesapp.R
import com.dicoding.auliarosyida.moviesapp.databinding.MovieFragmentBinding
import com.dicoding.auliarosyida.moviesapp.databinding.TvShowFragmentBinding
import com.dicoding.auliarosyida.moviesapp.ui.movietab.MovieAdapter
import com.dicoding.auliarosyida.moviesapp.ui.movietab.MovieViewModel
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies

class TvShowFragment : Fragment() {

    private lateinit var tvShowFragmentBinding: TvShowFragmentBinding

//    private lateinit var viewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tvShowFragmentBinding = TvShowFragmentBinding.inflate(layoutInflater, container, false)
        return tvShowFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val tvShowViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tvShows = tvShowViewModel.getTvShows()
            val movieAdapter = MovieAdapter()
            movieAdapter.setMovies(tvShows)

            with(tvShowFragmentBinding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}