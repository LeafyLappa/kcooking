package ui.game

import com.varabyte.kotter.foundation.input.CharKey
import com.varabyte.kotter.foundation.input.Key
import com.varabyte.kotter.foundation.input.Keys
import com.varabyte.kotter.foundation.text.*
import com.varabyte.kotter.runtime.MainRenderScope
import gameplay.Ingredient
import kotlinx.coroutines.*
import kotter.Screen
import kotter.ui.Menu
import kotter.ui.Renderable.Companion.render
import kotter.ui.Text

class GameScreen(
    private val viewModel: GameViewModel,
) : Screen() {

    private var typingEnabled = false

    private var allowedLetters = charArrayOf()

    private var clockText = Clock("Opening!")

    private val streakText = StreakText("")

    private var ordersMenu = Menu(
        Array(5) {
            Menu.Item("Order ${it + 1}: -") {}
        }
    )

    private val recipeTitleText = Text("", Color.RED)

    private val recipeDescriptionText = Text("", Color.YELLOW)

    private val currentInputText = Text("")

    private val availableIngredientsText = Text("")

    private val scoreText = Text("", Color.GREEN)

    private val highestStreakText = Text("", Color.GREEN)

    private var displayScore = false

    init {
        CoroutineScope(Job()).launch {
            viewModel.state.collect {
                dispatchState(it)
            }
        }
    }

    override fun onNavigate() {
        CoroutineScope(Job()).launch {
            delay(500L)
            viewModel.start()
        }
    }

    override fun draw(scope: MainRenderScope) {
        with(scope) {
            text("Time: ")
            render(clockText)

            yellow {
                text("STREAK: ")
            }
            render(streakText)
            textLine()

            render(ordersMenu)
            textLine()

            if (!displayScore) {
                render(recipeTitleText)

                render(recipeDescriptionText)

                textLine()
                text("> ")
                render(currentInputText)
                textLine()

                render(availableIngredientsText)
            } else {
                yellow {
                    text("Score: ")
                }
                render(scoreText)
                yellow {
                    text("Highest streak: ")
                }
                render(highestStreakText)
            }
        }
    }

    override fun onKeyPressed(key: Key) {
        when(key) {
            is Keys.ESC -> navigator.navigateUp()
            is Keys.ENTER -> if (typingEnabled) submit()
            is CharKey -> when(key) {
                Keys.DIGIT_1, Keys.DIGIT_2, Keys.DIGIT_3, Keys.DIGIT_4, Keys.DIGIT_5 -> {
                    if (!typingEnabled) ordersMenu.run {
                        selectAt(key.code.digitToInt() - 1)
                        submit()
                    }
                }
                else -> if (typingEnabled && key.code in allowedLetters) currentInputText.text += key.code
            }
        }
    }

    private fun dispatchState(state: GameViewModel.State) {
        when (state) {
            GameViewModel.State.Init -> Unit
            is GameViewModel.State.GameStarting -> {
                typingEnabled = false
                CoroutineScope(Job()).launch {
                    viewModel.time.collect {
                        clockText.tick()
                    }
                }
                CoroutineScope(Job()).launch {
                    while(isActive) {
                        streakText.blink()
                    }
                }
            }
            is GameViewModel.State.GameStateUpdate -> {
                if (state.currentOrder != null) {
                    val recipe = state.currentOrder.recipe
                    typingEnabled = true
                    allowedLetters = recipe.food.ingredients.map(Ingredient::key).toCharArray()
                    recipeTitleText.text = recipe.title
                    recipeDescriptionText.text = recipe.description
                    availableIngredientsText.text = recipe.food.ingredients.joinToString(separator = "\n") {
                        "${it.name} - ${it.key}"
                    }
                } else {
                    typingEnabled = false
                    recipeTitleText.text = ""
                    recipeDescriptionText.text = ""
                    availableIngredientsText.text = ""
                }
                streakText.updateStage(state.streak)
                val orders = state.stations.mapIndexed { index, order ->
                    val title = order?.recipe?.food?.name ?: "-"
                    Menu.Item("Order ${index + 1}: $title") {
                        viewModel.pickOrder(index)
                    }
                }.toTypedArray()
                ordersMenu = Menu(orders)
            }
            is GameViewModel.State.GameEnded -> {
                typingEnabled = false
                clockText.text = "Finished!"
                scoreText.text = state.score.toString()
                highestStreakText.text = state.highestStreak.toString()
                displayScore = true
            }
        }
    }

    private fun submit() {
        val input = currentInputText.text
        currentInputText.text = ""
        viewModel.submitOrder(input)
    }
}