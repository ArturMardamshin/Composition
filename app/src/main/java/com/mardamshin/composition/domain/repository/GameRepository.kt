package com.mardamshin.composition.domain.repository

import com.mardamshin.composition.domain.entity.GameSettings
import com.mardamshin.composition.domain.entity.Level
import com.mardamshin.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}