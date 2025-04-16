package com.app.minesweeper.features.highscores

import com.app.minesweeper.domain.game.domainGameModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val highscoresModule = module {

    includes(domainGameModule)

    viewModelOf(::HighscoresViewModel)
}