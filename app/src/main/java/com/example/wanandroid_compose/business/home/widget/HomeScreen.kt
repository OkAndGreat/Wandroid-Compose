package com.example.wanandroid_compose.business.home.widget

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.wanandroid_compose.business.home.HomeViewModel

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = viewModel()
    val articleList = homeViewModel.articleList.collectAsLazyPagingItems()
    HomeFeedListWidget(homeFeedList = articleList)
}