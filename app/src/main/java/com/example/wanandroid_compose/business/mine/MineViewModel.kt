package com.example.wanandroid_compose.business.mine

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */
class MineViewModel : ViewModel() {

    private val _isLogin = mutableStateOf(false)
    val isLogin
        get() = _isLogin.value

    private val _userName = mutableStateOf<String>("")
    val userName
        get() = _userName.value
}