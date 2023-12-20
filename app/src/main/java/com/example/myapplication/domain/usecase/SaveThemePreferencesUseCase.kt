package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class SaveThemePreferencesUseCase @Inject constructor(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke(theme: String) = repository.saveThemePreferences(theme)
}