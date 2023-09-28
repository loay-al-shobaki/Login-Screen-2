package com.example.loginscreen2


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreen2.ui.theme.Black
import com.example.loginscreen2.ui.theme.BlueGray
import com.example.loginscreen2.ui.theme.Robote
import com.example.loginscreen2.ui.theme.ScreenOrientation
import com.example.loginscreen2.ui.theme.dimens

@Composable
fun LoginScreen() {

    Surface {
        if (ScreenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            PortraitLoginScreen()
        } else {
            PortraitLoginScreen()
        }

    }

}

@Composable
private fun LandscapeLoginScreen() {
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
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
            CreateAccountSection()
        }
    }
}

@Composable
private fun CreateAccountSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    Box(
        modifier = Modifier
            .fillMaxHeight(fraction = 0.6f)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(0xff94a3b8),
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    fontFamily = Robote,
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Don't have acconut?")
            }

            withStyle(
                style = SpanStyle(
                    color = uiColor,
                    fontSize = 14.sp,
                    fontFamily = Robote,
                    fontWeight = FontWeight.Medium
                )
            ) {
                append(" Create Now")
            }
        }
        )
    }
}

@Composable
private fun SocialMediaSection() {


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Or continue with ",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xff64748B))
        )
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLogIn(
                icon = R.drawable.google,
                text = stringResource(R.string.google),
                modifier = Modifier.weight(1f)
            ) {}
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small3))

            SocialMediaLogIn(
                icon = R.drawable.facebook,
                text = stringResource(R.string.facebook),
                modifier = Modifier.weight(1f)
            ) {

            }
        }
    }
}


@Composable
private fun LoginSection() {
    LoginTextField(label = "Email", trailing = "", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small2))
    LoginTextField(
        label = "password",
        trailing = "Forgot?",
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = "Log in",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun TopSection() {

    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    val screenHeight = LocalConfiguration.current.screenHeightDp
    Box(
        contentAlignment = Alignment.TopCenter,

        ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeight/2.12).dp),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.padding(top = (screenHeight/9).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(MaterialTheme.dimens.logoSize),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(
                    id = R.string.app_name
                ),
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(10.dp))

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
                .align(Alignment.BottomCenter),
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )
    }
}


@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}