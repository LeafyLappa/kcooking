package ui.score

import com.varabyte.kotter.foundation.input.Key
import com.varabyte.kotter.foundation.text.green
import com.varabyte.kotter.foundation.text.text
import com.varabyte.kotter.foundation.text.textLine
import com.varabyte.kotter.foundation.text.yellow
import com.varabyte.kotter.runtime.MainRenderScope
import kotter.Screen
import ui.game.GameViewModel

class ScoreScreen(
    private val viewModel: GameViewModel,
) : Screen() {

    override fun draw(scope: MainRenderScope) {
        with(scope) {
            yellow {
                text("SCORE: ")
            }
            green {
                text(viewModel.toString())
            }
            textLine()
        }
    }

    override fun onKeyPressed(key: Key) {
        super.onKeyPressed(key)
    }
}