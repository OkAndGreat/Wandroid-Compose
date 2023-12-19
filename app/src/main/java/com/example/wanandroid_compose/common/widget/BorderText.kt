package com.example.wanandroid_compose.common.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @Author: wangzhongtai
 * @Time: 2023/12/19
 * @Description:
 */
@Composable
fun BorderText(
    text: String,
    borderColor: Color,
    cornerRadius: Dp,
    padding: Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(cornerRadius))
            .padding(padding)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(padding),
            color = borderColor
        )
    }
}