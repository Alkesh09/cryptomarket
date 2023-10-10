package com.example.cryptomarket.util

import android.os.Parcelable
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.cryptomarket.R


//sealed class Screen : Parcelable {
//
//    @Parcelize
//    object CoinList : Screen()
//
//    @Parcelize
//    object FavouriteCoinList : Screen()
//
//    @Parcelize
//    object Search : Screen()
//}

enum class BottomNavigationItem(val route: String, val icon: ImageVector, @StringRes val title: Int) {
    Market(
        route = "market",
        icon = Icons.Default.KeyboardArrowUp,
        title = R.string.market
    ),
    Favourites(
        route = "favourite",
        icon = Icons.Default.Star,
        title = R.string.favorite
    ),
    Search(
        route = "search",
        icon = Icons.Default.Search,
        title = R.string.search
    )
}