package com.example.myapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.domain.model.Theme
import com.example.myapplication.ui.screens.NavTarget.Home
import com.example.myapplication.ui.screens.NavTarget.SwipeButton
import com.example.myapplication.ui.screens.home.HomeScreen
import com.example.myapplication.ui.screens.swipebutton.SwipeButtonScreen
import com.example.myapplication.ui.theme.ComposeFunctionsTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val theme by viewModel.theme

            val isDarkTheme = when (theme) {
                Theme.Dark -> true
                Theme.Light -> false
            }

            ComposeFunctionsTheme(isDarkTheme) {
                NavHost(navController, startDestination = Home.route) {
                    composable(Home.route) { HomeScreen(navController) }
                    composable(SwipeButton.route) { SwipeButtonScreen(navController) }
                }
            }
        }
    }
}