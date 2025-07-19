package com.pomaskin.artists.presentation.tracks

import com.pomaskin.artists.domain.entity.Track

sealed class TracksScreenState {


    object Initial : TracksScreenState()

    object Loading : TracksScreenState()

    object Error : TracksScreenState()

    data class Content(
        val tracks: List<Track>
    ) : TracksScreenState()
}