package com.example.wanandroid_compose.business.mine.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wanandroid_compose.R

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

@Composable
fun MineInfo(modifier: Modifier = Modifier) {

}

@Composable
fun MineInfoItem(modifier: Modifier = Modifier, text: String, @DrawableRes id: Int, onItemClicked: () -> Unit) {
    Box(
        modifier
            .clickable {
                onItemClicked.invoke()
            }
            .padding(10.dp)
            .fillMaxWidth()
            .height(30.dp)
    ) {

        Icon(
            painter = painterResource(id = id), contentDescription = "", modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 3.dp)
                .size(20.dp)
        )
        Text(
            text = text, color = Color.Black, modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 30.dp)
        )
        Text(
            text = ">", color = Color.Gray, modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
        )
    }
}

@Preview
@Composable
fun MineInfoItemPreview() {
    MineInfoItem(text = "我的积分", id = R.mipmap.ic_jifen) {
    }
}