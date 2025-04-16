package com.app.minesweeper.features.play

import com.app.minesweeper.domain.game.domainGameModule
import org.koin.dsl.module

val playModule = module {
    includes(domainGameModule)
}