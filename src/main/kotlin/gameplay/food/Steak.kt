package gameplay.food

import gameplay.Ingredient
import gameplay.Recipe.Companion.recipe

class Steak : Food {
    companion object {
        val seasoning = Ingredient("Seasoning", 's')
        val juice = Ingredient("Juice", 'j')
        val citrus = Ingredient("Citrus", 'c')
        val spicy = Ingredient("Spicy", 'p')
    }

    override val name = "Steak"

    override val grade = 2

    override val ingredients = arrayOf(
        seasoning, juice, citrus, spicy
    )

    override val recipes = arrayOf(
        recipe(
            1,
            "Classic Steak",
            "Seasoning x3, Juice",
            arrayOf(seasoning, seasoning, seasoning, juice)
        ),
        recipe(
            1,
            "Citrus Steak",
            "Seasoning, Juice x2, Citrus",
            arrayOf(seasoning, juice, juice, citrus)
        ),
        recipe(
            2,
            "Spicy Steak",
            "Seasoning, Spicy x4, Juice x2.",
            arrayOf(seasoning, spicy, spicy, spicy, spicy, juice, juice)
        ),
        recipe(
            2,
            "The Dry Spicy Steak",
            "Seasoning, Spicy x2",
            arrayOf(seasoning, spicy, spicy)
        ),
    )
}