package com.app.minesweeper

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.app.minesweeper.features.highscores.Highscores
import com.app.minesweeper.features.highscores.highscoresRoutes
import com.app.minesweeper.features.menu.Menu
import com.app.minesweeper.features.menu.menuRoutes
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module


@Composable
@Preview
fun App(
    platformModule: Module = Module()
) {
    KoinApplication(
        application = {
            modules(appModule, platformModule)
        }
    ) {
        MaterialTheme {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Menu,
            ) {
                menuRoutes(
                    goToPlay = {},
                    goToHighscores = {
                        navController.navigate(Highscores)
                    },
                    goToSettings = {},
                )
                highscoresRoutes()
            }
        }
    }
}