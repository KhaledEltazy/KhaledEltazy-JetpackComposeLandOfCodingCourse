package com.android.jetpackcomposelandofcoding.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenA(
    navigateToB : (Person) ->Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var name by remember {
            mutableStateOf("")
        }

        var age by remember {
            mutableStateOf("")
        }

        var id by remember {
            mutableStateOf("")
        }

        TextField(value = name,onValueChange = {name = it}, label = {
            Text("Enter your Name")
        })

        Spacer(modifier = Modifier.height(25.dp))

        TextField(value = age,onValueChange = {age = it}, label = {
            Text("Enter your Age")
        })

        Spacer(modifier = Modifier.height(25.dp))

        TextField(value = id,onValueChange = {id = it}, label = {
            Text("Enter your it")
        })

        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {navigateToB(Person(name,age.toInt(),id.toInt()))}) {
            Text(text = "Go to B")
        }
    }
}