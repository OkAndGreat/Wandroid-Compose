package com.example.wanandroid_compose.business.home.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.wanandroid_compose.business.home.HomeViewModel

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = viewModel()
    val inRefresh by remember {
        mutableStateOf(false)
    }
    val articleList = homeViewModel.articleList.collectAsLazyPagingItems()
    val pullRefreshState =
        rememberPullRefreshState(refreshing = inRefresh, onRefresh = {
            articleList.refresh()
        })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val datas = mutableListOf<String>(
                "https://img-home.csdnimg.cn/images/20201124032511.png",
                "https://img-home.csdnimg.cn/images/20201124032511.png",
                "https://img-home.csdnimg.cn/images/20201124032511.png"
            )
            HomeBanner(datas = datas, modifier = Modifier.height(120.dp))

            HomeFeedListWidget(homeFeedList = articleList)
        }

        PullRefreshIndicator(
            refreshing = inRefresh, state = pullRefreshState, Modifier.align(
                Alignment.TopCenter
            )
        )
    }

}