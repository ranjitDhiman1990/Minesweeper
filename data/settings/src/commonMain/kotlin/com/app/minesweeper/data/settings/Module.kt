package com.app.minesweeper.data.settings

import com.app.minesweeper.data.core.dataCoreModule
import org.koin.dsl.module

val dataSettingsModule = module {
    includes(dataCoreModule)
}