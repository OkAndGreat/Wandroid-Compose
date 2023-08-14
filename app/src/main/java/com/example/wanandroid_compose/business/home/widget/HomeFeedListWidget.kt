package com.example.wanandroid_compose.business.home.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.wanandroid_compose.bean.homeArticle.HomeArticle


/**
 * @author:ztaiwang
 * @date:2023/8/14
 */

@Composable
fun HomeFeedListWidget(modifier: Modifier = Modifier, homeFeedList: List<HomeArticle>) {
    val list by remember {
        mutableStateOf(homeFeedList)
    }
    LazyColumn(modifier.fillMaxWidth()) {
        itemsIndexed(list) { _, item ->
            HomeFeedItem {
                val url = item.link
                //TODO:jump to target page
            }
        }
    }

}

@Preview
@Composable
fun HomeFeedListPreview() {

}