package gameplay.food

import gameplay.Ingredient
import gameplay.Recipe

interface Food {
    val name: String
    val grade: Int
    val ingredients: Array<Ingredient>
    val recipes: Array<Recipe>
}