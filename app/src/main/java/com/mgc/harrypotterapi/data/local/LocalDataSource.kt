package com.mgc.harrypotterapi.data.local

import com.mgc.harrypotterapi.data.local.model.CharacterLocal

interface LocalDataSource {
    suspend fun insertCharacterList(characterList: List<CharacterLocal>)
    suspend fun getCharacterList() : List<CharacterLocal>
    suspend fun getCharacterById(id: String) : CharacterLocal
}