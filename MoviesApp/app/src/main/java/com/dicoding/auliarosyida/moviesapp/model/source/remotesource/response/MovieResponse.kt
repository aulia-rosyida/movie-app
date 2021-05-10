package com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("id")
    var id: String = "",
    @SerializedName("poster")
    var poster: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("quote")
    var quote: String = "",
    @SerializedName("overview")
    var overview: String = "",
    @SerializedName("releaseYear")
    var releaseYear: String = "",
    @SerializedName("genre")
    var genre: String = "",
    @SerializedName("duration")
    var duration: String = "",
    @SerializedName("status")
    var status: String = "",
    @SerializedName("originalLanguage")
    var originalLanguage: String = ""
) : Parcelable
