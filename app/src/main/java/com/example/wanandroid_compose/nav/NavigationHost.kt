package com.example.wanandroid_compose.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wanandroid_compose.business.home.widget.HomeScreen
import com.example.wanandroid_compose.business.mine.widget.MineScreen
import com.example.wanandroid_compose.business.score.widget.ScoreScreen
import com.example.wanandroid_compose.business.webview.WebViewScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

/**
 * @author:ztaiwang
 * @date:2023/8/9
 */
@Composable
fun NavigationHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavScreen.HomeScreen.route,
        modifier = modifier
    ) {

        composable(route = BottomNavScreen.HomeScreen.route) {
            HomeScreen()
        }

        composable(route = BottomNavScreen.MineScreen.route) {
            MineScreen()
        }

        composable(
            route = "${BottomNavScreen.WebViewScreen.route}/{${BottomNavScreen.WebViewScreen.urlStringArg}}",
            arguments = BottomNavScreen.WebViewScreen.arguments
        ) {
            val webUrl = it.arguments?.getString(BottomNavScreen.WebViewScreen.urlStringArg)
                ?: return@composable
            WebViewScreen(webUrl = webUrl)
        }

        composable(route = BottomNavScreen.ScoreScreen.route) {
            ScoreScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }