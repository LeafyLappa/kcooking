package ui.main_loading

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val MainLoadingModule = module {
    factoryOf(::MainLoadingScreen)
}