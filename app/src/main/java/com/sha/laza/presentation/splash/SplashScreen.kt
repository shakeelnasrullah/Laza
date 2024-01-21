package com.sha.laza.presentation.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sha.laza.R
import com.sha.laza.navigation.AppNavHost
import com.sha.laza.navigation.Destinations
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier, goToGender: () -> Unit) {
    // Add your splash screen UI elements here
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.purple)),
        contentAlignment = Alignment.Center,

    ) {
        // You can customize this image as per your design
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
        )
    }

    // Wait for a few seconds and then navigate to the main content
    LaunchedEffect(key1 = true) {
        delay(3000) // Adjust the delay time as needed
        goToGender.invoke()
    }
}

@Preview(uiMode =   UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkSplashScreen(){
    SplashScreen(Modifier.fillMaxSize(),  goToGender = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen(){
    SplashScreen(Modifier.fillMaxSize(), goToGender = {})
}
   
    
