package com.mgc.harrypotterapi.data.remote.dto

import com.squareup.moshi.Json

data class TestDto(
    @Json(name = "parentObject") val parentObject: AnotherObjectDto
)

data class AnotherObjectDto(
    @Json(name = "list") val list: List<String>
)