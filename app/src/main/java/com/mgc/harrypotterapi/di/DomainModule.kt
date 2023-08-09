package com.mgc.harrypotterapi.di

import com.mgc.harrypotterapi.domain.usecase.GetCharacterListUseCase
import com.mgc.harrypotterapi.domain.usecase.GetDetailUseCase
import org.koin.dsl.module

//recoger casos de uso
val domainModule = module {

    single { GetCharacterListUseCase(get()) }
    single { GetDetailUseCase(get()) }
}