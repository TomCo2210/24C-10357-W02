package dev.tomco.a24c_10357_w02.logic

import dev.tomco.a24c_10357_w02.model.Country
import dev.tomco.a24c_10357_w02.model.DataManager

class GameManager(private val lifeCount: Int = 3) {
    var score: Int = 0
        private set
    var currentIndex: Int = 0
        private set
    var wrongAnswers: Int = 0
        private set

    private val allCountries: List<Country>  = DataManager.getAllCountries()

    val currentCountry:Country
        get() = allCountries[currentIndex]

    val isGameEnded: Boolean
        get() = currentIndex == allCountries.size

    val isGameLost: Boolean
        get() = wrongAnswers == lifeCount

    fun checkAnswer(expected: Boolean){
        if (currentCountry.canEnter == expected)
            score += ANSWER_POINTS
        else
            wrongAnswers++
        currentIndex++
    }

    companion object{
        private const val ANSWER_POINTS = 10
    }
}