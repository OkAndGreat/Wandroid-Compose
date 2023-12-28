package com.example.wanandroid_compose.business.home.widget

import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.LazyPagingItems
import com.example.wanandroid_compose.GlobalViewModel
import com.example.wanandroid_compose.bean.homeArticle.HomeArticle
import com.example.wanandroid_compose.nav.BottomNavScreen
import kotlinx.coroutines.launch


/**
 * @author:ztaiwang
 * @date:2023/8/14
 */

@Composable
fun HomeFeedListWidget(modifier: Modifier = Modifier, homeFeedList: LazyPagingItems<HomeArticle>) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val globalViewModel: GlobalViewModel? = GlobalViewModel.get(context)
    LazyColumn(
        modifier.fillMaxWidth(),
        state = globalViewModel?.homeListState ?: rememberLazyListState()
    ) {
        items(homeFeedList.itemCount) { index ->
            HomeFeedItem(item = homeFeedList[index],
                onCollectClicked = {
                    scope.launch {
                        Toast.makeText(context, "点击了收藏", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                onItemClicked = {
                    val url = it?.link ?: ""
                    val encodeUrl = Uri.encode(url)
                    val navController = globalViewModel?.navController
                    navController?.navigate("${BottomNavScreen.WebViewScreen.route}/$encodeUrl")
                })
        }
    }

}

@Preview
@Composable
fun HomeFeedListPreview() {

}