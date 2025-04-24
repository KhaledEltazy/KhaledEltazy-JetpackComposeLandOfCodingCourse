package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    val viewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = viewModel.state.value
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
//                //to save text state
//                var textState by rememberSaveable {
//                    mutableStateOf("")
//                }
//
//                val namesListState = remember {
//                    mutableStateListOf<String>()
//                }

                LazyColumn(modifier = Modifier
                    .fillMaxWidth().weight(1f)) {
                    items(state.namesListState.size){
                        Text(text = state.namesListState[it], modifier = Modifier.background(Color.Blue).fillMaxWidth(), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }

                MyTextField(
                    textValue = state.textState,
                    onValueChanged = {
                        viewModel.updateText(it)
                    },
                    onAddClick = {
                        viewModel.updatesNamesList()
                        viewModel.updateText("")
                    }
                )
            }
        }
    }
}

////stateFull
//@Composable
//fun MyTextField(){
//    var textState by remember {
//        mutableStateOf("")
//    }
//
//    TextField(value = textState,
//        onValueChange = {
//            textState = it
//        },
//        modifier = Modifier.fillMaxWidth(),
//        label = {
//            Text("Enter Any Thing")
//        })
//}


//statelLess
@Composable
fun MyTextField(textValue : String,
                onValueChanged : (String) -> Unit,
                onAddClick : ()-> Unit){

    TextField(value = textValue,
        onValueChange = {
            onValueChanged(it)
        },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text("Enter Any Thing")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.clickable {
                onAddClick()
            })
        })
}
