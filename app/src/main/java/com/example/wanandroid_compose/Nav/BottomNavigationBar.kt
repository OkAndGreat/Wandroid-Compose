package com.example.wanandroid_compose.Nav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

private val bottomNavScreenList = listOf(BottomNavScreen.HomeScreen, BottomNavScreen.MineScreen)

@Composable
fun MainNavBottom(modifier: Modifier = Modifier, onBottomItemClicked: (Int, BottomNavScreen) -> (Unit)) {
    Row(modifier) {
        bottomNavScreenList.forEachIndexed() { index, screen ->
            MainNavBottomItem(
                id = screen.id,
                text = stringResource(id = screen.resourceId),
                modifier = Modifier.weight(1F),
                onItemClicked = {
                    onBottomItemClicked(index, screen)
                }
            )
        }
    }
}

@Composable
fun MainNavBottomItem(
    modifier: Modifier = Modifier,
    id: Int,
    text: String,
    isSelected: Boolean = false,
    onItemClicked: () -> (Unit) = {}
) {
    Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        Icon(
            painter = painterResource(id = id), contentDescription = "", tint = if (isSelected) Color.Blue else Color.Black, modifier = Modifier.size(
                Dp(35F)
            )
        )
        Text(text = text, textAlign = TextAlign.Center, fontSize = 16.sp)
    }
}

@Preview
@Composable
fun MainNavBottomPreview() {
    MainNavBottom(onBottomItemClicked = { _, _ -> })
}

@Preview
@Composable
fun MainNavBottomItemPreview() {
    MainNavBottomItem(id = bottomNavScreenList[0].id, text = stringResource(id = bottomNavScreenList[0].resourceId))
}