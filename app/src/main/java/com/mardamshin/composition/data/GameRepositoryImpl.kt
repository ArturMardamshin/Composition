package com.mardamshin.composition.data

import com.mardamshin.composition.domain.entity.GameSettings
import com.mardamshin.composition.domain.entity.Level
import com.mardamshin.composition.domain.entity.Question
import com.mardamshin.composition.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl: GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> {
                GameSettings(
                    10,   //maxSumValue
                    3,    //minCountOfRightAnswers
                    50,   //minPercentOfRightAnswers
                    8     //gameTimeInSeconds
                )
            }
            Level.EASY -> {
                GameSettings(
                    10,   //maxSumValue
                    10,    //minCountOfRightAnswers
                    70,   //minPercentOfRightAnswers
                    60     //gameTimeInSeconds
                )
            }
            Level.NORMAL -> {
                GameSettings(
                    20,   //maxSumValue
                    20,    //minCountOfRightAnswers
                    80,   //minPercentOfRightAnswers
                    40     //gameTimeInSeconds
                )
            }
            Level.HARD -> {
                GameSettings(
                    30,   //maxSumValue
                    30,    //minCountOfRightAnswers
                    90,   //minPercentOfRightAnswers
                    40     //gameTimeInSeconds
                )
            }

        }
    }
}