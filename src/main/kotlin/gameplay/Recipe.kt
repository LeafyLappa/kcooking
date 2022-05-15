package gameplay

import gameplay.food.Food

class Recipe(
    val food: Food,
    val grade: Int,
    val title: String,
    val description: String,
    val ingredients: Array<Ingredient>,
) {
    companion object {
        fun Food.recipe(
            grade: Int,
            title: String,
            description: String,
            ingredients: Array<Ingredient>
        ) = Recipe(this, grade, title, description, ingredients)
    }
}