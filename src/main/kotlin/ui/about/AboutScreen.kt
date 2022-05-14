package ui.about

import com.varabyte.kotter.foundation.input.Key
import com.varabyte.kotter.foundation.text.*
import com.varabyte.kotter.runtime.MainRenderScope
import kotter.Screen

class AboutScreen : Screen() {
    override fun draw(scope: MainRenderScope) {
        with(scope) {
            textLine("Автор: я")
            textLine("Нажмите любую кнопку")
        }
    }

    override fun onKeyPressed(key: Key) {
        navigator.navigateUp()
    }
}