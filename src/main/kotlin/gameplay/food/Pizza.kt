package gameplay.food

import gameplay.Ingredient
import gameplay.Recipe.Companion.recipe

class Pizza : Food {
    companion object {
        val cheese = Ingredient("Cheese", 'c')
        val pepperoni = Ingredient("Pepperoni", 'p')
        val sausage = Ingredient("Sausage", 's')
        val bacon = Ingredient("Bacon", 'b')
        val mushrooms = Ingredient("Mushrooms", 'u')
        val olives = Ingredient("Olives", 'o')
        val onions = Ingredient("Onions", 'n')
        val anchovies = Ingredient("Anchovies", 'a')
    }

    override val name = "Pizza"

    override val grade = 3

    override val ingredients = arrayOf(
        cheese, pepperoni, sausage, bacon, mushrooms, olives, onions, anchovies
    )

    override val recipes = arrayOf(
        recipe(
            1,
            "Pepperoni Pizza",
            "Cheese and Pepperoni",
            arrayOf(cheese, pepperoni)
        ),
        recipe(
            1,
            "Cheese Pizza",
            "Cheese only",
            arrayOf(cheese)
        ),
        recipe(
            1,
            "Meat Pizza",
            "Cheese and Sausage",
            arrayOf(cheese, sausage)
        ),
        recipe(
            1,
            "P&M Pizza",
            "Cheese, Pepperoni and Sausage",
            arrayOf(cheese, pepperoni, sausage)
        ),
        recipe(
            1,
            "Cheesy Bread",
            "Cheese only",
            arrayOf(cheese)
        ),
        recipe(
            1,
            "Meatlovers Pizza",
            "Cheese, Pepperoni, Sausage and Bacon",
            arrayOf(cheese, pepperoni, sausage, bacon)
        ),
        recipe(
            1,
            "Veggie Pizza",
            "Cheese, Mushrooms, Olives and Onions",
            arrayOf(cheese, mushrooms, olives, onions)
        ),
        recipe(
            1,
            "Deluxe Pizza",
            "Cheese, Pepperoni, Sausage, Bacon, Mushrooms, Olives and Onions",
            arrayOf(cheese, pepperoni, sausage, bacon, mushrooms, olives, onions)
        ),
        recipe(
            1,
            "Italian Pizza",
            "Cheese, Sausage, Mushrooms, Olives and Onions",
            arrayOf(cheese, sausage, mushrooms, olives, onions)
        ),
        recipe(
            1,
            "Bacon and Mushroom Pizza",
            "Cheese, Bacon and Mushrooms",
            arrayOf(cheese, bacon, mushrooms)
        ),
        recipe(
            1,
            "Olives and Onions Pizza",
            "Cheese, Olives and Onions",
            arrayOf(cheese, olives, onions)
        ),
        recipe(
            1,
            "The PCGB Pizza",
            "Cheese, Pepperoni, Bacon and Onions",
            arrayOf(cheese, pepperoni, bacon, onions)
        ),
        recipe(
            2,
            "Anchovy Pizza",
            "Cheese and Anchovies",
            arrayOf(cheese, anchovies)
        ),
        recipe(
            2,
            "Deluxe Anchovy Pizza",
            "Cheese, Anchovies, Mushrooms, Olives, Onions",
            arrayOf(cheese, anchovies, mushrooms, olives, onions)
        ),
        recipe(
            2,
            "Meaty Anchovy Pizza",
            "Cheese, Pepperoni, Sausage, Bacon and Anchovies",
            arrayOf(cheese, pepperoni, sausage, bacon, anchovies)
        ),
        recipe(
            2,
            "Dairy-Lite Pizza",
            "Anchovies and Mushrooms",
            arrayOf(anchovies, mushrooms)
        )
    )
}