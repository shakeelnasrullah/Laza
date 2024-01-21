package com.sha.laza.presentation.gender

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sha.laza.R

@Composable
fun GenderScreen(modifier: Modifier, onSkip: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.purple)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.gender),
            contentDescription = "gender logo",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Card(
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(16.dp),

            ) {

            Column(
                modifier = Modifier.padding(10.dp).wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(id = R.string.gender_screen_heading),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold
                )

            }

            Text(
                text = stringResource(id = R.string.gender_screen_description),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.black),
            )

            GenderToggle()

            ClickableText(
                text = AnnotatedString(stringResource(id = R.string.gender_screen_skip)),
                onClick = {onSkip.invoke()},

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.gray),
                    fontWeight = FontWeight.Bold
                ),


                )


        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGenderScreen() {
    GenderScreen(modifier = Modifier.fillMaxSize(), onSkip = {})
}


@Composable
fun GenderToggle() {
    var isGenderManSelected by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { isGenderManSelected = true },
            modifier = Modifier
                .weight(1f)
                .padding(top = 20.dp, bottom = 20.dp, start = 20.dp, end = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = (if (isGenderManSelected) colorResource(id = R.color.purple) else Color.White),
                contentColor = (if (isGenderManSelected) Color.White else Color.Black
                        )
            )

        ) {
            Text(
                text = "Men",
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }

        Button(
            onClick = { isGenderManSelected = false },
            modifier = Modifier
                .weight(1f)
                .padding(top = 20.dp, bottom = 20.dp, start = 8.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = (if (isGenderManSelected) Color.White else colorResource(id = R.color.purple)),
                contentColor = (if (isGenderManSelected) Color.Black else Color.White
                        )
            )
        ) {
            Text(
                text = "Women",
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
