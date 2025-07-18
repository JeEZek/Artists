package com.pomaskin.artists.presentation.tracks

import com.pomaskin.artists.domain.entity.Artist
import com.pomaskin.artists.domain.entity.Track
import com.pomaskin.artists.presentation.biography.BiographyScreenState

sealed class TracksScreenState {


    object Initial : TracksScreenState()

    object Loading : TracksScreenState()

    object Error : TracksScreenState()

    data class Content(
        val tracks: List<Track>
    ) : TracksScreenState()
}