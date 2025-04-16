package com.app.minesweeper.features.settings

import com.app.minesweeper.domain.settings.domainSettingsModule
import org.koin.dsl.module

val settingsModule = module {
    includes(domainSettingsModule)
}