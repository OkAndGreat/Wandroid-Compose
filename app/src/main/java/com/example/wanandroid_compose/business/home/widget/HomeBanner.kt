package com.example.wanandroid_compose.business.home.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.wanandroid_compose.R
import kotlinx.coroutines.delay

/**
 * @author:ztaiwang
 * @date:2023/8/14
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeBanner(datas: List<Any>, modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        datas.size
    }

    Box(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(state = pagerState) {
            Image(
                painter = rememberAsyncImagePainter(model = datas[it]),
                contentDescription = "",
                modifier = Modifier
                    .align(
                        Alignment.Center
                    )
                    .fillMaxSize()
            )
        }

        // 指示器
        DotsIndicator(
            totalDots = datas.size,
            selectedIndex = pagerState.currentPage,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp)
        )
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // 3秒钟更换一次banner
            with(pagerState) {
                val nextPage = if (currentPage < pageCount - 1) currentPage + 1 else 0
                animateScrollToPage(nextPage)
            }
        }
    }

}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    activeDotColor: Color = Color.Blue,
    inactiveDotColor: Color = Color.Gray,
    dotSize: Dp = 8.dp,
    spacing: Dp = 8.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        for (index in 0 until totalDots) {
            Box(
                modifier = Modifier
                    .padding(horizontal = spacing / 2)
                    .size(dotSize)
                    .clip(shape = MaterialTheme.shapes.small)
                    .background(if (index == selectedIndex) activeDotColor else inactiveDotColor)
            )
        }
    }
}

@Preview
@Composable
fun HomeBannerPreView() {
    val datas = mutableListOf<Int>(
        R.drawable.dog,
        R.drawable.dog,
        R.drawable.dog,
    )

    HomeBanner(datas = datas)
}
