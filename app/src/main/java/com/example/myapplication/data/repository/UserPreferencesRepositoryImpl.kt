package com.example.myapplication.data.repository

import com.example.myapplication.data.datasource.LocalDataSource
import com.example.myapplication.domain.model.Theme
import com.example.myapplication.domain.repository.UserPreferencesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.SharedFlow

internal class UserPreferencesRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : UserPreferencesRepository {
    override suspend fun getThemeUpdate(): SharedFlow<Theme> = localDataSource.getThemeUpdate()

    override suspend fun publishThemeUpdate(theme: Theme) =
        localDataSource.publishThemeUpdate(theme)

    override suspend fun getThemePreferences(): String = localDataSource.getThemePreferences()

    override suspend fun saveThemePreferences(theme: String) =
        localDataSource.saveThemePreferences(theme)

}