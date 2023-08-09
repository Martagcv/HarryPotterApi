package com.mgc.harrypotterapi.data.local

import com.mgc.harrypotterapi.data.local.model.CharacterLocal

class LocalDataSourceImpl(
    private val characterDao: CharacterDao
):LocalDataSource{
    override suspend fun insertCharacterList(characterList: List<CharacterLocal>) = characterDao.insertAll(characterList)

    override suspend fun getCharacterList() : List<CharacterLocal> = characterDao.getAll()

    override suspend fun getCharacterById(id: String): CharacterLocal = characterDao.getCharacterById(id)
}