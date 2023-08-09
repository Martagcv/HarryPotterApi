package com.mgc.harrypotterapi.domain.usecase

import com.mgc.harrypotterapi.data.CharacterRepository
import com.mgc.harrypotterapi.domain.model.CharacterModel

class GetDetailUseCase (
    private val characterRepository: CharacterRepository
        ) {
    suspend fun invoke(id: String): CharacterModel = characterRepository.getCharacterById(id)
}