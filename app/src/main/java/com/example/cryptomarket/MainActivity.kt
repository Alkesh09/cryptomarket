package com.example.cryptomarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cryptomarket.ui.theme.CryptoMarketTheme
import com.example.cryptomarket.ui.theme.StocksDarkPrimaryText
import com.example.cryptomarket.ui.theme.StocksDarkSelectedCard
import com.example.cryptomarket.ui.theme.StocksDarkTopAppBarCollapsed
import com.example.cryptomarket.util.BottomNavigationItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val backStackEntry = navController.currentBackStackEntryAsState()

            var currentDestination by remember {
                mutableStateOf(BottomNavigationItem.Market.route)
            }

            CryptoMarketTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    bottomBar = {
                        NavigationBar(
                            containerColor = StocksDarkTopAppBarCollapsed
                        ) {
                            BottomNavigationItem.values().forEach { item ->
                                NavigationBarItem(
                                    selected = item.route == currentDestination,
                                    icon = { Icon(item.icon, contentDescription = stringResource(id = item.title)) },
                                    label = { Text(text = stringResource(id = item.title))},
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = StocksDarkPrimaryText,
                                        indicatorColor = StocksDarkSelectedCard
                                    ),
                                    onClick = {
                                        navController.navigate(item.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) {
                    Surface(modifier = Modifier.padding(it)) {
                        NavHost(navController = navController, startDestination = currentDestination){
                            composable(BottomNavigationItem.Market.route){ }
                            composable(BottomNavigationItem.Favourites.route){ }
                            composable(BottomNavigationItem.Search.route){ }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoMarketTheme {
        Greeting("Android")
    }
}