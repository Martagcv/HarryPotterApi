package com.mgc.harrypotterapi.data.remote.dto

import com.squareup.moshi.Json

data class CharacterDto(
    @Json(name = "id") val id: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "house") val house: String?,
    @Json(name = "wizard") val wizard: Boolean?,
    @Json(name = "patronus") val patronus: String?,
    @Json(name = "image") val image: String?,
    //@Json(name = "favorite") val favorite: Boolean?
)
/*
* id = id,
    name = name,
    house = house,
    wizard = wizard,
    patronus = patronus,
    image = image,
    *
    * [{"id":"9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
    * "name":"Harry Potter",
    * "alternate_names":["The Boy Who Lived","The Chosen One"],
    * "species":"human",
    * "gender":"male",
    * "house":"Gryffindor",
    * "dateOfBirth":"31-07-1980",
    * "yearOfBirth":1980,
    * "wizard":true,
    * "ancestry":"half-blood",
    * "eyeColour":"green",
    * "hairColour":"black",
    * "wand":{"wood":"holly","core":"phoenix feather","length":11},"
    * patronus":"stag",
    * "hogwartsStudent":true,
    * "hogwartsStaff":false,
    * "actor":"Daniel Radcliffe",
    * "alternate_actors":[],
    * "alive":true,
    * "image":"https://ik.imagekit.io/hpapi/harry.jpg"}*/