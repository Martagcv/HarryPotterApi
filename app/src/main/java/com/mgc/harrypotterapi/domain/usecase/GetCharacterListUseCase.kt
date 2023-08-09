package com.mgc.harrypotterapi.domain.usecase

import com.mgc.harrypotterapi.data.CharacterRepository

class GetCharacterListUseCase (
    private val characterRepository: CharacterRepository
) {
    suspend fun invoke() = characterRepository.getCharacterList()
}
