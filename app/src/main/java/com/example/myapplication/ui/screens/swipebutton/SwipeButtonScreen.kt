package com.example.myapplication.ui.screens.swipebutton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.ui.composable.SwipeButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeButtonScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.swipe_button)) },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) { paddingValue ->
        SwipeButton(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(paddingValue)
                .padding(24.dp),
            borderStroke = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
            backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
            icon = {
                Icon(
                    modifier = Modifier.size(56.dp),
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                )
            },
            text = "Swipe",
            textStyle = TextStyle(MaterialTheme.colorScheme.primaryContainer, 24.sp),
            onSwipe = { println("Swipe right") }
        )
    }
}