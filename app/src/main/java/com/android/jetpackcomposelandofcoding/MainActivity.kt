package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize().background(Color.Black),
                contentAlignment = Alignment.Center
            ) {

//                Text(stringResource(R.string.land_of_coding).plus(" ").repeat(30),
//                    maxLines = 3, overflow = TextOverflow.Ellipsis)

//                Text(
//                    text = "Land of Coding",
//                    color = Color.Magenta,
//                    fontSize = 32.sp,
//                    textDecoration = TextDecoration.LineThrough,
//                    textAlign = TextAlign.Start,
//                    modifier = Modifier.fillMaxWidth()
//                )

                val annotatedString = buildAnnotatedString {
                    blueGradientText("New")
                    append("\n\n")
                    pinkBlueGradientText("Gradient")
                    append("\n\n")
                    blueGradientText("Text")

                }

                Text(annotatedString)
            }
        }
    }
}

    private fun AnnotatedString.Builder.blueGradientText(text : String) {
        withStyle(
            style = SpanStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF2788C7),
                        Color(0xFF00BBD4)
                    )
                ),fontSize = 42.sp,
                fontWeight = FontWeight.Medium
            )
        ) {
            append(text)
        }
    }


private fun AnnotatedString.Builder.pinkBlueGradientText(text : String) {
    withStyle(
        style = SpanStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFFF3B85),
                    Color(0xFF00BBD4)
                )
            ), fontSize = 48.sp,
            fontWeight = FontWeight.Medium
        )
    ) {
        append(text)
    }
}


