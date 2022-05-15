package ui.game

import kotter.ui.Text

class Clock(text: String) : Text(text) {
    private var hours = 8
    private var minutes = 59
    private var ampm = "AM"

    fun tick() {
        minutes++
        if (minutes == 60) {
            hours++
            minutes = 0
        }
        if (hours > 11) ampm = "PM"
        if (hours > 12) hours = 1
        val minutesText = if (minutes < 10) "0$minutes" else "$minutes"
        text = "$hours:$minutesText $ampm"
    }
}