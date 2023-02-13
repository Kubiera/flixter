package com.example.flixster

import com.google.gson.annotations.SerializedName

class PlayingMovie {
    @SerializedName("title")
    var title: String? = null

    @SerializedName("poster_path")
    var movieImage: String? = null

    @SerializedName("overview")
    var description: String? = null

    @SerializedName("backdrop_path")
    var backdrop: String? = null
}