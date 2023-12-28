package com.example.wanandroid_compose.business.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wanandroid_compose.bean.homeArticle.HomeArticle
import com.example.wanandroid_compose.common.widget.BorderText
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * @author:ztaiwang
 * @date:2023/8/13
 * 首页feed流item
 */

@Composable
fun HomeFeedItem(
    modifier: Modifier = Modifier,
    item: HomeArticle? = null,
    onItemClicked: ((item: HomeArticle?) -> Unit)? = null,
    onCollectClicked: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
            .shadow(elevation = (1.5).dp, shape = RoundedCornerShape(5.dp))
            .height(100.dp)
            .fillMaxWidth()
            .clickable {
                onItemClicked?.invoke(item)
            }
            .background(Color.White)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(top = 5.dp, start = 5.dp, end = 5.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = item?.shareUser ?: "宏扬",
                style = TextStyle(color = Color.Gray, fontSize = 11.sp)
            )
            Text(
                text = item?.publishTime?.formatTimestamp() ?: "2023-08-03 19:22",
                style = TextStyle(color = Color.Gray, fontSize = 11.sp)
            )
        }

        Text(
            text = item?.title ?: "赞助服务器续费，大家自由支持，感谢～他呀呀呜呜呜呜呜·打算的撒的",
            modifier = Modifier
                .padding(start = 5.dp, end = 8.dp, top = 25.dp)
                .fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(bottom = 5.dp, start = 5.dp, end = 5.dp)
                .fillMaxWidth()
                .align(Alignment.BottomEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BorderText(
                text = item?.superChapterName ?: "原创文章",
                borderColor = Color.Red,
                cornerRadius = 8.dp,
                padding = 2.dp
            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier.clickable(
                    indication = null,
                    onClick = { onCollectClicked?.invoke() },
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                )
            )
        }
    }
}

fun Long?.formatTimestamp(): String {
    val DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm"
    val dateFormat = SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault())
    val date = this?.let { Date(it) }
    return dateFormat.format(date)
}

@Preview
@Composable
fun HomeFeedItemPreview() {
    HomeFeedItem() {

    }
}
