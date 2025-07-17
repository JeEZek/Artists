package com.pomaskin.artists.data.model.biography

import com.google.gson.annotations.SerializedName

data class BioDto(
    @SerializedName ("summary") val summary: String,
    @SerializedName ("content") val content: String,
)
