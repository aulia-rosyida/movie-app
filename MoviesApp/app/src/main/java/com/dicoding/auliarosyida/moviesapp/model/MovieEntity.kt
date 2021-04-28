package com.dicoding.auliarosyida.moviesapp.model

data class MovieEntity (
    var poster: Int = 0,
    var title: String = "",
    var quote: String = "",
    var overview: String = "",
    var releaseYear: String = "",
    var genre: String = "",
    var duration: String = "",
    var status: String = "",
    var originalLanguage: String = ""
)