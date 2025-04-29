package com.android.jetpackcomposelandofcoding.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun AppUtils(
    appDimens: Dimens,
    context : @Composable () -> Unit
){
    val appDimens = remember {
        appDimens
    }
    CompositionLocalProvider(LocalAppDimens provides appDimens) {
        context()
    }
}

val LocalAppDimens = compositionLocalOf {
    CompactDimens
}

val screenOrientation
    @Composable
    get() = LocalConfiguration.current.orientation