package com.sha.laza.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.sha.laza.R

@ExperimentalMaterial3Api
@Composable
fun ThemeEditText(label: String, hint: String) {
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
        )

    )
}

@Composable
fun ThemeBackButton(modifier: Modifier, backBtnClick : () -> Unit){
    Card(modifier = modifier
        .wrapContentHeight()
        .padding(top = 16.dp, start = 16.dp)
        .clickable { backBtnClick.invoke()},
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Icon(
            Icons.Default.ArrowBack, contentDescription = "back icon",
            modifier = Modifier
                .size(40.dp).padding(5.dp),

            )
    }
}