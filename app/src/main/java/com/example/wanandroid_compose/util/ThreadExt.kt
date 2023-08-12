package com.example.wanandroid_compose.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * @author:ztaiwang
 * @date:2023/8/12
 */
fun ui(block: () -> Unit) {
    if (ContextHelper.mainThread == Thread.currentThread()) {
        block()
    } else {
        ContextHelper.handler.post(block)
    }
}

fun ui(block: () -> Unit, delayMillis: Long) {
    if (delayMillis == 0L) {
        ui(block)
    } else {
        ContextHelper.handler.postDelayed(block, delayMillis)
    }
}

fun bg(block: () -> Unit) {
    ThreadManager.postBackgroundTask(block)
}


private object ContextHelper {
    val handler: Handler = Handler(Looper.getMainLooper())
    val mainThread: Thread = Looper.getMainLooper().thread
}

object ThreadManager {
    private const val THREAD_NUM = 4

    private val fixedThreadPool: ExecutorService = Executors.newFixedThreadPool(THREAD_NUM)

    fun postBackgroundTask(callback: () -> Unit) {
        fixedThreadPool.submit { callback.invoke() }
    }

    fun getWorkExecutorService(): ExecutorService {
        return fixedThreadPool
    }
}