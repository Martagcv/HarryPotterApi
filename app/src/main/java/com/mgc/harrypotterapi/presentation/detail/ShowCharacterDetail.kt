package com.mgc.harrypotterapi.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mgc.harrypotterapi.CharacterTestDataBuilder
import com.mgc.harrypotterapi.R
import com.mgc.harrypotterapi.components.StarComponent
import com.mgc.harrypotterapi.domain.model.CharacterModel
import kotlinx.coroutines.job



val requester = FocusRequester()

@Composable
fun ShowCharacterDetail(
    character: CharacterModel
) {

    var starred by rememberSaveable() {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .focusRequester(focusRequester = requester)
                .focusable(),
            placeholder = painterResource(id = R.drawable.sg),
            error = painterResource(id = R.drawable.sg),
            model = ImageRequest.Builder(LocalContext.current)
                .data(character.image)
                .build(),
            contentDescription = "Personaje ${ character.name } Imagen"
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = character.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = character.house

                     //overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = character.patronus
                    //maxLines = 4,
                     //overflow = TextOverflow.Ellipsis
                )
            }

            /*
* id = id,
    name = name,
    house = house,
    wizard = wizard,
    patronus = patronus,
    image = image,*/

            // Star
            //Quitar?
            Checkbox(
                modifier = Modifier
                    .clearAndSetSemantics {
                        //.semantics {
                        contentDescription = "Hacer ${character.name} Favorito"
                        stateDescription = if (starred) {
                            "${character.name} marcado como Favorito"
                        } else {
                            "${character.name} desmarcado como Favorito"
                        }
                    },
                checked = starred,
                onCheckedChange = {
                    starred = it
                }
            )
        }
    }

    //??
    LaunchedEffect(Unit) {
        this.coroutineContext.job.invokeOnCompletion {
            requester.requestFocus()
        }
    }
}

@Composable
fun AndroidViewTest(character: CharacterModel) {
    var starred by remember {
        mutableStateOf(false)
    }
    // Star
    AndroidView(
        modifier = Modifier
            .semantics {
                contentDescription = "Hacer ${character.name} Favorito"
                stateDescription = if (starred) {
                    "${character.name} marked as Favorite"
                } else {
                    "${character.name} marked as not Favorite"
                }
            }
            .clickable {
                val newState = !starred
                starred = newState
            },
        factory = { context ->
            StarComponent(context).apply {
                this.checked = starred
            }
        },
        update = {
            it.checked = starred
        }
    )
}


@Composable
@Preview
fun ShowCharacterPreview() {
    ShowCharacterDetail(
        CharacterTestDataBuilder()
            .withName(" Name")
            .withHouse("House")
            .withPatronus("Patronus")
            .withImage("")

            .buildSingle()
    )
}