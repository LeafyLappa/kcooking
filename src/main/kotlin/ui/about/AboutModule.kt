package ui.about

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val AboutModule = module {
    factoryOf(::AboutScreen)
}