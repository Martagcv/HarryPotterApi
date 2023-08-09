package com.mgc.harrypotterapi.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.mgc.harrypotterapi.components.ShowError
import com.mgc.harrypotterapi.domain.model.CharacterModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(
    id: String,
    characterDetailViewModel: DetailViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    val characterState = characterDetailViewModel.character.observeAsState()
    val errorState = characterDetailViewModel.errorMessage.observeAsState()

    characterDetailViewModel.getCharacter(id)

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    val result = characterState.value


    result?.let { character: CharacterModel ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {

                        Text("Detalle de ${ character.name }")
                    },
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier.semantics {
                                contentDescription = "Atrás"
                            },
                            onClick = onBack
                        ) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            }
        ) {
            ShowCharacterDetail(character = character)
        }
    } ?: run {
        ShowError("Unknown error")
    }


}

@Preview
@Composable
fun CharacterDetailScreenPreview() {
    CharacterDetailScreen(id = "") {

    }
}


fun test(

    param1: String,
) {

}