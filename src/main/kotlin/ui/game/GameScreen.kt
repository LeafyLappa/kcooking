package ui.game

import com.varabyte.kotter.foundation.input.CharKey
import com.varabyte.kotter.foundation.input.Key
import com.varabyte.kotter.foundation.input.Keys
import com.varabyte.kotter.foundation.text.*
import com.varabyte.kotter.runtime.MainRenderScope
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

    private var orders = arrayOf(
        Menu.Item("Order 1: -") {
            viewModel.pickOrder(0)
        },
        Menu.Item("Order 2: -") {
            viewModel.pickOrder(1)
        },
        Menu.Item("Order 3: -") {
            viewModel.pickOrder(2)
        },
        Menu.Item("Order 4: -") {
            viewModel.pickOrder(3)
        },
        Menu.Item("Order 5: -") {
            viewModel.pickOrder(4)
        },
    )

    private val foodTitleText = Text("", Color.RED)

    private val recipeText = Text("", Color.YELLOW)

    private val currentInputText = Text("")

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

            render(Menu(orders))
            textLine()

            if (!displayScore) {
                render(foodTitleText)

                render(recipeText)

                render(currentInputText)
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
                    if (!typingEnabled) orders[key.code.digitToInt() - 1].onSubmit()
//                    if (!typingEnabled) ordersMenu.run {
//                        selectAt(key.code.digitToInt() - 1)
//                        submit()
//                    }
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
                    typingEnabled = true
                    allowedLetters = state.currentOrder.recipe.ingredients.toCharArray()
                    foodTitleText.text = state.currentOrder.recipe.title
                    recipeText.text = state.currentOrder.recipe.description
                } else {
                    typingEnabled = false
                    foodTitleText.text = ""
                    recipeText.text = ""
                }
                streakText.updateStage(state.streak)
                orders = state.stations.mapIndexed { index, order ->
                    val title = order?.recipe?.title ?: "-"
                    Menu.Item("Order ${index + 1}: $title") {
                        viewModel.pickOrder(index)
                    }
                }.toTypedArray()
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