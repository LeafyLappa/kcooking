package kotter.ui

import com.varabyte.kotter.foundation.text.textLine
import com.varabyte.kotter.runtime.MainRenderScope

interface Renderable {
    fun render(scope: MainRenderScope)

    companion object {
        fun MainRenderScope.render(renderable: Renderable) {
            renderable.render(this)
            textLine()
        }
    }
}