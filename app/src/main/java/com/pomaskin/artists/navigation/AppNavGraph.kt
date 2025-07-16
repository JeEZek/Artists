package com.pomaskin.artists.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    mainScreenContent: @Composable () -> Unit,
    biographyScreenContent: @Composable () -> Unit,
    tracksScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Main.route
    ) {
        composable(route = Screen.Main.route) {
            mainScreenContent()
        }
        composable(route = Screen.Biography.route) {
            biographyScreenContent()
        }
        composable(route = Screen.Tracks.route) {
            tracksScreenContent()
        }
    }
}