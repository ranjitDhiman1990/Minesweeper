package com.app.minesweeper

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.app.minesweeper.features.highscores.Highscores
import com.app.minesweeper.features.highscores.highscoresRoutes
import com.app.minesweeper.features.menu.Menu
import com.app.minesweeper.features.menu.menuRoutes
import comp.app.minesweeper.ui.core.LocalPadding
import comp.app.minesweeper.ui.core.Padding
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
            CompositionLocalProvider(
                LocalPadding provides Padding(
                    normal = 0.dp,
                )
            ) {
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
}