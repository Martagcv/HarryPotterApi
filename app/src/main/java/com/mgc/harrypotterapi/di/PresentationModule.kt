package com.mgc.harrypotterapi.di

//import com.mgc.harrypotterapi.presentation.detail.DetailViewModel
import com.mgc.harrypotterapi.presentation.detail.DetailViewModel
import com.mgc.harrypotterapi.presentation.list.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}