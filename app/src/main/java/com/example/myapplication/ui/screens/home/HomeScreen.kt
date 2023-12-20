package com.example.myapplication.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.domain.model.Theme
import com.example.myapplication.ui.screens.NavTarget.SwipeButton
import com.example.myapplication.ui.theme.Shapes

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeContent(
        onSelectTheme = { viewModel.onThemeChanged(it) },
        onClickSwipeButton = { navHostController.navigate(SwipeButton.route) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    onSelectTheme: (Theme) -> Unit,
    onClickSwipeButton: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null
                        )
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.padding(8.dp))
                                    Text(stringResource(R.string.light_mode))
                                }
                            },
                            onClick = {
                                onSelectTheme(Theme.Light)
                                showMenu = false
                            }
                        )

                        DropdownMenuItem(
                            text = {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Delete,
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.padding(8.dp))
                                    Text(stringResource(R.string.dark_mode))
                                }
                            },
                            onClick = {
                                onSelectTheme(Theme.Dark)
                                showMenu = false
                            }
                        )
                    }
                }
            )
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier.padding(paddingValue)
        ) {
            ButtonCard(
                stringResource = R.string.swipe_button,
                onClickButton = { onClickSwipeButton() }
            )
        }
    }
}

@Composable
fun ButtonCard(
    stringResource: Int,
    onClickButton: () -> Unit
) {
    Button(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .fillMaxWidth(),
        shape = Shapes.large,
        onClick = onClickButton
    ) {
        Text(stringResource(stringResource))
    }
}