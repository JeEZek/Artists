package com.pomaskin.artists.data.model.biography

import com.google.gson.annotations.SerializedName

data class ArtistResponseDto(
    @SerializedName ("artist") val artist: ArtistDto
)
