package com.pomaskin.artists.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pomaskin.artists.presentation.biography.BiographyScreen
import com.pomaskin.artists.presentation.tracks.TracksScreen
import com.pomaskin.artists.ui.theme.ArtistsTheme

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtistsTheme {
//                TracksScreen(
//                    {}, {}
//                )
                BiographyScreen(
                    {},
                    {}
                )
//                MainScreen(
//                    onButtonTracksClick = {},
//                    onButtonBiographyClick = {}
//                )
            }
        }
    }
}