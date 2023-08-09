package com.mgc.harrypotterapi.data

import com.mgc.harrypotterapi.data.local.LocalDataSource
import com.mgc.harrypotterapi.data.mappers.toCharacterLocal
import com.mgc.harrypotterapi.data.mappers.toCharacterModel
import com.mgc.harrypotterapi.data.remote.RemoteDataSource
import com.mgc.harrypotterapi.domain.model.CharacterModel
import com.mgc.harrypotterapi.ext.hasHttps

class CharacterRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :CharacterRepository {
    override suspend fun getCharacterList(): List<CharacterModel> {
        val localData = localDataSource.getCharacterList()

        // Lógica de coordinación de datos
        return if (localData.isNotEmpty()) {
            localData.map { it.toCharacterModel() }
        } else {
            val remoteData = remoteDataSource.getCharacterList().filter {
                (it.id?.isNotEmpty() == true) &&
                        (it.image?.hasHttps() == true)
            }
            localDataSource.insertCharacterList(remoteData.map { it.toCharacterLocal() })

            remoteData.map {
                it.toCharacterModel()
            }
        }
    }


    override suspend fun getCharacterById(id: String): CharacterModel =
        localDataSource.getCharacterById(id).toCharacterModel()
}



