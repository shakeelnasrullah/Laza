package com.sha.laza.navigation

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sha.laza.presentation.forgotpassword.ForgotPasswordScreen
import com.sha.laza.presentation.gender.GenderScreen
import com.sha.laza.presentation.player.PlayerScreen
import com.sha.laza.presentation.signin.SignInScreen
import com.sha.laza.presentation.signup.SignUpScreen
import com.sha.laza.presentation.socialplatforms.SocialPlatformScreen
import com.sha.laza.presentation.splash.SplashScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.Splash.route
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        splashGraph(navController)
        genderGraph(navController)
        signUpGraph(navController)
        signInGraph(navController)
        forgotPasswordGraph(navController)
        socialLogin(navController)
        player(navController)
        instructionsGraph(navController)
        testGraph(navController)
        timeUpGraph(navController)
    }
}

fun NavGraphBuilder.splashGraph(navController: NavController) {
    composable(Destinations.Splash.route) {
        SplashScreen(
            modifier = Modifier.fillMaxSize(),

            goToGender = {
                navController.navigate(
                    route = Destinations.Gender.route
                )
            })
    }
}


fun NavGraphBuilder.signUpGraph(navController: NavController) {
    composable(Destinations.SignUp.route) {
        SignUpScreen(modifier = Modifier.fillMaxSize(), onBack = {
            navController.navigateUp()
        }, signUpClick = {
            navController.navigate(route = Destinations.SignIn.route)
        })
    }
}

fun NavGraphBuilder.player(navController: NavController) {
    composable(Destinations.Player.route) {
        PlayerScreen(modifier = Modifier.fillMaxSize())
    }
}

fun NavGraphBuilder.signInGraph(navController: NavController) {
    composable(Destinations.SignIn.route) {
        SignInScreen(modifier = Modifier.fillMaxSize(), onBack = {
            navController.navigateUp()
        }, signInClicked = {
            navController.navigate(route = Destinations.ForgotPassword.route)
        })
    }
}

fun NavGraphBuilder.forgotPasswordGraph(navController: NavController) {
    composable(Destinations.ForgotPassword.route) {
        ForgotPasswordScreen(modifier = Modifier.fillMaxSize(), onBack = {
            navController.navigateUp()
        }, onConfirm = {})
    }
}

fun NavGraphBuilder.socialLogin(navController: NavController) {
    composable(Destinations.SocialLogin.route) {
        SocialPlatformScreen(modifier = Modifier.fillMaxSize(), goToSignUp = {
            navController.navigate(route = Destinations.SignUp.route)
        },
            goToPlayer = {
                navController.navigate(Destinations.Player.route)
            })
    }
}

fun NavGraphBuilder.instructionsGraph(navController: NavController) {
    composable(Destinations.Instructions.route) {
        /*InstructionsScreen(modifier = Modifier.fillMaxSize(), onBack = {
            navController.navigateUp()
        })*/
    }
}


fun NavGraphBuilder.genderGraph(navController: NavController) {
    composable(Destinations.Gender.route) {
        GenderScreen(modifier = Modifier.fillMaxSize(),
            onSkip = {
                navController.navigate(
                    route = Destinations.SocialLogin.route
                )
            })
    }
}

fun NavGraphBuilder.testGraph(navController: NavController) {
    composable(Destinations.Test.route) {
        /*TestScreen(modifier = Modifier.fillMaxSize(), onBack = {
            navController.navigateUp()
        })*/
    }
}

fun NavGraphBuilder.timeUpGraph(navController: NavController) {
    composable(Destinations.TimeUp.route) {/*
        TimeUpScreen(modifier = Modifier.fillMaxSize(), onBack = {
            navController.navigateUp()
        })*/
    }
}

fun NavController.navigate(
    route: String,
    args: Bundle,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    val routeLink =
        NavDeepLinkRequest.Builder.fromUri(NavDestination.createRoute(route).toUri()).build()
    val deepLinkMatch = graph.matchDeepLink(routeLink)
    if (deepLinkMatch != null) {
        val destination = deepLinkMatch.destination
        val id = destination.id
        navigate(id, args, navOptions, navigatorExtras)
    } else {
        navigate(route, navOptions, navigatorExtras)
    }
}

fun <T> NavBackStackEntry.parcelableData(key: String): T? {
    return arguments?.getParcelable(key) as? T
}