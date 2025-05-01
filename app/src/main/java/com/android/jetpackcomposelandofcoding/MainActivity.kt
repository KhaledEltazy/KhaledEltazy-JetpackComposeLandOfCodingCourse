package com.android.jetpackcomposelandofcoding

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.jetpackcomposelandofcoding.ui.theme.JetpackComposeLandOfCodingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLandOfCodingTheme(dynamicColor = false){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TestMe()
                }
            }

        }
    }
}

@Composable
fun TestMe() {
    val color = if(isSystemInDarkTheme()) Color.Black else Color.LightGray
    Box(
        modifier = Modifier
            .size(300.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = color),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {

        }){
            Text(text = "Test Me")
        }
    }
}


@Preview(name = "Light", showBackground = true)
@Preview(name = "Night",uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun TestMePreview(){
    JetpackComposeLandOfCodingTheme(dynamicColor = false){
        TestMe()
    }
}
