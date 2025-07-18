package com.pomaskin.artists.di

import com.pomaskin.artists.presentation.ViewModelFactory
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory
}