package com.sha.laza.presentation.signup

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sha.laza.R
import com.sha.laza.utils.BottomThemeButton
import com.sha.laza.utils.ThemeBackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(modifier: Modifier, onBack: () -> Unit, signUpClick : () -> Unit) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (backBtn, title, subTitle, signUpBtn, centerLayout) = createRefs()

        ThemeBackButton(modifier = Modifier.constrainAs(backBtn) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)

        }, backBtnClick = {onBack.invoke()})
        Text(
            text = stringResource(id = R.string.signup_screen_signup),
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

            ThemeEditText("User Name", "Enter your unique user name", KeyboardType.Text)
            ThemeEditText("Password", "Enter Password", KeyboardType.Password)
            ThemeEditText("Email", "Enter your email", KeyboardType.Email)
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
                }, onCheckedChange = {}, colors = SwitchDefaults.colors(checkedIconColor = colorResource(
                    id = R.color.purple
                ), uncheckedIconColor = colorResource(id = R.color.white)))

            }


        }


        BottomThemeButton(text = "Sign Up", modifier = Modifier
            .fillMaxWidth()
            .constrainAs(signUpBtn) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }, onClick = { signUpClick.invoke()})

    }

}


@ExperimentalMaterial3Api
@Composable
fun ThemeEditText(label: String, hint: String, type : KeyboardType) {
    var text by rememberSaveable { mutableStateOf(hint) }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(label) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.black),
            selectionColors = TextSelectionColors(
                backgroundColor = Color.White,
                handleColor = Color.LightGray
            ), containerColor = Color.White
        ), keyboardOptions = KeyboardOptions(keyboardType = type)

    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen(modifier = Modifier.fillMaxSize(), onBack = {}, signUpClick = {})
}
