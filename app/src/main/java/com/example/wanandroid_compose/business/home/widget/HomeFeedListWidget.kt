package com.example.wanandroid_compose.business.home.widget

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wanandroid_compose.GlobalViewModel
import com.example.wanandroid_compose.bean.homeArticle.HomeArticle
import com.example.wanandroid_compose.nav.BottomNavScreen
import kotlinx.coroutines.launch


/**
 * @author:ztaiwang
 * @date:2023/8/14
 */

@Composable
fun HomeFeedListWidget(modifier: Modifier = Modifier, homeFeedList: List<HomeArticle>) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val globalViewModel: GlobalViewModel? = GlobalViewModel.get(context)
    LazyColumn(modifier.fillMaxWidth()) {
        itemsIndexed(homeFeedList) { _, item ->
            HomeFeedItem(item = item,
                onCollectClicked = {
                    scope.launch {
                        Toast.makeText(context, "点击了收藏", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                onItemClicked = {
                    val url = item.link
                    val navController = globalViewModel?.navController
                    navController?.navigate(BottomNavScreen.MineScreen.route)
                })
        }
    }

}

@Preview
@Composable
fun HomeFeedListPreview() {

}