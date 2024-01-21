package com.sha.laza.presentation.signin


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sha.laza.R
import com.sha.laza.utils.BottomThemeButton
import com.sha.laza.utils.ThemeBackButton
import com.sha.laza.utils.ThemeEditText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(modifier: Modifier, onBack: () -> Unit, signInClicked: () -> Unit) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (backBtn, title, subTitle, signUpBtn, centerLayout, forgotBtn, confirmationMsg) = createRefs()

        ThemeBackButton(modifier = Modifier.constrainAs(backBtn) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)

        }, backBtnClick = {onBack.invoke()})
        Text(
            text = stringResource(id = R.string.signin_screen_title),
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

        Text(
            text = stringResource(id = R.string.signup_screen_sub_title),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(subTitle) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.black),
            fontWeight = FontWeight.Normal
        )

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 16.dp)
                .constrainAs(centerLayout) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(signUpBtn.top)
                },
            verticalArrangement = Arrangement.Center
        ) {

            ThemeEditText("User Name", "Enter your unique user name")
            ThemeEditText("Password", "Enter Password")
            Text(
                text = stringResource(id = R.string.signin_forgot),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(vertical = 8.dp)
                    .clickable { }, color = Color.Red
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(R.string.signup_screen_remember_me))
                Switch(checked = rememberSaveable {
                    true
                }, onCheckedChange = {}, colors = SwitchDefaults.colors(
                    checkedIconColor = colorResource(
                        id = R.color.purple
                    ), uncheckedIconColor = colorResource(id = R.color.white)
                )
                )

            }


        }

        val annotatedString = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Gray)) {
                append(stringResource(id = R.string.signin_term_label))
            }
            append(stringResource(id = R.string.signin_terms_condition))
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
                .constrainAs(confirmationMsg) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(signUpBtn.top)

                },
            text = annotatedString,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )




        BottomThemeButton(text = stringResource(id = R.string.signin_label), modifier = Modifier
            .fillMaxWidth()
            .constrainAs(signUpBtn) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }, onClick = {
            signInClicked.invoke()
        })

    }

}


@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    SignInScreen(modifier = Modifier.fillMaxSize(), onBack = {}, signInClicked = {})
}
