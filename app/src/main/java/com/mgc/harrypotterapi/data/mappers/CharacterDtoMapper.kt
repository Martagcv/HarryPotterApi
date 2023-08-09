package com.mgc.harrypotterapi.data.mappers

import com.mgc.harrypotterapi.data.local.model.CharacterLocal
import com.mgc.harrypotterapi.data.remote.dto.CharacterDto
import com.mgc.harrypotterapi.domain.model.CharacterModel

fun CharacterDto.toCharacterModel(): CharacterModel {
    return CharacterModel(
        id = id ?: "",
        name = name ?: "",
        house = house ?: "",
        wizard = wizard ?: true,
        patronus = patronus ?: "",
        image = image ?: ""


        // id = id,
        // name = name,
        //  house = house,
        // wizard = wizard,
        //  patronus = patronus,
        //image = image
    )
}


fun CharacterDto.toCharacterLocal() = CharacterLocal (

    //inLine
        id = id ?: "",
        name = name ?: "",
        house = house ?: "",
        wizard = wizard ?: true,
        patronus = patronus ?: "",
        image = image ?: ""

    )

//ojo con los values
fun CharacterLocal.toCharacterModel() = CharacterModel(
    id = id,
    name = name,
    house = house,
    wizard = wizard,
    patronus = patronus,
    image = image,

)

fun CharacterDto.toCharacterModelConstructorWithoutName() = CharacterModel(
    id = id ?: "",
    name = name ?: "",
    house = house ?: "",
    wizard = wizard ?: true,
    patronus = patronus ?: "",
    image = image ?: ""
)