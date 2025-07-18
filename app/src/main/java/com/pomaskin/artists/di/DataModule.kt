package com.pomaskin.artists.di

import com.pomaskin.artists.data.network.ApiFactory
import com.pomaskin.artists.data.network.ApiService
import com.pomaskin.artists.data.repository.ArtistRepositoryImpl
import com.pomaskin.artists.domain.repository.ArtistRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: ArtistRepositoryImpl): ArtistRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}