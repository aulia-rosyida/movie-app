package com.dicoding.auliarosyida.moviesapp.ui.detailpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.auliarosyida.moviesapp.R
import com.dicoding.auliarosyida.moviesapp.databinding.ActivityDetailBinding
import com.dicoding.auliarosyida.moviesapp.databinding.ContentDetailMovieBinding
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse
import com.dicoding.auliarosyida.moviesapp.viewmodel.VMAppFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailMovieBinding

    companion object {
        const val extraMovie = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailFactory = VMAppFactory.getInstance(this)
        val detailViewModel = ViewModelProvider(this, detailFactory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {

            val tempId = extras.getString(extraMovie)
            if (tempId != null ) {

                detailViewModel.setSelectedDetail(tempId)
//                detailViewModel.getEntity().observe(this, { entity ->
//                    detailContentBinding.progressBarDetailContent.visibility = View.VISIBLE
//                })
                detailViewModel.getEntity().observe(this, { detailEntity -> populateCard(detailEntity) })

            }
        }
    }

    private fun populateCard(entity: MovieResponse) {
        detailContentBinding.progressBarDetailContent.visibility = View.GONE
        detailContentBinding.textYear.text = entity.releaseYear
        detailContentBinding.textDuration.text = entity.duration
        detailContentBinding.textTitle.text = entity.title
        detailContentBinding.textGenre.text = entity.genre

        Glide.with(this)
                .load(entity.poster)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)

        detailContentBinding.textQuote.text = entity.quote
        detailContentBinding.textOverview.text = entity.overview
        detailContentBinding.textStatus.text = entity.status
        detailContentBinding.textLang.text = entity.originalLanguage
    }
}