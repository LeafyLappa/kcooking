package gameplay.food

import gameplay.Ingredient
import gameplay.Recipe.Companion.recipe

class Burger : Food {
    companion object {
        val meat = Ingredient("Meat", 'm')
        val lettuce = Ingredient("Lettuce", 'l')
        val bacon = Ingredient("Bacon", 'b')
        val cheese = Ingredient("Cheese", 'c')
        val tomatoes = Ingredient("Tomatoes", 't')
        val pickles = Ingredient("Pickles", 'p')
    }
    override val name = "Burger"

    override val grade = 3

    override val ingredients = arrayOf(
        meat, lettuce, bacon, cheese, tomatoes, pickles
    )

    override val recipes = arrayOf(
        recipe(
            1,
            "The Original",
            "Meat, Lettuce, Bacon, Cheese and Tomatoes",
            arrayOf(meat, lettuce, bacon, cheese, tomatoes)
        ),
        recipe(
            1,
            "The Double",
            "Meat (2x), Lettuce, Bacon, Cheese and Tomatoes",
            arrayOf(meat, meat, lettuce, bacon, cheese, tomatoes)
        ),
        recipe(
            1,
            "BLT",
            "Bacon, Lettuce and Tomatoes",
            arrayOf(bacon, lettuce, tomatoes)
        ),
        recipe(
            1,
            "BLT and C",
            "Lettuce, Tomatoes and Cheese",
            arrayOf(lettuce, tomatoes, cheese)
        ),
        recipe(
            1,
            "The HEARTSTOPPER!",
            "Meat (2x). Bacon (2x), Cheese",
            arrayOf(meat, meat, bacon, bacon, cheese)
        ),
        recipe(
            1,
            "The Lite Delight",
            "Meat and Lettuce",
            arrayOf(meat, lettuce)
        ),
        recipe(
            1,
            "The Ryan Davis",
            "Meat, Bacon, Cheese (2x) and Tomatoes",
            arrayOf(meat, bacon, cheese, cheese, tomatoes)
        ),
        recipe(
            1,
            "The Tumbleweed",
            "Bacon and Cheese",
            arrayOf(bacon, cheese)
        ),
        recipe(
            1,
            "The Lonely Patty",
            "A single patty",
            arrayOf(meat)
        ),
        recipe(
            1,
            "The Triple",
            "Meat (3x) and Cheese",
            arrayOf(meat, meat, meat, cheese)
        ),
        recipe(
            1,
            "The Triple w/Bacon",
            "Meat (3x), Bacon and Cheese",
            arrayOf(meat, meat, meat, bacon, cheese)
        ),
        recipe(
            1,
            "The RED",
            "Meat and Tomatoes",
            arrayOf(meat, tomatoes)
        ),
        recipe(
            2,
            "The Veggie",
            "Lettuce, Tomatoes and Pickles",
            arrayOf(lettuce, tomatoes, pickles)
        ),
        recipe(
            2,
            "The Pickler",
            "Meat, Cheese and Pickles",
            arrayOf(meat, cheese, pickles)
        ),
        recipe(
            2,
            "The Trio",
            "Meat, Tomatoes and Pickles",
            arrayOf(meat, tomatoes, pickles)
        ),
        recipe(
            2,
            "The P-D",
            "Meat (2x), Bacon and Pickles",
            arrayOf(meat, meat, bacon, pickles)
        ),
        recipe(
            2,
            "The Stacked",
            "Meat, Lettuce, Bacon, Cheese, Tomatoes and Pickles",
            arrayOf(meat, lettuce, bacon, cheese, tomatoes, pickles)
        ),
        recipe(
            2,
            "The Greens",
            "Meat, Lettuce and Pickles",
            arrayOf(meat, lettuce, pickles)
        )
    )
}
