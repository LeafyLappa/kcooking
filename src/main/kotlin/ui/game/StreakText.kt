package ui.game

import com.varabyte.kotter.foundation.text.Color
import kotlinx.coroutines.delay
import kotter.ui.Text

class StreakText(text: String) : Text(text) {

    private class Stage(
        val streakRequirement: Int,
        val bangs: String,
        val colors: Array<Color> = arrayOf(),
        val colorChangeDelayMs: Long = 0,
        val textReplacement: String? = null,
    )

    private val goldenColors = arrayOf(
        Color.YELLOW,
        Color.BRIGHT_YELLOW
    )

    private val flamingColors = arrayOf(
        Color.YELLOW,
        Color.BRIGHT_YELLOW,
        Color.BRIGHT_RED,
        Color.RED,
    )

    private val mysticColors = arrayOf(
        Color.BLUE,
        Color.MAGENTA,
    )

    private val rainbowColors = Color.values()

    private val streakStages = arrayOf(
        Stage(0, "", arrayOf()),
        Stage(4, "", arrayOf(Color.BRIGHT_YELLOW)),
        Stage(8, "", goldenColors, 200L),
        Stage(12, "!", goldenColors, 165L),
        Stage(16, "!", flamingColors, 130L),
        Stage(20, "!!", flamingColors, 95L),
        Stage(24, "!!", mysticColors, 95L),
        Stage(28, "!!!", mysticColors, 95L),
        Stage(32, "!!!", rainbowColors, 80L),
        Stage(36, "!!!", rainbowColors, 50L),
        Stage(40, "", rainbowColors, 50L, "ENORMOUS"),
        Stage(46, "", rainbowColors, 50L, "LEGENDARY"),
        Stage(52, "", rainbowColors, 50L, "INCALCULABLE"),
        Stage(58, "", rainbowColors, 50L, "UNFATHOMABLE"),
        Stage(64, "", rainbowColors, 50L, "TRANSCENDENTAL"),
        Stage(70, "", rainbowColors, 50L, "INFINITE"),
    )

    private var stage = streakStages.first()

    fun updateStage(streak: Int) {
        stage = streakStages.last { streak >= it.streakRequirement }
        text = stage.textReplacement ?: "$streak${stage.bangs}"
    }

    suspend fun blink() {
        if (stage.colors.isEmpty()) {
            color = null
            delay(300L)
        }
        else if (stage.colors.size == 1) {
            color = stage.colors.single()
            delay(300L)
        }
        else stage.colors.forEach {
            color = it
            delay(stage.colorChangeDelayMs)
        }
    }
}