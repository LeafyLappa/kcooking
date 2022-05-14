package ui.main_menu

import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val MainMenuModule = module {
    singleOf(::MainMenuViewModel)
    factoryOf(::MainMenuScreen)
}