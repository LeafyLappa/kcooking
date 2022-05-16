package kotter.ui

import com.varabyte.kotter.foundation.text.textLine
import com.varabyte.kotter.runtime.render.RenderScope

interface Renderable {
    fun render(scope: RenderScope)

    companion object {
        fun RenderScope.render(renderable: Renderable) {
            renderable.render(this)
            textLine()
        }
    }
}