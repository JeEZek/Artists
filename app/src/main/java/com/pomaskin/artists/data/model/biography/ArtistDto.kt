package com.pomaskin.artists.data.model.biography

import com.google.gson.annotations.SerializedName

data class ArtistDto(
    @SerializedName ("name") val name: String,
    @SerializedName ("image") val image: List<ImageDto>,
    @SerializedName ("bio") val bio: BioDto,
)
