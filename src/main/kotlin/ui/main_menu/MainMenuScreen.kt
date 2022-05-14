package ui.main_menu

import com.varabyte.kotter.foundation.input.Key
import com.varabyte.kotter.foundation.input.Keys
import com.varabyte.kotter.runtime.MainRenderScope
import kotter.ui.Menu
import kotter.Screen
import ui.about.AboutScreen

class MainMenuScreen(
    private val viewModel: MainMenuViewModel
) : Screen() {

    private val menu = Menu(
        Menu.Item("Start cooking!") {
            viewModel.run()
        },
        Menu.Item("About KCooking") {
            navigator.navigateTo<AboutScreen>()
        },
        Menu.Item("Quit") {
            navigator.leave()
        },
    )

    override fun draw(scope: MainRenderScope) {
        menu.render(scope)
    }

    override fun onKeyPressed(key: Key) {
        when(key) {
            Keys.UP -> menu.selectPrevious()
            Keys.DOWN -> menu.selectNext()
            Keys.ENTER, Keys.SPACE -> menu.confirm()
        }
    }
}