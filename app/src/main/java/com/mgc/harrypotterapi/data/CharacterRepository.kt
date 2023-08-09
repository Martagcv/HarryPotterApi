package com.mgc.harrypotterapi.data

import com.mgc.harrypotterapi.domain.model.CharacterModel

interface CharacterRepository {


    suspend fun getCharacterList(): List<CharacterModel>

    suspend fun getCharacterById(id: String) : CharacterModel


}