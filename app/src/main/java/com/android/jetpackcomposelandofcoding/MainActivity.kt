package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.jetpackcomposelandofcoding.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Box(
//                modifier = Modifier
////                    .width(100.dp)
////                    .height(200.dp)
////                    .fillMaxSize(0.7f)
////                    .fillMaxWidth()
////                    .fillMaxHeight()
////                    .fillMaxSize()
//                    .background(Color.Red, shape = RectangleShape)
////                    .padding(start = 10.dp,top = 10.dp,end = 10.dp)
//                    .padding(10.dp)
//                    .fillMaxWidth()
//                    .fillMaxHeight(.5f)
////                    .fillMaxWidth()
//            )
//
//            Box(modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center){
//                Box(modifier = Modifier.size(100.dp)
//                    .clip(CircleShape)
////                    .clip(RoundedCornerShape(10.dp))
//                    .border(width = 3.dp, color = Color.Red, shape = CircleShape)
//                    .border(width = 6.dp, color = Color.Black, shape = CircleShape)
//                    .background(Color.Green)
//                    )
//            }
//
            Row(modifier = Modifier
                .fillMaxWidth()){
                Box(modifier = Modifier.background(Color.Red).height(100.dp).weight(1f))
                Spacer(Modifier.width(5.dp))
                Box(modifier = Modifier.background(Color.Red).height(100.dp).weight(1f))
            }
        }
    }
}
