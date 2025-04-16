package com.app.minesweeper

import com.app.minesweeper.features.highscores.highscoresModule
import com.app.minesweeper.features.menu.menuModule
import com.app.minesweeper.features.play.playModule
import com.app.minesweeper.features.settings.settingsModule
import org.koin.dsl.module

val appModule = module {
    includes(
        highscoresModule,
        settingsModule,
        playModule,
        menuModule,
    )
}