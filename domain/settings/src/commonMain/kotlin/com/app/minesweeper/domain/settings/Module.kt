package com.app.minesweeper.domain.settings

import com.app.minesweeper.data.settings.dataSettingsModule
import org.koin.dsl.module

val domainSettingsModule = module {
    includes(dataSettingsModule)
}