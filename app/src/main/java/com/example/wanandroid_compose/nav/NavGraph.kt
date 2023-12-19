package com.example.wanandroid_compose.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.wanandroid_compose.R

/**
 * @author:ztaiwang
 * @date:2023/8/9
 */
sealed class BottomNavScreen(
    val route: String,
    @StringRes val resourceId: Int? = -1,
    @DrawableRes val id: Int? = -1
) {
    object HomeScreen : BottomNavScreen("home", R.string.bottom_home, R.mipmap.nav_home)
    object MineScreen : BottomNavScreen("mine", R.string.bottom_mine, R.mipmap.nav_mine)
    object WebViewScreen : BottomNavScreen("webview")
}