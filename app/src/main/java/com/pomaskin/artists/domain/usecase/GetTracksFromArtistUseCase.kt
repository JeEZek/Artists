package com.pomaskin.artists.domain.usecase

import com.pomaskin.artists.domain.entity.Track
import com.pomaskin.artists.domain.repository.ArtistRepository
import kotlinx.coroutines.flow.Flow

class GetTracksFromArtistUseCase(
    private val repository: ArtistRepository
) {

    operator fun invoke(artistName: String): Flow<List<Track>> {
        return repository.getTracksFromArtist(artistName)
    }
}