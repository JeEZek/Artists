package com.pomaskin.artists.domain.entity

import androidx.compose.runtime.Immutable

@Immutable
data class Track(
    val name: String,
    val imageUrl: String
)
