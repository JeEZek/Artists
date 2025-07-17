package com.pomaskin.artists.data.model.tracks

import com.google.gson.annotations.SerializedName

data class TopTracksDto(
    @SerializedName ("track") val trackList: List<TrackDto>
)
