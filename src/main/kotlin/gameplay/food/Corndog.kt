package gameplay.food

import gameplay.Ingredient
import gameplay.Recipe.Companion.recipe

class Corndog : Food {
    companion object {
        val mustard = Ingredient("Mustard", 'm')
        val ketchup = Ingredient("Ketchup", 'k')
    }

    override val name = "Corn dog"

    override val grade = 1

    override val ingredients = arrayOf(
        mustard, ketchup
    )

    override val recipes = arrayOf(
        recipe(
            1,
            "The Yellow Dog",
            "Mustard",
            arrayOf(mustard)
        ),
        recipe(
            1,
            "The Gerstmann",
            "Ketchup",
            arrayOf(ketchup)
        ),
        recipe(
            1,
            "The Classic Corn Dog",
            "Mustard and Ketchup",
            arrayOf(mustard, ketchup)
        )
    )
}