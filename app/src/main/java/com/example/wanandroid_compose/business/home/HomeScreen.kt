package com.example.wanandroid_compose.business.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

@Composable
fun HomeScreen() {
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(), text = "hello this is homescreen", textAlign = TextAlign.Center
        )
    }

}