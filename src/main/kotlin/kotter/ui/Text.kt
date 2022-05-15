package kotter.ui

import com.varabyte.kotter.foundation.text.*
import com.varabyte.kotter.runtime.MainRenderScope

open class Text(var text: String, var color: Color? = null) : Renderable {
    override fun render(scope: MainRenderScope) {
        color?.let {
            scope.scopedState {
                color(it)
                text(text)
            }
        } ?: scope.text(text)
    }
}