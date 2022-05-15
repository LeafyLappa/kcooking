package ui.game

data class Burger(val recipe: Recipe) : Food {
    enum class Recipe(
        val title: String,
        val description: String,
        val ingredients: List<Char>
    ) {
        THE_ORIGINAL(
            "The Original",
            "Meat, Lettuce, Bacon, Cheese and Tomatoes",
            listOf('m', 'l', 'b', 'c', 't')
        ),
        BLT(
            "BLT",
            "Bacon, Lettuce and Tomatoes",
            listOf('b', 'l', 't')
        ),
        THE_HEARTSTOPPER(
            "The HEARTSTOPPER!",
            "Meat (2x). Bacon (2x), Cheese",
            listOf('m', 'm', 'b', 'b', 'c')
        )
    }

    override val name = "Burger"
}
