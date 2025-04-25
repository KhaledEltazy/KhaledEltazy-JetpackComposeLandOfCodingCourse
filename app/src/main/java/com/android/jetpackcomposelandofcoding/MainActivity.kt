package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.8f)),
                contentAlignment = Alignment.Center
            ) {
                MyCustomCard(
                    modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                    image = R.drawable.elephant,
                    title = "Shadows & Lightnings",
                    text = "Create subtle and stunning UI designs with this using JetPack Compose, ;dlka;sdk ;kajdaksdj ;asdkjas;kdj ;askjd;asjkd as;kdjas;kdj as;kdj;askdj as;kdjas;kdj ;asdjkas;kdj assd ;kasdja as;kdjas;kjd ;askdjk",
                    publisher = Publisher(
                        name = "Khaled Mustafa",
                        job = "Quality Manager",
                        image = R.drawable.profile_image
                    )
                )
            }
        }
    }
}
