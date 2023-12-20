package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Theme
import kotlinx.coroutines.flow.SharedFlow

interface UserPreferencesRepository {
    suspend fun getThemeUpdate(): SharedFlow<Theme>
    suspend fun publishThemeUpdate(theme: Theme)
    suspend fun getThemePreferences(): String
    suspend fun saveThemePreferences(value: String)
}