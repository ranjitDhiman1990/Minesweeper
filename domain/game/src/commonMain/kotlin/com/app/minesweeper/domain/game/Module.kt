package com.app.minesweeper.domain.game

import com.app.minesweeper.data.game.dataGameModule
import com.app.minesweeper.data.settings.dataSettingsModule
import org.koin.dsl.module

val domainGameModule = module {
    includes(dataSettingsModule, dataGameModule)
}