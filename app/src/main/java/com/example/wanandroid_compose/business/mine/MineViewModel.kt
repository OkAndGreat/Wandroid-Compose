package com.example.wanandroid_compose.business.mine

import androidx.compose.runtime.mutableStateOf
import com.example.wanandroid_compose.base.BaseViewModel

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */
class MineViewModel : BaseViewModel() {

    private val _isLogin = mutableStateOf(false)
    val isLogin
        get() = _isLogin.value

    private val _userName = mutableStateOf("")
    val userName
        get() = _userName.value
}