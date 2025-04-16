package com.app.minesweeper.data.game

import com.app.minesweeper.data.core.dataCoreModule
import org.koin.dsl.module

val dataGameModule = module {
    includes(dataCoreModule)
}