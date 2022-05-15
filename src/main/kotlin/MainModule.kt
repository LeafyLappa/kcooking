import gameplay.GameplayModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import kotter.UserInterface
import ui.about.AboutModule
import ui.game.GameScreenModule
import ui.main_loading.MainLoadingModule
import ui.main_menu.MainMenuModule

val MainModule = module {
    singleOf(::Application)
    singleOf(::UserInterface)
    factory {
        get<UserInterface>().navigator
    }

    includes(MainMenuModule)
    includes(MainLoadingModule)
    includes(AboutModule)
    includes(GameScreenModule)

    includes(GameplayModule)
}