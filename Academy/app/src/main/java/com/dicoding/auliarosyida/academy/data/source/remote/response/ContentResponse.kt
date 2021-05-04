package com.dicoding.auliarosyida.academy.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Sebelum Anda membuat RemoteDataSource,
 * Anda harus membuat kelas ModelResponse dan sebuah kelas helper untuk membaca JSON jadi Array
 * */

@Parcelize
data class ContentResponse(
    var moduleId: String,
    var content: String
) : Parcelable