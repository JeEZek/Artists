package com.pomaskin.artists.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pomaskin.artists.navigation.AppNavGraph
import com.pomaskin.artists.navigation.Screen.Companion.ROUTE_BIOGRAPHY
import com.pomaskin.artists.navigation.Screen.Companion.ROUTE_MAIN
import com.pomaskin.artists.navigation.Screen.Companion.ROUTE_TRACKS
import com.pomaskin.artists.navigation.rememberNavigationState
import com.pomaskin.artists.presentation.biography.BiographyScreen
import com.pomaskin.artists.presentation.tracks.TracksScreen
import com.pomaskin.artists.ui.theme.ArtistsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = viewModel()
            val navigationState = rememberNavigationState()

            AppNavGraph(
                navHostController = navigationState.navHostController,
                mainScreenContent = {
                    MainScreen(
                        onButtonBiographyClick = { navigationState.navigateTO(ROUTE_BIOGRAPHY) },
                        onButtonTracksClick = { navigationState.navigateTO(ROUTE_TRACKS) },
                    )
                },
                biographyScreenContent = {
                    BiographyScreen(
                        onButtonBackClick = { navigationState.navigateTO(ROUTE_MAIN) },
                        onButtonFindClick = {}
                        )
                },
                tracksScreenContent = {
                    TracksScreen(
                        onButtonBackClick = { navigationState.navigateTO(ROUTE_MAIN) },
                        onButtonFindClick = {}
                    )
                }
            )
        }
    }
}
