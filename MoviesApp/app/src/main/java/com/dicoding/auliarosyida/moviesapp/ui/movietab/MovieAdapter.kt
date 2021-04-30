package com.dicoding.auliarosyida.moviesapp.ui.movietab

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.auliarosyida.moviesapp.R
import com.dicoding.auliarosyida.moviesapp.databinding.ItemsMovieBinding
import com.dicoding.auliarosyida.moviesapp.model.MovieEntity
import com.dicoding.auliarosyida.moviesapp.ui.DetailActivity

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.CourseViewHolder>() {
    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsAcademyBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listMovies[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listMovies.size


    class CourseViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                Glide.with(itemView.context)
                        .load(movie.poster)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)

                tvItemTitle.text = movie.title
                tvItemDuration.text = movie.duration
                tvItemQuotes.text = movie.quote

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.extraMovie, movie.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}