package com.example.cryptomarket.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorPalette = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val StocksDarkColorScheme = darkColorScheme(
    background = StocksDarkBackground,
    onBackground = StocksDarkPrimaryText,
    surface = StocksDarkBackground,
    surfaceVariant = StocksDarkSelectedChip,
    onSurfaceVariant = StocksDarkPrimaryText,
    primary = StocksDarkBackground,
    secondary = StocksDarkBackground,
    tertiary = StocksDarkSelectedCard,
    onSurface = StocksDarkPrimaryText,
    onPrimaryContainer = StocksDarkPrimaryText,
    primaryContainer = StocksDarkSelectedCard,
    onSecondaryContainer = StocksDarkSecondaryText
)

@Composable
fun CryptoMarketTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit) {

    val colorScheme = when{
        dynamicColor && Build.VERSION.SDK_INT > Build.VERSION_CODES.S-> {
            val context = LocalContext.current
            if(darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme-> StocksDarkColorScheme
        else -> LightColorPalette
    }

    val view = LocalView.current

    if(!view.isInEditMode){
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.primary.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}