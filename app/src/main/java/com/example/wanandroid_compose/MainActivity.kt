package com.example.wanandroid_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wanandroid_compose.nav.MainNavBottom
import com.example.wanandroid_compose.nav.MainNavHost
import com.example.wanandroid_compose.nav.bottomNavScreenList
import com.example.wanandroid_compose.nav.findFirstMatchIndex
import com.example.wanandroid_compose.nav.navigateSingleTopTo
import com.example.wanandroid_compose.ui.theme.WanandroidComposeTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

//TODO:迁移成MVI单向数据流
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WanandroidComposeTheme {
                ProvideWindowInsets {
                    val systemUiController = rememberSystemUiController()
                    SideEffect {
                        systemUiController.setStatusBarColor(Color.Transparent, darkIcons = false)
                    }
                }
                MainApp()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainApp() {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination

        val currentSelectIndex = bottomNavScreenList.findFirstMatchIndex(currentDestination?.route ?: "")

        Scaffold(bottomBar = {
            MainNavBottom(
                selectedIndex = currentSelectIndex,
                onBottomItemClicked = { _, screen -> navController.navigateSingleTopTo(screen.route) })
        }) {
            MainNavHost(navController, Modifier.padding(it))
        }
    }

}