package ui.about

import com.varabyte.kotter.foundation.input.Key
import com.varabyte.kotter.foundation.text.*
import com.varabyte.kotter.runtime.MainRenderScope
import com.varabyte.kotterx.decorations.bordered
import kotter.Screen

class AboutScreen : Screen() {
    override fun draw(scope: MainRenderScope) {
        with(scope) {
            bordered {
                textLine("Author: LeafyLappa")
                textLine("https://github.com/LeafyLappa")
            }
            textLine()
            textLine("Press any button...")
        }
    }

    override fun onKeyPressed(key: Key) {
        navigator.navigateUp()
    }
}