package ui.main_loading

import com.varabyte.kotter.foundation.text.textLine
import com.varabyte.kotter.runtime.MainRenderScope
import kotter.Screen
import ui.main_menu.MainMenuScreen

class MainLoadingScreen : Screen() {
    override fun draw(scope: MainRenderScope) {
        with(scope) {
            textLine("Loading...")
        }
    }

    override fun onNavigate() {
        navigator.navigateTo<MainMenuScreen>()
    }
}
