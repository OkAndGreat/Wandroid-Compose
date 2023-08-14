package com.example.wanandroid_compose.business.home.widget

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wanandroid_compose.business.home.HomeViewModel

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = viewModel()
    homeViewModel.getHomeFeedList()
    val homeFeedList = homeViewModel.homeFeedList
    HomeFeedListWidget(homeFeedList = homeFeedList ?: emptyList())
}