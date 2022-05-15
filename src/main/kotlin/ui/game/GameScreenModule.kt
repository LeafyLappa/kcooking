package ui.game

import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val GameScreenModule = module {
    factoryOf(::GameViewModel)
    factoryOf(::GameScreen)
}