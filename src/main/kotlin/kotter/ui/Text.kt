package kotter.ui

import com.varabyte.kotter.foundation.text.*
import com.varabyte.kotter.runtime.render.RenderScope

open class Text(var text: String, var color: Color? = null) : Renderable {
    override fun render(scope: RenderScope) {
        color?.let {
            scope.scopedState {
                color(it)
                text(text)
            }
        } ?: scope.text(text)
    }
}