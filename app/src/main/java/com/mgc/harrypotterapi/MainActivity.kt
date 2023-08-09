package com.mgc.harrypotterapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mgc.harrypotterapi.navigation.NavigationGraph
import com.mgc.harrypotterapi.presentation.theme.HarryPotterApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarryPotterApiTheme (){
                NavigationGraph()
            }
        }
    }
}

