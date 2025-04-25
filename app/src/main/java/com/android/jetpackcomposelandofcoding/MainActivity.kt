package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
//                Button(
//                    onClick = { /* do something*/ },
//                    shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),
//                    enabled = true,
//                    elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 20.dp),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFF2D4356),
//                        contentColor = Color.Green,
//                        disabledContentColor = Color.LightGray,
//                        disabledContainerColor = Color.White
//                    )
//                ) {
//                    Icon(painter = painterResource(R.drawable.mouse), contentDescription = null)
//                    Text("Click")
//                }

//                TextButton(onClick = {}) {
//                    Text("Click Me")
//                }
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(R.drawable.mouse), contentDescription = null)
                }
            }
        }
    }
}
