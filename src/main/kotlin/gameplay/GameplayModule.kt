package gameplay

import gameplay.food.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val GameplayModule = module {
    singleOf(::Burger)
    singleOf(::Corndog)
    singleOf(::Pizza)
    singleOf(::Pretzel)
    singleOf(::Steak)
    singleOf(::GameSettings)
}
