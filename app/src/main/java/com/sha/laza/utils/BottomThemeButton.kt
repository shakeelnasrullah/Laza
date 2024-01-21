package com.sha.laza.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sha.laza.R

@Composable
fun BottomThemeButton(text: String, modifier: Modifier , onClick : () -> Unit) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.purple),
            contentColor = Color.White
        )
    ) {
        Text(text = text, modifier = Modifier.padding(bottom = 14.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.white),
            fontWeight = FontWeight.Bold)
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    BottomThemeButton(text = "Create an Account", modifier = Modifier.fillMaxWidth(), onClick = {})
}