package com.example.wanandroid_compose

import android.app.Activity
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController

/**
 * @Author: wangzhongtai
 * @Time: 2023/12/19
 * @Description:
 */
class GlobalViewModel : ViewModel() {

    companion object {
        fun get(context: Context): GlobalViewModel? {
            (context as? ComponentActivity)?.apply {
                return ViewModelProvider(this).get(GlobalViewModel::class.java)
            }
            return null
        }

    }

    var navController: NavController? = null

    var homeListState: LazyListState = LazyListState()

}