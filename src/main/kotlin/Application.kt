import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotter.UserInterface
import ui.main_loading.MainLoadingScreen

class Application : KoinComponent {
    private val userInterface: UserInterface by inject()

    fun run(args: Array<String>) {
        userInterface.run<MainLoadingScreen>()
    }
}