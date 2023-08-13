package com.example.wanandroid_compose.initializer

import android.content.Context
import android.util.Log
import androidx.annotation.Keep
import androidx.startup.Initializer
import com.example.wanandroid_compose.util.DataStoreUtils

/**
 * @author:ztaiwang
 * @date:2023/8/13
 */
@Keep
class DataStoreInitializer : Initializer<Boolean> {

    override fun create(context: Context): Boolean {
        Log.i("初始化", "初始化DataStore")
        DataStoreUtils.init(context)
        return true
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}