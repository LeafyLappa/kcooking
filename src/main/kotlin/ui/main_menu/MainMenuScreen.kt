package ui.main_menu

import com.varabyte.kotter.foundation.input.Key
import com.varabyte.kotter.foundation.input.Keys
import com.varabyte.kotter.runtime.MainRenderScope
import com.varabyte.kotterx.decorations.BorderCharacters
import kotter.ui.Menu
import kotter.Screen
import kotter.ui.Border
import kotter.ui.Renderable.Companion.render
import ui.about.AboutScreen
import ui.game.GameScreen

class MainMenuScreen(
    private val viewModel: MainMenuViewModel
) : Screen() {

    private val menu = Menu(
        arrayOf(
            Menu.Item("Start cooking!") {
                navigator.navigateTo<GameScreen>()
            },
            Menu.Item("About KCooking") {
                navigator.navigateTo<AboutScreen>()
            },
            Menu.Item("Quit") {
                navigator.leave()
            }
        ),
        Border(
            BorderCharacters.ASCII,
            3,
            3
        ),
    ).apply {
        selectAt(0)
    }

    override fun draw(scope: MainRenderScope) {
        scope.render(menu)
    }

    override fun onKeyPressed(key: Key) {
        when(key) {
            Keys.UP -> menu.selectPrevious()
            Keys.DOWN -> menu.selectNext()
            Keys.ENTER, Keys.SPACE -> menu.submit()
        }
    }
}