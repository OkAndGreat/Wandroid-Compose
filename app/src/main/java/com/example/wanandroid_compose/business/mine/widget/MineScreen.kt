package com.example.wanandroid_compose.business.mine.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wanandroid_compose.business.mine.MineViewModel

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */

@Composable
fun MineScreen() {
    val mineScreenViewModel: MineViewModel = viewModel()
    Column {
        MineProfile(isLogin = mineScreenViewModel.isLogin, userName = mineScreenViewModel.userName) {
            //TODO:进去登陆注册页面进行登陆注册
        }
        MineInfo()
    }
}

@Preview
@Composable
fun MineScreenPreview() {
    MineScreen()
}