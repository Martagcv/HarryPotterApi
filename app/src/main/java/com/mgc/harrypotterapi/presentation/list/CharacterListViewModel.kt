package com.mgc.harrypotterapi.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgc.harrypotterapi.domain.model.CharacterModel
import com.mgc.harrypotterapi.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterListViewModel (
    private val getCharacterListUseCase: GetCharacterListUseCase
) : ViewModel() {

    private val _characterList = MutableLiveData<List<CharacterModel>>()
    val characterList: LiveData<List<CharacterModel>> get() = _characterList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage


    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            //examples.exampleFold()
            try {
                _errorMessage.value = null
                val result = withContext(Dispatchers.IO) {
                    getCharacterListUseCase.invoke()
                }
                _characterList.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }
}