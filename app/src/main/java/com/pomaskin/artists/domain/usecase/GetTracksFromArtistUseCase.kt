package com.pomaskin.artists.domain.usecase

import com.pomaskin.artists.domain.entity.Track
import com.pomaskin.artists.domain.repository.ArtistRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetTracksFromArtistUseCase @Inject constructor(
    private val repository: ArtistRepository
) {

    operator fun invoke(artistName: String): Flow<List<Track>> {
        return repository.getTracksFromArtist(artistName)
    }
}