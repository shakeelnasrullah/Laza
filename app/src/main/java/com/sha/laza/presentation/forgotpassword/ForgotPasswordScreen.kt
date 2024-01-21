package com.sha.laza.presentation.forgotpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.sha.laza.ui.theme.LazaTheme
import com.sha.laza.utils.BottomThemeButton
import com.sha.laza.utils.ThemeBackButton
import com.sha.laza.utils.ThemeEditText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    modifier: Modifier,
    onBack: () -> Unit,
    onConfirm: () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (backBtn, title, icon, confirmBtn, centerLayout, forgotBtn, confirmationMsg) = createRefs()

        ThemeBackButton(modifier = Modifier.constrainAs(backBtn) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)

        }, backBtnClick = {onBack.invoke()})
        Text(
            text = stringResource(id = R.string.password_screen_title),
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
        Image(painter = painterResource(id = R.drawable.forgot_password), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(icon) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(centerLayout.top)
                    end.linkTo(parent.end)
                })



        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 16.dp)
                .constrainAs(centerLayout) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(confirmBtn.top)
                },
            verticalArrangement = Arrangement.Center
        ) {

            ThemeEditText("User Name", "Enter your unique user name")


        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
                .constrainAs(confirmationMsg) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(confirmBtn.top)

                },
            text = stringResource(id = R.string.password_screen_description),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )


        BottomThemeButton(text = stringResource(id = R.string.password_confirm), modifier = Modifier
            .fillMaxWidth()
            .constrainAs(confirmBtn) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }, onClick = {})

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForgotPasswordScreen() {
    LazaTheme {
        ForgotPasswordScreen(modifier = Modifier.fillMaxSize(), onBack = { }, onConfirm = {})
    }
}