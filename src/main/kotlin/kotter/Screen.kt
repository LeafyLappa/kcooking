package kotter

import com.varabyte.kotter.foundation.input.Key
import com.varabyte.kotter.runtime.MainRenderScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class Screen : KoinComponent {
    abstract fun draw(scope: MainRenderScope)
    open fun onKeyPressed(key: Key) = Unit
    open fun onNavigate() = Unit

    protected val navigator: Navigator by inject()
}