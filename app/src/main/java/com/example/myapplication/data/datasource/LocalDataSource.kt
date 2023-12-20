package com.example.myapplication.data.datasource

import com.example.myapplication.domain.model.Theme
import kotlinx.coroutines.flow.SharedFlow

internal interface LocalDataSource {
    suspend fun getThemeUpdate(): SharedFlow<Theme>
    suspend fun publishThemeUpdate(theme: Theme)
    suspend fun getThemePreferences(): String
    suspend fun saveThemePreferences(theme: String)
}
