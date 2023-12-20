package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.Theme
import com.example.myapplication.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class PublishThemeUpdateUseCase @Inject constructor(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke(theme: Theme) = repository.publishThemeUpdate(theme)
}