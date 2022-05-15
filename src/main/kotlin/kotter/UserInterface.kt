package kotter

import com.varabyte.kotter.foundation.input.onKeyPressed
import com.varabyte.kotter.foundation.runUntilSignal
import com.varabyte.kotter.foundation.session
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class UserInterface {

    companion object {
        private const val FPS = 60
        private const val MILLIS_IN_TICK = 1000 / FPS
    }

    val navigator = object : Navigator() {
        override fun navigate(screen: Screen) {
            currentScreen = screen
            screen.onNavigate()
        }

        override fun leave() {
            renderJob.cancel()
        }
    }

    private lateinit var currentScreen: Screen

    private val renderJob = Job()

    inline fun <reified T : Screen> run() {
        navigator.navigateTo<T>()
        render()
    }

    fun render() {
        session {
            section {
                currentScreen.draw(this)
            }.runUntilSignal {
                onKeyPressed {
                    currentScreen.onKeyPressed(key)
                }
                CoroutineScope(renderJob).launch {
                    tickWhile(::isActive) {
                        rerender()
                    }
                    signal()
                }
            }
        }
    }

    private inline fun tickWhile(condition: () -> Boolean, onTick: () -> Unit) {
        var time = System.currentTimeMillis()
        while(condition()) {
            val newTime = System.currentTimeMillis()
            val delta = newTime - time
            if (delta > MILLIS_IN_TICK) {
                time = newTime
                onTick()
            }
        }
    }
}