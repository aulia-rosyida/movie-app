package com.dicoding.auliarosyida.moviesapp.model

data class MovieEntity (
    var poster: Int = 0,
    var title: String,
    var description: String,
    var releaseDate: String,
    var genre: String,
    var status: String,
    var duration: String,
    var originalLanguage: String
)