package com.pomaskin.artists.data.repository

import com.pomaskin.artists.data.mapper.TracksArtistMapper
import com.pomaskin.artists.data.network.ApiFactory
import com.pomaskin.artists.domain.entity.Artist
import com.pomaskin.artists.domain.entity.Track
import com.pomaskin.artists.domain.repository.ArtistRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry

//TODO replace
private val token = ""
private val mapper = TracksArtistMapper()

class ArtistRepositoryImpl(): ArtistRepository {
    override fun getArtistInfo(artistName: String): Flow<Artist> = flow {
        val response = ApiFactory.apiService.loadArtistInfo(
            token = token,
            artist = artistName
        )
        emit(mapper.mapResponseToArtistInfo(response))
    }.retry {
        delay(RETRY_TIMEOUT_MILLIS)
        true
    }

    override fun getTracksFromArtist(artistName: String): Flow<List<Track>> = flow {
        val response = ApiFactory.apiService.loadTopTracksFromArtist(
            token = token,
            artist = artistName
        )
        emit(mapper.mapResponseToTracks(response))
    }.retry {
        delay(RETRY_TIMEOUT_MILLIS)
        true
    }

    companion object {

        private const val RETRY_TIMEOUT_MILLIS = 3000L
    }
}