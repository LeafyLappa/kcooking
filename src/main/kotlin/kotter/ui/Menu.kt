package kotter.ui

import com.varabyte.kotter.foundation.text.textLine
import com.varabyte.kotter.foundation.text.yellow
import com.varabyte.kotter.runtime.MainRenderScope
import com.varabyte.kotter.runtime.render.RenderScope
import com.varabyte.kotterx.decorations.bordered

open class Menu(
    private val items: Array<Item>,
    private val border: Border? = null,
) : Renderable {

    data class Item(var text: String, val submit: (Item) -> Unit)

    private var selectedItemIndex = -1

    override fun render(scope: MainRenderScope) {
        if (border != null) scope.bordered(
            border.borderCharacters,
            border.paddingLeftRight,
            border.paddingTopBottom,
        ) {
            drawItems()
        } else scope.drawItems()
    }

    fun selectNext() {
        selectedItemIndex = (selectedItemIndex + 1).coerceAtMost(items.size - 1)
    }

    fun selectPrevious() {
        selectedItemIndex = (selectedItemIndex - 1).coerceAtLeast(0)
    }

    fun selectAt(index: Int) {
        selectedItemIndex = index.coerceAtLeast(0).coerceAtMost(items.size - 1)
    }

    fun submit() {
        items[selectedItemIndex].let {
            it.submit(it)
        }
    }

    private fun RenderScope.drawItems() {
        items.forEachIndexed { index: Int, item: Item ->
            if (index != selectedItemIndex) textLine(item.text)
            else yellow { textLine(item.text) }
        }
    }
}