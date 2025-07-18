package com.pomaskin.artists.presentation.biography

import com.pomaskin.artists.domain.entity.Artist

sealed class BiographyScreenState {

    object Initial : BiographyScreenState()

    object Loading : BiographyScreenState()

    data class Content(
        val artist: Artist
    ) : BiographyScreenState()
}