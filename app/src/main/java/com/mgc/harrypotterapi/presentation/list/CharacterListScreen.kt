package com.mgc.harrypotterapi.presentation.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mgc.harrypotterapi.components.ShowError
import com.mgc.harrypotterapi.domain.model.CharacterModel
import com.mgc.harrypotterapi.presentation.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = characterListViewModel.characterList.observeAsState()

    val errorState = characterListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    LazyColumn(
        modifier = Modifier.padding(
            vertical = globalPadding
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val characterList = state.value
        items(characterList?.size ?: 0) { i ->

            val item = characterList?.get(i)
            item?.let { character: CharacterModel ->
                ShowCharacterList(character) {
                    onItemClick.invoke(character.id)
                }
            }

        }
    }
}

@Preview
@Composable
fun CharacterListScreenPreview() {
    CharacterListScreen {
        // Empty callback
    }
}