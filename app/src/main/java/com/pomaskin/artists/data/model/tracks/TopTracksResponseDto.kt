package com.pomaskin.artists.data.model.tracks

import com.google.gson.annotations.SerializedName

data class TopTracksResponseDto(
    @SerializedName("toptracks") val topTracks: TopTracksDto
)
