package com.pomaskin.artists.domain.usecase

import com.pomaskin.artists.domain.entity.Artist
import com.pomaskin.artists.domain.repository.ArtistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArtistInfoUseCase @Inject constructor(
    private val repository: ArtistRepository
) {

    operator fun invoke(artistName: String): Flow<Artist> {
        return repository.getArtistInfo(artistName)
    }
}