package ui.game

import gameplay.GameSettings
import gameplay.Ingredient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ui.ViewModel
import gameplay.Order
import gameplay.food.*
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class GameViewModel(
    private val gameSettings: GameSettings,
    burger: Burger,
    corndog: Corndog,
    pizza: Pizza,
    pretzel: Pretzel,
    steak: Steak,
) : ViewModel {

    private val _state = MutableStateFlow<State>(State.Init)
    val state = _state as StateFlow<State>

    private val _time = MutableStateFlow(0)
    val time = _time as StateFlow<Int>

    sealed interface State {
        object Init : State
        object GameStarting : State
        class GameStateUpdate(
            val streak: Int,
            val stations: Array<Order?>,
            val currentOrder: Order?,
        ) : State
        class GameEnded(
            val highestStreak: Int,
            val score: Int,
        ) : State
    }

    private val stations = Array<Order?>(5) { null }

    private var currentOrder: Order? = null

    private var score = 0

    private var streak = 0

    private var highestStreak = 0

    private val recipes = listOf(burger, corndog, pizza, pretzel, steak).filter {
        it.grade <= gameSettings.difficulty.ordinal + 1
    }.flatMap { it.recipes.toList() }

    fun start() {
        _state.value = State.GameStarting
        CoroutineScope(Job()).launch {
            repeat(720) {
                _time.value = it
                if (Random.nextDouble() <= 0.1) {
                    val index = stations.indexOf(null)
                    if (index != -1) stations[index] = Order(recipes.random())
                    updateGameState()
                }
                delay(0.25.seconds.inWholeMilliseconds)
            }
            _state.value = State.GameEnded(streak, score)
        }
        updateGameState()
    }

    fun pickOrder(station: Int) {
        stations.getOrNull(station)?.let {
            currentOrder = it
            updateGameState()
        }
    }

    fun submitOrder(input: String) {
        currentOrder?.let { order ->
            val ingredientKeys = order.recipe.ingredients.map(Ingredient::key).sorted()
            val inputKeys = input.toCharArray().sorted()
            if (inputKeys == ingredientKeys) {
                score += 2
                streak++
                if (streak > highestStreak) highestStreak = streak
            } else if (inputKeys.count { it in ingredientKeys } == ingredientKeys.size - 1) {
                score += 1
                streak = 0
            } else streak = 0
            currentOrder = null
            stations[stations.indexOf(order)] = null
            updateGameState()
        }
    }

    private fun updateGameState() {
        _state.value = State.GameStateUpdate(
            streak,
            stations,
            currentOrder
        )
    }
}