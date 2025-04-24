package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Greeting("Khaled")
//            Button(onClick = { println("click") }, content = {
//                Text("Button")
//            })
//            Icon(painter = painterResource(id =R.drawable.ic_launcher_foreground),contentDescription = null,tint = Color.Blue)
//            Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null)
//
//                TextField(value = "", onValueChange = {}, label = {
//                    Text("put you name")
//                })
//            FloatingActionButton(onClick = {}) {
//                Icon(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null)
//            }
            ExtendedFloatingActionButton(text = {
                Text("Add")
            }, onClick = {}, icon = {
                Icon(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null)
            }, elevation = FloatingActionButtonDefaults.elevation(10.dp))
        }
    }
}

@Composable
fun Greeting(text :String){
    Text(text = "welcome $text",color= Color.Red, fontSize = 22.sp, fontWeight = FontWeight.Bold)
}
