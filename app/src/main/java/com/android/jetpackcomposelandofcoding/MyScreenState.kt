package com.android.jetpackcomposelandofcoding

data class MyScreenState(
    val textState: String = "",
    val namesListState: MutableList<String> = mutableListOf()
)