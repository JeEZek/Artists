package com.pomaskin.artists.data.network

import com.pomaskin.artists.data.model.biography.ArtistResponseDto
import com.pomaskin.artists.data.model.tracks.TopTracksDto
import com.pomaskin.artists.data.model.tracks.TopTracksResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("?method=artist.getTopTracks&format=json&limit=3")
    suspend fun loadTopTracksFromArtist(
        @Query("api_key") token: String,
        @Query("artist") artist: String
    ): TopTracksResponseDto

    @GET("?method=artist.getInfo&format=json&limit=1")
    suspend fun loadArtistInfo(
        @Query("api_key") token: String,
        @Query("artist") artist: String
    ): ArtistResponseDto
}