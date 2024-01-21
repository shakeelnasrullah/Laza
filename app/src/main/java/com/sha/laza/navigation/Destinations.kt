package com.sha.laza.navigation

sealed class Destinations(val route: String) {
    object Splash : Destinations("splash")
    object Gender : Destinations("gender")
    object Home : Destinations("home")
    object SignUp : Destinations("sign_up")
    object SignIn : Destinations("sign_in")
    object ForgotPassword : Destinations("forgot_password")
    object Player : Destinations("player")
    object SocialLogin : Destinations("socialLogin")
    object Instructions : Destinations("instructions")
    object Test : Destinations("test")
    object TimeUp : Destinations("time-up")
}