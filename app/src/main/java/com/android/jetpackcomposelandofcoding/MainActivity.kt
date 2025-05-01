package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.jetpackcomposelandofcoding.ui.theme.JetpackComposeLandOfCodingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //animated visibility
            JetpackComposeLandOfCodingTheme{
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    var isContentVisible by remember {
                        mutableStateOf(false)
                    }
                    Button(onClick = {
                        isContentVisible = !isContentVisible
                    }){
                        Text(text = "Show/Hide")
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    AnimatedVisibility(visible = isContentVisible,
                        enter = fadeIn() + slideInVertically(),
                        exit = fadeOut() + /*slideOutHorizontally()*/ scaleOut()
                        ){
                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .background(Color.Red)
                        ){

                        }
                }
                }
            }
        }
    }
}
