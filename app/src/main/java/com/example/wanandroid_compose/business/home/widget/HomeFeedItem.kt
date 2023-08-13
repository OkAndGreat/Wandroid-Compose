package com.example.wanandroid_compose.business.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author:ztaiwang
 * @date:2023/8/13
 * 首页feed流item
 */

@Composable
fun HomeFeedItem(modifier: Modifier = Modifier, onItemClicked: () -> Unit) {
    Column(
        modifier = modifier
            .padding(start = 5.dp, end = 5.dp)
            .shadow(elevation = 1.dp, shape = RoundedCornerShape(5.dp))
            .height(100.dp)
            .fillMaxWidth()
            .clickable {
                onItemClicked.invoke()
            }
            .background(Color.White)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(top = 5.dp, start = 5.dp, end = 5.dp)
                .fillMaxWidth()
        ) {
            Text(text = "宏扬")
            Text(text = "2023-08-03 19:22")
        }

        Text(
            text = "赞助服务器续费，大家自由支持，感谢～他呀呀呜呜呜呜呜·打算的撒的", modifier = Modifier
                .padding(start = 5.dp, end = 8.dp)
                .fillMaxWidth(), maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(top = 5.dp, start = 5.dp, end = 5.dp)
                .fillMaxWidth()
        ) {
            Text(text = "原创文章")
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
        }
    }
}

@Preview
@Composable
fun HomeFeedItemPreview() {
    HomeFeedItem {

    }
}
