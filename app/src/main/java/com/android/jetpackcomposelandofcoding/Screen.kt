package com.android.jetpackcomposelandofcoding

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.android.jetpackcomposelandofcoding.ui.theme.Black
import com.android.jetpackcomposelandofcoding.ui.theme.BlueGray
import com.android.jetpackcomposelandofcoding.ui.theme.Roboto
import com.android.jetpackcomposelandofcoding.ui.theme.dimens
import com.android.jetpackcomposelandofcoding.ui.theme.screenOrientation

@Composable
fun LoginScreen() {
    Surface() {
        if (screenOrientation == Configuration.ORIENTATION_PORTRAIT)
            PortraitLoginScreen()
        else {
            PortraitLoginScreen()
        }

    }
}

@Composable
private fun LandScapeMode() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LoginSection()
        SocialMediaSection()
    }
}

@Composable
private fun PortraitLoginScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        TopSection()
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            LoginSection()

            Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))

            SocialMediaSection()
        }
        Spacer(Modifier.weight(0.8f))
        CreateAccountSection()
        Spacer(Modifier.weight(0.3f))
    }
}

@Composable
private fun ColumnScope.CreateAccountSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black


    Text(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF94A3B8),
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Don't have an account?")
            }
            withStyle(
                style = SpanStyle(
                    color = uiColor,
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium
                )
            ) {
                append(" ")
                append("Create Now")
            }
        }
    )
}

@Composable
private fun SocialMediaSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF64748B))
        )

        Spacer(Modifier.height(MaterialTheme.dimens.small3))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            SocialMediaLogIn(
                icon = R.drawable.google,
                text = "Google",
                modifier = Modifier.weight(1f)
            ) { }

            Spacer(Modifier.width(20.dp))

            SocialMediaLogIn(
                icon = R.drawable.facebook,
                text = "Facebook",
                modifier = Modifier.weight(1f)
            ) { }
        }
    }
}

@Composable
private fun LoginSection() {
    LoginTextField(label = "Email", trailing = "", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small2))
    LoginTextField(
        label = "Password",
        trailing = "Forget",
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ), shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = "Log In",

            )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    val screenHeight = LocalConfiguration.current.screenHeightDp

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeight / 2.12).dp),
            painter = painterResource(R.drawable.shape),
            contentDescription = null, contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.padding(top = (screenHeight / 9).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_logo),
                tint = uiColor,
                modifier = Modifier.size(MaterialTheme.dimens.logoSize)
            )

            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small2))

            Column {
                Text(
                    text = stringResource(id = R.string.the_tolet),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )

                Text(
                    text = stringResource(id = R.string.find_house),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )
    }
}