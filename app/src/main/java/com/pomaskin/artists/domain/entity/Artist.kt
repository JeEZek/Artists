package com.pomaskin.artists.domain.entity

import androidx.compose.runtime.Immutable

@Immutable
data class Artist (
    val name: String,
    val imageUrl: String,
    val summary: String,
    val content: String
)