package com.dicoding.auliarosyida.moviesapp.datamodel

data class MovieEntity (
    var id: String,
    var title: String,
    var description: String,
    var releaseDate: String,
    var genre: String,
    var status: String,
    var duration: String,
    var originalLanguage: String,
    var isMovie: Boolean
)