package com.example.wanandroid_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wanandroid_compose.Nav.MainNavBottom
import com.example.wanandroid_compose.Nav.MainNavHost
import com.example.wanandroid_compose.Nav.navigateSingleTopTo
import com.example.wanandroid_compose.ui.theme.WanandroidComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WanandroidComposeTheme {
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

        Scaffold(bottomBar = { MainNavBottom(onBottomItemClicked = { _, screen -> navController.navigateSingleTopTo(screen.route) }) }) {
            MainNavHost(navController, Modifier.padding(it))
        }
    }

}