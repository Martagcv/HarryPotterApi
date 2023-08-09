package com.mgc.harrypotterapi.data.remote

import com.mgc.harrypotterapi.data.remote.dto.CharacterDto

interface RemoteDataSource {
    suspend fun getCharacterList(): List<CharacterDto>
    //ojo ver en api

}