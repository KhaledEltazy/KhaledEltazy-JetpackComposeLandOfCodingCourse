package com.android.jetpackcomposelandofcoding.launched_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun Counter(
    max : Int,
    onCountChange : (Int) -> Unit
) {
    var counter by remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = counter) {
        //coroutine scope
        if (counter >= max + 1){
            return@LaunchedEffect
        }
        delay(1.seconds)
        onCountChange(counter)
        counter++
    }
}