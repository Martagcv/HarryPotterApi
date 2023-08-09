package com.mgc.harrypotterapi.data.remote

import com.mgc.harrypotterapi.data.remote.dto.CharacterDto
import com.mgc.harrypotterapi.data.remote.dto.SearchDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

//Aquí iría token pero esta Api no tiene

interface HarryPotterApi {

    //Ojo con que ponemos aquí y que hay puesto en la url del gradle

    @GET("characters")

    suspend fun getCharacterList(): List<CharacterDto>


    // @GET
    // @PUT
    // @DELETE
}
