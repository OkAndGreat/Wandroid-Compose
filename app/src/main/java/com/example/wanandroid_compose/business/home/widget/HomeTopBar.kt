package com.example.wanandroid_compose.business.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author:ztaiwang
 * @date:2023/8/13
 */
@Composable
fun HomeTopBar(modifier: Modifier = Modifier, onSearchIconClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = "首页", color = Color.White, fontSize = 18.sp, modifier = Modifier
            .align(Alignment.Center)
            .padding(5.dp)
            , textAlign = TextAlign.Center)
        Icon(
            imageVector = Icons.Default.Search, contentDescription = "", modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable {
                    onSearchIconClicked.invoke()
                }
                .padding(end = 8.dp), tint = Color.White
        )
    }
}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar(onSearchIconClicked = {})
}