package com.mgc.harrypotterapi.data.remote

import com.mgc.harrypotterapi.data.remote.dto.CharacterDto
import com.mgc.harrypotterapi.data.remote.dto.SearchDto

class RemoteDataSourceImpl(
    private val harryPotterApi: HarryPotterApi
) : RemoteDataSource {
    override suspend fun getCharacterList(): List<CharacterDto> =
        harryPotterApi.getCharacterList()


}