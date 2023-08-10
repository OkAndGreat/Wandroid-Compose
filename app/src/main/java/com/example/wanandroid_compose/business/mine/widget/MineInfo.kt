package com.example.wanandroid_compose.business.mine.widget

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wanandroid_compose.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

data class MineInfoBean(val text: String, @DrawableRes val id: Int)

private val mineInfoInfoList = listOf(
    MineInfoBean("我的积分", R.mipmap.ic_jifen),
    MineInfoBean("我的收藏", R.mipmap.ic_collect),
    MineInfoBean("关于作者", R.mipmap.ic_web),
    MineInfoBean("系统设置", R.mipmap.ic_shezhi)
)

@Composable
fun MineInfo(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val coroutineScope = rememberCoroutineScope()
    Column(modifier) {
        mineInfoInfoList.forEachIndexed() { index, info ->
            MineInfoItem(text = info.text, id = info.id, onItemClicked = {
                when (index) {
                    0 -> {
                        coroutineScope.launch {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
                            }
                        }

                    }

                    1 -> {
                        coroutineScope.launch {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    2 -> {
                        coroutineScope.launch {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    3 -> {
                        coroutineScope.launch {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            })
        }
    }
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
        Image(
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

@Preview
@Composable
fun MineInfoPreview() {
    MineInfo()
}