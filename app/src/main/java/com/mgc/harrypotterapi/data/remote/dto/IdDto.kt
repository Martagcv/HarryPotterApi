package com.mgc.harrypotterapi.data.remote.dto

import com.squareup.moshi.Json

data class IdDto(
    @Json(name = "id") val id: String
)