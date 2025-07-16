package com.pomaskin.artists.navigation

sealed class Screen(
    val route: String
) {

    object Main: Screen(ROUTE_MAIN)
    object Biography: Screen(ROUTE_BIOGRAPHY)
    object Tracks: Screen(ROUTE_TRACKS)

    companion object {

        const val ROUTE_MAIN = "route_main"

        const val ROUTE_BIOGRAPHY = "route_biography"
        const val ROUTE_TRACKS = "route_tracks"
    }
}


