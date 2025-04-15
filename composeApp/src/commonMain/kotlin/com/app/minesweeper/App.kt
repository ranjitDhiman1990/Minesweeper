package com.app.minesweeper

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.app.minesweeper.features.menu.MenuScreen
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        MenuScreen(
            goToPlay = {},
            goToHighscores = {},
            goToSettings = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}