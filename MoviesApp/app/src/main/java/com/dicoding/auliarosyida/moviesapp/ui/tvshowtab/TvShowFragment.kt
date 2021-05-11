package com.dicoding.auliarosyida.moviesapp.ui.tvshowtab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.auliarosyida.moviesapp.databinding.TvShowFragmentBinding
import com.dicoding.auliarosyida.moviesapp.ui.movietab.MovieAdapter
import com.dicoding.auliarosyida.moviesapp.viewmodel.VMAppFactory


class TvShowFragment : Fragment() {

    private lateinit var tvShowFragmentBinding: TvShowFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        tvShowFragmentBinding = TvShowFragmentBinding.inflate(layoutInflater, container, false)
        return tvShowFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val tvShowFactory = VMAppFactory.getInstance(requireActivity())
            val tvShowViewModel = ViewModelProvider(this, tvShowFactory)[TvShowViewModel::class.java]

            val movieAdapter = MovieAdapter()
            tvShowFragmentBinding.progressbarTvshow.visibility = View.VISIBLE

            tvShowViewModel.getTvShows().observe(this, { tvShows ->
                tvShowFragmentBinding.progressbarTvshow.visibility = View.GONE
                movieAdapter.setMovies(tvShows)
                movieAdapter.notifyDataSetChanged()
            })

            with(tvShowFragmentBinding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}