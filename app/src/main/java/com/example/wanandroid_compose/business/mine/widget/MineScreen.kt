package com.example.wanandroid_compose.business.mine.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
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
        MineProfile(isLogin = mineScreenViewModel.isLogin, userName = mineScreenViewModel.userName)
        MineInfo()
    }
}