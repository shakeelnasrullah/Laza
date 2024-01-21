package com.sha.laza.presentation.socialplatforms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sha.laza.R
import com.sha.laza.utils.BottomThemeButton
import com.sha.laza.utils.ThemeBackButton

@Composable
fun SocialPlatformScreen(modifier: Modifier, goToSignUp : () -> Unit, goToPlayer : () -> Unit) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (backBtn, title, socialPlatformsLayout,signIn, signUp) = createRefs()

        ThemeBackButton(modifier = Modifier.constrainAs(backBtn) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)

        }, backBtnClick = {})


        Text(
            text = stringResource(id = R.string.social_screen_title),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(title) {
                    top.linkTo(backBtn.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.black),
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .constrainAs(socialPlatformsLayout) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(signUp.top)
                },
            verticalArrangement = Arrangement.Center
        ) {

            SocialPlatformsButton(
                title = R.string.social_screen_facebook,
                imageId = R.drawable.facebook,
                color = R.color.facebook_btn_color, onClick = {goToPlayer.invoke()}
            )
            SocialPlatformsButton(
                title = R.string.social_screen_twitter,
                imageId = R.drawable.twitter,
                color = R.color.twitter_btn_color, onClick = {}
            )
            SocialPlatformsButton(
                title = R.string.social_screen_google,
                imageId = R.drawable.google,
                color = R.color.google_btn_color, onClick = {}
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .constrainAs(signIn) {

                bottom.linkTo(signUp.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }, horizontalArrangement = Arrangement.Center) {

            Text(text = "Already have an Account?",
                color = Color.Gray)
            Text(text = "Sign In", color = Color.Black, fontWeight = FontWeight.SemiBold)
        }

        BottomThemeButton(text = "Create An Account",modifier= Modifier
            .fillMaxWidth()
            .constrainAs(signUp) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }, onClick = {
            goToSignUp.invoke()
        })

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    SocialPlatformScreen(modifier = Modifier.fillMaxSize(), goToSignUp = {}, goToPlayer = {})
}

@Composable
fun SocialPlatformsButton(title: Int, imageId: Int, color: Int, onClick : () -> Unit) {
    Button(
        onClick = { onClick.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = color)
        )
    ) {
        Icon(
            painter = painterResource(id = imageId),
            modifier = Modifier.size(20.dp),
            contentDescription = "button logo"
        )
        Text(
            text = stringResource(id = title),
            modifier = Modifier.padding( start = 8.dp, top = 4.dp, bottom = 4.dp, end = 8.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.white),
            fontWeight = FontWeight.Bold
        )
    }
}