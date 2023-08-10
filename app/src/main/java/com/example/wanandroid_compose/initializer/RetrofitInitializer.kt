package com.example.wanandroid_compose.initializer

import android.content.Context
import androidx.startup.Initializer
import com.example.wanandroid_compose.network.RetrofitManager
import com.example.wanandroid_compose.util.LogUtil
import java.lang.Exception

/**
 * @author:ztaiwang
 * @date:2023/8/11
 */
class RetrofitInitializer : Initializer<Boolean> {
    companion object {
        const val TAG = "RetrofitInitializer"
    }

    override fun create(context: Context): Boolean {
        var result = false
        try {
            RetrofitManager.initRetrofit()
            result = true
        } catch (e: Exception) {
            LogUtil.e(TAG, "e:${e} RetrofitInitializer failed!!")
        }

        return result
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}