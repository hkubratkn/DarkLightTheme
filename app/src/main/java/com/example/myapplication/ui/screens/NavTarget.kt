package com.example.myapplication.ui.screens

sealed class NavTarget(val route: String) {
    object Home : NavTarget("home")
    object SwipeButton : NavTarget("swipe_button")
}