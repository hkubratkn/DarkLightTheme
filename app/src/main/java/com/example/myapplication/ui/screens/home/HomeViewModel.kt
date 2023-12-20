package com.example.myapplication.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Theme
import com.example.myapplication.domain.usecase.PublishThemeUpdateUseCase
import com.example.myapplication.domain.usecase.SaveThemePreferencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val saveThemePreferencesUseCase: SaveThemePreferencesUseCase,
    private val publishThemeUpdateUseCase: PublishThemeUpdateUseCase
) : ViewModel() {

    fun onThemeChanged(theme: Theme) {
        viewModelScope.launch {
            saveThemePreferencesUseCase(theme.name)
            publishThemeUpdateUseCase(theme)
        }
    }

}

