package com.pomaskin.artists.data.repository

import com.pomaskin.artists.BuildConfig
import com.pomaskin.artists.data.mapper.TracksArtistMapper
import com.pomaskin.artists.data.network.ApiService
import com.pomaskin.artists.domain.entity.Artist
import com.pomaskin.artists.domain.entity.Track
import com.pomaskin.artists.domain.repository.ArtistRepository
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry

class ArtistRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: TracksArtistMapper
): ArtistRepository {

    private val token = BuildConfig.apiKey


    override fun getArtistInfo(artistName: String): Flow<Artist> = flow {
        val response = apiService.loadArtistInfo(
            token = token,
            artist = artistName
        )
        emit(mapper.mapResponseToArtistInfo(response))
    }.retry (
        retries = 3,
        predicate = {
            delay(RETRY_TIMEOUT_MILLIS)
            true
        }
    )

    override fun getTracksFromArtist(artistName: String): Flow<List<Track>> = flow {
        val response = apiService.loadTopTracksFromArtist(
            token = token,
            artist = artistName
        )
        emit(mapper.mapResponseToTracks(response))
    }.retry (
        retries = 3,
        predicate = {
            delay(RETRY_TIMEOUT_MILLIS)
            true
        }
    )

    companion object {

        private const val RETRY_TIMEOUT_MILLIS = 500L
    }
}