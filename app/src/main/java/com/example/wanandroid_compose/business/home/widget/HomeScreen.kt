package com.example.wanandroid_compose.business.home.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wanandroid_compose.business.home.HomeViewModel

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = viewModel()
    SideEffect {
        homeViewModel.getHomeFeedList()
    }

    val feedList by homeViewModel.homeFeedList
    HomeFeedListWidget(homeFeedList = feedList)
}