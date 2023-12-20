package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.Theme
import com.example.myapplication.domain.repository.UserPreferencesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetThemeUpdateUseCase @Inject constructor(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke(): Flow<Theme> = repository.getThemeUpdate()
}