package com.android.jetpackcomposelandofcoding

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val state = mutableStateOf(MyScreenState())

    //copy function that allow you to change one variable of data class
    fun updateText(newText : String){
        state.value = state.value.copy(textState = newText)
    }

    fun updatesNamesList(){
        val currentList = state.value.namesListState
        currentList.add(state.value.textState)
        state.value = state.value.copy(namesListState = currentList)
    }
}