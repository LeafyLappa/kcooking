package ui.main_loading

import com.varabyte.kotter.foundation.text.text
import com.varabyte.kotter.runtime.MainRenderScope
import kotlinx.coroutines.*
import kotter.Screen
import ui.main_menu.MainMenuScreen

class MainLoadingScreen : Screen() {
    var text = "."

    override fun draw(scope: MainRenderScope) {
        with(scope) {
            text(text)
        }
    }

    override fun onRun() {
        val animJob = CoroutineScope(Job()).launch {
            while (isActive) {
                delay(500)
                text += "."
                if (text == "....") text = "."
                println(text)
            }
        }

        CoroutineScope(Job()).launch {
            delay(1600)
            animJob.cancel()
            navigator.navigateTo<MainMenuScreen>()
        }
    }
}
