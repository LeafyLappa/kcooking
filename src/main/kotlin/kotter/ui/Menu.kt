package kotter.ui

import com.varabyte.kotter.foundation.text.textLine
import com.varabyte.kotter.foundation.text.yellow
import com.varabyte.kotter.runtime.MainRenderScope
import com.varabyte.kotterx.decorations.BorderCharacters
import com.varabyte.kotterx.decorations.bordered

class Menu(private vararg val items: Item) {
    data class Item(val text: String, val onConfirm: () -> Unit)

    private var selectedItemIndex = 0

    fun render(scope: MainRenderScope) {
        scope.bordered(BorderCharacters.ASCII, 3, 3) {
            items.forEachIndexed { index: Int, item: Item ->
                if (index != selectedItemIndex) textLine(item.text)
                else yellow { textLine(item.text) }
            }
        }
    }

    fun selectNext() {
        selectedItemIndex = (selectedItemIndex + 1).coerceAtMost(items.size - 1)
    }

    fun selectPrevious() {
        selectedItemIndex = (selectedItemIndex - 1).coerceAtLeast(0)
    }

    fun confirm() {
        items[selectedItemIndex].onConfirm()
    }
}