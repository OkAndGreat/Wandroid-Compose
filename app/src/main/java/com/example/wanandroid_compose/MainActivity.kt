package com.example.wanandroid_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wanandroid_compose.nav.BottomNavScreen
import com.example.wanandroid_compose.nav.MainNavBottom
import com.example.wanandroid_compose.nav.NavigationHost
import com.example.wanandroid_compose.nav.bottomNavScreenList
import com.example.wanandroid_compose.nav.findFirstMatchIndex
import com.example.wanandroid_compose.nav.navigateSingleTopTo
import com.example.wanandroid_compose.ui.theme.WanandroidComposeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WanandroidComposeTheme {
                // Remember a SystemUiController
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()

                DisposableEffect(systemUiController, useDarkIcons) {
                    // Update all of the system bar colors to be transparent, and use
                    // dark icons if we're in light theme
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = useDarkIcons
                    )
                    // setStatusBarColor() and setNavigationBarColor() also exist

                    onDispose {}
                }
                MainApp()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainApp() {
        val globalViewModel: GlobalViewModel? = GlobalViewModel.get(LocalContext.current)

        val navController = rememberNavController()
        globalViewModel?.navController = navController
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination

        val currentSelectIndex =
            bottomNavScreenList.findFirstMatchIndex(currentDestination?.route ?: "")

        if (isMainScreen(currentDestination?.route)) {
            Scaffold(bottomBar = {
                MainNavBottom(
                    selectedIndex = currentSelectIndex,
                    onBottomItemClicked = { _, screen -> navController.navigateSingleTopTo(screen.route) })
            }) {
                NavigationHost(navController, Modifier.padding(it))
            }
        } else {
            NavigationHost(navController)
        }
    }

    private val mainScreenRouteList =
        mutableListOf<String>(BottomNavScreen.HomeScreen.route, BottomNavScreen.MineScreen.route)

    private fun isMainScreen(route: String?) = mainScreenRouteList.contains(route)

}