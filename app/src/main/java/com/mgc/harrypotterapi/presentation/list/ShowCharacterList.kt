package com.mgc.harrypotterapi.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.mgc.harrypotterapi.presentation.theme.globalElevation
import com.mgc.harrypotterapi.presentation.theme.globalPadding
import com.mgc.harrypotterapi.presentation.theme.globalRoundedCornerShape


// Mostrar la imagen con coil
@Composable
fun ShowCharacterList(
    character: CharacterModel,
    onClick: () -> Unit
) {

    var starred by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = androidx.compose.ui.Modifier.padding(globalPadding),
        elevation = globalElevation,
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    onClick.invoke()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.sg),
                error = painterResource(id = R.drawable.sg),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(character.image)
                    .build(), contentDescription = ""
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
                }

                // Star
                AndroidView(
                    modifier = Modifier.clickable {
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
        }
    }
}


@Composable
@Preview
fun ShowCharacterPreview() {
    ShowCharacterList(
        CharacterTestDataBuilder()
            .withName("Sample name long text long text long text long textlong text long text long text")
            .withImage("")


            .buildSingle()
    ) {
        // Nothing todo here
    }
}