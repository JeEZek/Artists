package com.pomaskin.artists.presentation.biography

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pomaskin.artists.domain.usecase.GetArtistInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class BiographyViewModel(
    private val getArtistInfoUseCase: GetArtistInfoUseCase
): ViewModel() {

    private val _state = MutableStateFlow<BiographyScreenState>(BiographyScreenState.Initial)
    val state: StateFlow<BiographyScreenState> = _state

    fun onLoadButtonClick(artistName: String) {
        viewModelScope.launch {
            _state.value = BiographyScreenState.Loading
            try {
                val artist = getArtistInfoUseCase(artistName).first()
                _state.value = BiographyScreenState.Content(artist)
                Log.d("BiographyViewModel","Данные успешно загружены ${artist.name}")
            } catch (e: Exception) {
                Log.d("BiographyViewModel","Ошибка при загрузке данных ${e}")
                _state.value = BiographyScreenState.Initial
            }
        }
    }
}