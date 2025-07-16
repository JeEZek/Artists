package com.pomaskin.artists.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pomaskin.artists.ui.theme.ArtistsTheme

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtistsTheme {
                MainScreen(
                    onButtonTracksClick = {},
                    onButtonBiographyClick = {}
                )
            }
        }
    }
}