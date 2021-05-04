package com.dicoding.auliarosyida.academy.data.source.remote.response

/**
 * Sebelum Anda membuat RemoteDataSource,
 * Anda harus membuat kelas ModelResponse dan sebuah kelas helper untuk membaca JSON jadi Array
 * */
data class ContentResponse(
    var moduleId: String,
    var content: String
)