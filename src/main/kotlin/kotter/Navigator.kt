package kotter

import org.koin.core.component.KoinComponent
import org.koin.core.component.get

abstract class Navigator : KoinComponent {
    private val stack = mutableListOf<Screen>()

    inline fun <reified T : Screen> navigateTo() {
        val screen = get<T>()
        navigateTo(screen)
    }

    fun navigateTo(screen: Screen) {
        stack.add(0, screen)
        navigate(screen)
    }

    fun navigateUp() {
        if (stack.size < 2) leave() else {
            stack.removeFirst()
            navigate(stack.first())
        }
    }

    abstract fun leave()

    protected abstract fun navigate(screen: Screen)
}
