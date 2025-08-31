package com.mardamshin.composition.domain.usecases

import com.mardamshin.composition.domain.entity.GameSettings
import com.mardamshin.composition.domain.entity.Level
import com.mardamshin.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}