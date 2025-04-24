package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //BOX LAYOUT
            /*Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Welcome", modifier = Modifier
                        .align(Alignment.TopStart)
                )
                Text(
                    "Welcome", modifier = Modifier
                        .align(Alignment.TopCenter)
                )
                Text(
                    "Welcome", modifier = Modifier
                        .align(Alignment.TopEnd)
                )
                Text(
                    "Welcome", modifier = Modifier
                        .align(Alignment.CenterStart)
                )
                Text(
                    "Hello", modifier = Modifier
                        .align(Alignment.Center)
                )
                Text(
                    "Welcome", modifier = Modifier
                        .align(Alignment.CenterEnd)
                )
                Text(
                    "Welcome", modifier = Modifier
                        .align(Alignment.BottomStart)
                )
                Text(
                    "Welcome", modifier = Modifier
                        .align(Alignment.BottomCenter)
                )
                Text(
                    "Welcome", modifier = Modifier
                        .align(Alignment.BottomEnd)
                )
            }*/

//            //Column layout
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                verticalArrangement = Arrangement.spacedBy(20.dp),
//                horizontalAlignment = Alignment.End
//            ) {
//                Text("Hello")
//                Text("Hi")
//                Text("Hi")
//                Text("Welcom")
//            }
//
//            //Column layout
//            Row(
//                modifier = Modifier
//                    .fillMaxSize(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.Bottom
//            ) {
//                Text("Hello")
//                Text("Hi")
//                Text("Hi")
//                Text("Welcom")
//            }

            //constraint layout
            val constraints = ConstraintSet{
                val greenBox = createRefFor("greenbox")
                val redBox = createRefFor("redbox")
                val guideline = createGuidelineFromTop(.5f)

                constrain(greenBox){
                    top.linkTo(guideline)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
                constrain(redBox){
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Spread)
            }
            ConstraintLayout(
                constraints, modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(modifier = Modifier.background(Color.Green)
                    .layoutId("greenbox"))
                Box(modifier = Modifier.background(Color.Red)
                    .layoutId("redbox"))
            }

        }
    }
}
