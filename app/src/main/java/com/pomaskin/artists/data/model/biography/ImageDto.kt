package com.pomaskin.artists.data.model.biography

import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName ("#text") val imageUrl: String,
    @SerializedName ("size") val size: String,
)
