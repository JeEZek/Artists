package com.pomaskin.artists.data.model.tracks

import com.google.gson.annotations.SerializedName

data class TrackDto (
    @SerializedName("name") val name: String,
    @SerializedName("image") val imageList: List<ImageDto>,
)