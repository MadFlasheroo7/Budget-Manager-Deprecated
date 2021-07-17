package com.example.budgetmanager.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DeepBlueTheme = lightColors(
    primary = DarkBlue800,
    primaryVariant = DarkBlue800,
    secondary = Teal500,
    onSecondary = DarkBlue500,
    background = DarkBlue500,
    onBackground = Color.White,
    surface = DarkBlue600,
    onSurface = Color.White

)

private val DeepPurpleTheme = lightColors(
    primary = DarkPurple800,
    primaryVariant = DarkPurple800,
    secondary = DarkPurple200,
    onSecondary = DarkPurple600,
    background = DarkPurple600,
    onBackground = Color.White,
    surface = DarkPurple700,
    onSurface = Color.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val DarkGrayTheme = lightColors(
    primary = DarkGrey900,
    primaryVariant = DarkGrey900,
    secondary = PastelGreen,
    onSecondary = DarkGrey700,
    background = DarkGrey700,
    onBackground = Color.White,
    surface = DarkGrey800,
    onSurface = Color.White

)

@Composable
fun BudgetManagerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    val colors = if (darkTheme) {
        DarkGrayTheme
    } else {
//        val systemUiController = rememberSystemUiController()
//        SideEffect {
//            systemUiController.setStatusBarColor(
//                color = DarkBlue500
//                color = DarkPurple600
//            )
//        }
        DeepBlueTheme
//        DeepPurpleTheme
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}