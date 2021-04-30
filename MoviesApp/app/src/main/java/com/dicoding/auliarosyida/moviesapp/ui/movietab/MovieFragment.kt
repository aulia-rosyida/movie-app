package com.dicoding.auliarosyida.moviesapp.ui.movietab

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.auliarosyida.moviesapp.R
import com.dicoding.auliarosyida.moviesapp.databinding.MovieFragmentBinding
import com.dicoding.auliarosyida.moviesapp.utils.DataMovies

class MovieFragment : Fragment() {

    private lateinit var movieFragmentBinding: MovieFragmentBinding

//    companion object {
//        fun newInstance() = MovieFragment()
//    }
//
//    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieFragmentBinding = MovieFragmentBinding.inflate(layoutInflater, container, false)
        return movieFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       // viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        if (activity != null) {
            val movies = DataMovies.listMovieData
            val movieAdapter = MovieAdapter()
            movieAdapter.setMovies(movies)

            with(movieFragmentBinding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}