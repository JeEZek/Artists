package com.pomaskin.artists.presentation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.pomaskin.artists.di.ApplicationComponent
import com.pomaskin.artists.di.DaggerApplicationComponent

class ArtistApplication: Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
    return (LocalContext.current.applicationContext as ArtistApplication).component
}