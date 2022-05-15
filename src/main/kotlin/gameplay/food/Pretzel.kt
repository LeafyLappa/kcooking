package gameplay.food

import gameplay.Ingredient
import gameplay.Recipe.Companion.recipe

class Pretzel : Food {
    companion object {
        val salt = Ingredient("Salt", 's')
        val butter = Ingredient("Butter", 'b')
        val cinnamon = Ingredient("Cinnamon", 'c')
    }

    override val name = "Pretzel"

    override val grade = 1

    override val ingredients = arrayOf(
        salt, butter, cinnamon
    )

    override val recipes = arrayOf(
        recipe(
            1,
            "The Classic Pretzel",
            "Salt and butter",
            arrayOf(salt, butter)
        ),
        recipe(
            1,
            "The Dry Twister",
            "Just the pretzel",
            arrayOf()
        ),
        recipe(
            1,
            "Cinnamon Pretzel",
            "Cinnamon",
            arrayOf(cinnamon)
        ),
        recipe(
            1,
            "The Buttery Curves",
            "Butter",
            arrayOf(butter)
        ),
        recipe(
            1,
            "The Sweet Twist",
            "Butter and Cinammon",
            arrayOf(butter, cinnamon)
        ),
        recipe(
            1,
            "The Salty Knot",
            "Salt",
            arrayOf(salt)
        )
    )
}