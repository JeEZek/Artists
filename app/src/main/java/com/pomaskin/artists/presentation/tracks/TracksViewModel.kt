package com.pomaskin.artists.presentation.tracks

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pomaskin.artists.domain.usecase.GetTracksFromArtistUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class TracksViewModel(
    private val getTracksFromArtistUseCase: GetTracksFromArtistUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<TracksScreenState>(TracksScreenState.Initial)
    val state: StateFlow<TracksScreenState> = _state

    fun onLoadButtonClick(artistName: String) {
        viewModelScope.launch {
            _state.value = TracksScreenState.Loading
            try {
                val tracks = getTracksFromArtistUseCase(artistName).first()
                _state.value = TracksScreenState.Content(tracks)
                Log.d("TracksViewModel", "Данные успешно загружены ${tracks[0].name} ${tracks[1].name} ${tracks[2].name}")
            } catch (e: Exception) {
                Log.d("TracksViewModel", "Ошибка при загрузке данных ${e}")
                _state.value = TracksScreenState.Initial
            }
        }
    }
}