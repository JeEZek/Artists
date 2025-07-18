package com.pomaskin.artists.di

import androidx.lifecycle.ViewModel
import com.pomaskin.artists.presentation.biography.BiographyViewModel
import com.pomaskin.artists.presentation.tracks.TracksViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(BiographyViewModel::class)
    @Binds
    fun bindBiographyViewModel(viewModule: BiographyViewModel): ViewModel

    @IntoMap
    @ViewModelKey(TracksViewModel::class)
    @Binds
    fun bindTracksViewModel(viewModule: TracksViewModel): ViewModel
}