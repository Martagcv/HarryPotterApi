package com.mgc.harrypotterapi

import com.mgc.harrypotterapi.domain.model.CharacterModel

class CharacterTestDataBuilder {
    val id = "test-id"
    var name = ""
    var house = ""
    var wizard = true
    var patronus = ""
    var image = ""
    var numElements: Int = 1

    fun withName(name: String): CharacterTestDataBuilder {
        this.name = name
        return this
    }
    fun withHouse(house: String): CharacterTestDataBuilder {
        this.house= house
        return this
    }
    /*
    fun withWizard(wizard: Boolean): CharacterTestDataBuilder {
        this.wizard= wizard
        return this
    }

     */
    fun withPatronus(patronus: String): CharacterTestDataBuilder {
        this.patronus= patronus
        return this
    }

    fun withImage(image: String): CharacterTestDataBuilder {
        this.image = image
        return this
    }


    fun withNumElements(numElements: Int): CharacterTestDataBuilder {
        this.numElements = numElements

        return this
    }

    fun buildList(): List<CharacterModel> {
        val list = mutableListOf<CharacterModel>()

        for(i in 0 until numElements) {

            list.add(
                CharacterModel(
                    id,
                    name = name,
                    house = house,
                    wizard = wizard,
                    patronus = patronus,
                    image = image,
                )
            )
        }

        return list.toList()
    }

    fun buildSingle() = CharacterModel(
        id = id,
        name = name,
        house = house,
        wizard = wizard,
        patronus = patronus,
        image = image

    )
}