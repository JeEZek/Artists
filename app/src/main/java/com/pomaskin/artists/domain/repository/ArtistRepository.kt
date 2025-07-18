package com.pomaskin.artists.domain.repository

import com.pomaskin.artists.domain.entity.Artist
import com.pomaskin.artists.domain.entity.Track
import kotlinx.coroutines.flow.Flow

interface ArtistRepository {

    fun getArtistInfo(artistName: String): Flow<Artist>

    fun getTracksFromArtist(artistName: String): Flow<List<Track>>
}