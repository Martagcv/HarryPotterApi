package com.mgc.harrypotterapi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CharacterTable")
data class CharacterLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "house") val house: String,
    @ColumnInfo(name = "wizard") val wizard: Boolean,
    @ColumnInfo(name = "patronus") val patronus: String,
    @ColumnInfo(name = "image") val image: String,
    //@ColumnInfo(name = "favorite") val favorite: Boolean
)

/*
* id = id,
    name = name,
    house = house,
    wizard = wizard,
    patronus = patronus,
    image = image,*/
