package com.mgc.harrypotterapi.data.remote.dto

import com.squareup.moshi.Json

data class CharacterIdDto (
    @Json(name = "id") private val id: String?
)