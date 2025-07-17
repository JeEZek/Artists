package com.pomaskin.artists.data.mapper

import com.pomaskin.artists.data.model.biography.ArtistResponseDto
import com.pomaskin.artists.data.model.tracks.TopTracksResponseDto
import com.pomaskin.artists.domain.entity.Artist
import com.pomaskin.artists.domain.entity.Track

class TracksArtistMapper {

    fun mapResponseToTracks(responseDto: TopTracksResponseDto): List<Track> {
        val result = mutableListOf<Track>()

        val trackList = responseDto.topTracks.trackList
        for (track in trackList) {
            val trackResult = Track(
                name = track.name,
                imageUrl = track.imageList[0].imageUrl,
            )
            result.add(trackResult)
        }

        return result
    }

    fun mapResponseToArtistInfo(responseDto: ArtistResponseDto): Artist {
        return Artist(
            name = responseDto.artist.name,
            imageUrl = responseDto.artist.image[0].imageUrl,
            content = responseDto.artist.bio.content,
            summary = responseDto.artist.bio.summary
        )
    }
}