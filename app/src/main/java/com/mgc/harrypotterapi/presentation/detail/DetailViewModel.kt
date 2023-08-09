package com.mgc.harrypotterapi.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgc.harrypotterapi.domain.model.CharacterModel
import com.mgc.harrypotterapi.domain.usecase.GetDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
) : ViewModel() {

    private val _character = MutableLiveData<CharacterModel>()
    val character: LiveData<CharacterModel> get() = _character

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage


    fun getCharacter(id: String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getDetailUseCase.invoke(id)
            }
            _character.value = result
        } catch (_: Throwable) {
            _errorMessage.value = "Error  from ViewModel"
        }
    }
}
