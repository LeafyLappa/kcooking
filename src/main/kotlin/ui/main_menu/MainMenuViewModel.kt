package ui.main_menu

import gameplay.GameSettings
import ui.ViewModel

class MainMenuViewModel(private val gameSettings: GameSettings) : ViewModel {
    val difficulty get() = gameSettings.difficulty

    fun updateDifficulty() {
        val size = GameSettings.Difficulty.values().size
        val currentDifficulty = gameSettings.difficulty.ordinal
        gameSettings.difficulty = if (currentDifficulty >=  size - 1) {
            GameSettings.Difficulty.EASY
        } else {
            GameSettings.Difficulty.values()[currentDifficulty + 1]
        }
    }
}