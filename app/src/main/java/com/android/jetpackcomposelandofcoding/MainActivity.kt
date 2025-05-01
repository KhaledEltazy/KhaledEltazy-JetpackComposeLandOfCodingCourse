package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.jetpackcomposelandofcoding.ui.theme.JetpackComposeLandOfCodingTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //animated visibility
            JetpackComposeLandOfCodingTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val infiniteTransition = rememberInfiniteTransition(label = "")
                    var color = infiniteTransition.animateColor(
                        initialValue = Color.Red,
                        targetValue = Color.Green,
                        animationSpec = infiniteRepeatable(animation = tween(1000), repeatMode = RepeatMode.Reverse),
                        label = ""
                    )
                    Box(modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(color.value)
                    ) { }
                }
            }
        }
    }
}

@Composable
private fun AnimatableLesson() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //use to animate values together
        var scale = remember {
            androidx.compose.animation.core.Animatable(1f)
        }
        var alpa = remember {
            Animatable(1f)
        }
        var color by remember { mutableStateOf(Color.Red) }
        val animatedColor by animateColorAsState(targetValue = color, label = "")
        val scope = rememberCoroutineScope()
        Box(modifier = Modifier
            .size(100.dp)
            .scale(scale.value)
            .clip(CircleShape)
            .background(animatedColor.copy(alpha = alpa.value))
            .clickable {
                scope.launch {
                    launch {
                        scale.animateTo(scale.value + 0.1f)
                    }
                    launch {
                        alpa.animateTo(alpa.value + 0.1f)
                    }

                }
                color = Color(
                    red = Random.nextInt(255),
                    green = Random.nextInt(255),
                    blue = Random.nextInt(255)
                )
            }
        ) { }
    }
}

@Composable
private fun AnimateAsStateLesson() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var scale by remember {
            mutableFloatStateOf(1f)
        }
        var color by remember { mutableStateOf(Color.Red) }
        val animatedScale by animateFloatAsState(targetValue = scale, label = "")
        val animatedColor by animateColorAsState(targetValue = color, label = "")
        Box(modifier = Modifier
            .size(100.dp)
            .scale(animatedScale)
            .clip(CircleShape)
            .background(animatedColor)
            .clickable {
                scale += 0.1f
                color = Color(
                    red = Random.nextInt(255),
                    green = Random.nextInt(255),
                    blue = Random.nextInt(255)
                )
            }
        ) { }
    }
}


@Composable
private fun AnimationSizeChangesLesson() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var isAllTextVisible by remember {
            mutableStateOf(false)
        }
        Text(
            text = "Animations are essential in a modern mobile app in order to realize a smooth and understandable user experience.".repeat(
                2
            ),
            modifier = Modifier
                .padding(5.dp)
                .background(Color.LightGray)
                .clickable {
                    isAllTextVisible = !isAllTextVisible
                }
                .animateContentSize(
                    animationSpec = spring(
                        /* stiffness = Spring.StiffnessMediumLow,*/ dampingRatio = Spring.DampingRatioMediumBouncy
                    )
                ),
            maxLines = if (isAllTextVisible) Int.MAX_VALUE else 2,
        )
    }
}

@Composable
private fun AnimatedContentLesson() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var count by remember {
            mutableStateOf(0)
        }
        Button(onClick = {
            count++
        }) {
            Text(text = "Add")
        }

        AnimatedContent(targetState = count, label = "",
            transitionSpec = { fadeIn() togetherWith fadeOut() }
        ) {
            Text(text = "Count ${it}")
        }
    }
}

@Composable
private fun AnimatedVisibilityLesson() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isContentVisible by remember {
            mutableStateOf(false)
        }
        Button(onClick = {
            isContentVisible = !isContentVisible
        }) {
            Text(text = "Show/Hide")
        }
        Spacer(modifier = Modifier.height(10.dp))

        AnimatedVisibility(
            visible = isContentVisible,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + /*slideOutHorizontally()*/ scaleOut()
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Red)
            ) {

            }
        }
    }
}