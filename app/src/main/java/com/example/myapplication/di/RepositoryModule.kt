package com.example.myapplication.di

import com.example.myapplication.data.repository.UserPreferencesRepositoryImpl
import com.example.myapplication.domain.repository.UserPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserPreferencesRepository(repository: UserPreferencesRepositoryImpl): UserPreferencesRepository =
        repository

}