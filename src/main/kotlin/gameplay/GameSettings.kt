package gameplay

class GameSettings {
    enum class Difficulty {
        EASY, MEDIUM, HARD
    }

    var difficulty = Difficulty.EASY
}