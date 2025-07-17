package com.pomaskin.artists.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pomaskin.artists.data.mapper.TracksArtistMapper
import com.pomaskin.artists.data.network.ApiFactory
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    init {
        loadTracks()
        loadArtistInfo()
    }

    //TODO put your token
    private val token = ""

    private val mapper = TracksArtistMapper()

    private fun loadTracks() {
        viewModelScope.launch {
            val response = ApiFactory.apiService.loadTopTracksFromArtist(
                token,
                "BTS"
            )
            val tracks = mapper.mapResponseToTracks(response)
            Log.d("MainViewModel", "${tracks[0].name} ${tracks[0].imageUrl}")
        }
    }

    private fun loadArtistInfo() {
        viewModelScope.launch {
            val response = ApiFactory.apiService.loadArtistInfo(
                token,
                "BTS"
            )
            val artist = mapper.mapResponseToArtistInfo(response)
            Log.d("MainViewModel", "${artist.name} ${artist.imageUrl} ${artist.summary} ${artist.content} ")
        }
    }
}