package com.dicoding.auliarosyida.moviesapp.ui.movietab

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.auliarosyida.moviesapp.databinding.MovieFragmentBinding
import com.dicoding.auliarosyida.moviesapp.viewmodel.VMAppFactory

class MovieFragment : Fragment() {

    private lateinit var movieFragmentBinding: MovieFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        movieFragmentBinding = MovieFragmentBinding.inflate(layoutInflater, container, false)
        return movieFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val movieFactory = VMAppFactory.getInstance(requireActivity())
            val movieViewModel = ViewModelProvider(this, movieFactory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()
            movieFragmentBinding.progressbarMovie.visibility = View.VISIBLE

            movieViewModel.getMovies().observe(this, { movies ->
                movieFragmentBinding.progressbarMovie.visibility = View.GONE
                movieAdapter.setMovies(movies)
                movieAdapter.notifyDataSetChanged()
            })

            with(movieFragmentBinding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}