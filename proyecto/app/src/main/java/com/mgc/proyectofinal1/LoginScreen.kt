package com.mgc.proyectofinal1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keepcoding.androidsuperpoderes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    // Prueba de paso de parámetros
    onForgotClicked: (Int) -> Unit{
) }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = R.drawable.hp),
            contentDescription = "SuperHero Application Logo"
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
        )

        TextField(
            value = email,
            placeholder = {
                Text("Email")
            },
            onValueChange = { newValue ->
                email = newValue
            },
            leadingIcon = {
                Image(
                    imageVector = Icons.Default.Email,
                    contentDescription = ""
                )
            }
        )

        TextField(
            value = password,
            placeholder = {
                Text("Password")
            },
            onValueChange = {
                password = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = ""
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Outlined.AccountBox,
                        contentDescription = ""
                    )
                }
            }
        )

        Spacer(
            modifier = Modifier
                .size(20.dp)
        )

        Button(
            onClick = onLoginSuccess
        ) {
            Text(
                text = "Login"
            )
        }
        Spacer(
            modifier = Modifier
                .size(20.dp)
        )

        Button(
            onClick = {
                onForgotClicked.invoke(0)
            }
        ) {
            Text(
                text = "Forgot"
            )
        }

        /*
        onClick = {
        onLoginSuccess.invoke()
        onLoginSuccess()
        }
        */


    }
}

/*
* */

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = {

        },
        onForgotClicked = { test ->

        }
    )
}
