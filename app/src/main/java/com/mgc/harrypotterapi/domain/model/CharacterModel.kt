package com.mgc.harrypotterapi.domain.model

data class CharacterModel(
    val id: String,
    val name: String,
    val house: String,
    val wizard: Boolean,
    val patronus: String,
    val image: String

//Es obligatorio poner todos los values?
)

/*
* {"id":"9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8","name":"Harry Potter","alternate_names":["The Boy Who Lived",
* "The Chosen One"],"species":"human","gender":"male","house":"Gryffindor","dateOfBirth":"31-07-1980",
* "yearOfBirth":1980,"wizard":true,"ancestry":"half-blood","eyeColour":"green","hairColour":"black",
* "wand":{"wood":"holly","core":"phoenix feather","length":11},"patronus":"stag","hogwartsStudent":true,
* "hogwartsStaff":false,"actor":"Daniel Radcliffe","alternate_actors":[],"alive":true,
* "image":"https://ik.imagekit.io/hpapi/harry.jpg"}*/