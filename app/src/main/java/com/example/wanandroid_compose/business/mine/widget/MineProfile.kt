package com.example.wanandroid_compose.business.mine.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wanandroid_compose.R

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

@Composable
fun MineProfile(modifier: Modifier = Modifier, isLogin: Boolean, userName: String = "") {
    Column(
        modifier
            .fillMaxWidth()
            .height(Dp(300F))
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 50.dp)
                .size(100.dp)
                .clip(
                    RoundedCornerShape(100.dp)
                )
        )

        if (!isLogin) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 10.dp),
                text = "去登陆",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.White
            )
        } else {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 8.dp),
                text = userName,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = Color.White
            )
        }

    }
}

@Preview
@Composable
fun MineProfilePreview() {
    MineProfile(isLogin = false)
}