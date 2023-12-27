package com.example.wanandroid_compose.util

import android.util.Log
import com.example.wanandroid_compose.BuildConfig

/**
 * @author:ztaiwang
 * @date:2023/8/10
 */
object LogUtil {

    // 控制是否要输出log
    private var sIsRelease = BuildConfig.DEBUG == false

    fun d(TAG: String, content: String) {
        if (!sIsRelease) {
            Log.d(TAG, content)
        }
    }

    fun v(TAG: String, content: String) {
        if (!sIsRelease) {
            Log.d(TAG, content)
        }
    }

    fun i(TAG: String, content: String) {
        if (!sIsRelease) {
            Log.d(TAG, content)
        }
    }

    fun w(TAG: String, content: String) {
        if (!sIsRelease) {
            Log.d(TAG, content)
        }
    }

    fun e(TAG: String, content: String) {
        if (!sIsRelease) {
            Log.d(TAG, content)
        }
    }
}