package com.example.wanandroid_compose.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanandroid_compose.network.ApiException
import com.example.wanandroid_compose.util.LogUtil
import com.example.wanandroid_compose.util.requestFlow
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author:ztaiwang
 * @date:2023/8/12
 */
open class BaseViewModel : ViewModel() {

    companion object {
        const val TAG = "BaseViewModel"
    }

    /**
     * @param responseBlock 负责具体请求的代码块
     * @param errorBlock 发生异常时的通知
     * @param notifyLoading 通知正在请求 -> true,请求成功或者请求失败 -> false
     */
    suspend fun <T> requestWithCoroutine(
        responseBlock: suspend () -> BaseResponse<T>?,
        errorBlock: (Throwable) -> (Unit),
        notifyLoading: (Boolean) -> Unit
    ): T? {
        var data: T? = null

        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            errorBlock.invoke(exception)
            LogUtil.e(TAG, "requestFailed with e:$exception")
        }
        notifyLoading.invoke(true)

        withContext(Dispatchers.IO + exceptionHandler) {
            val response = responseBlock()
            if (response?.isFailed() == true) {
                throw ApiException(response.errorCode, response.errorMsg)
            }
            data = response?.data
        }
        notifyLoading.invoke(false)
        return data
    }

    /**
     * @param responseBlock 负责具体请求的代码块
     * @param errorBlock 发生异常时的通知
     * @param notifyLoading 通知正在请求 -> true,请求成功或者请求失败 -> false
     */
    fun <T> requestWithFlow(
        responseBlock: suspend () -> BaseResponse<T>?,
        errorBlock: (Throwable) -> (Unit),
        notifyLoading: (Boolean) -> Unit
    ): T? {
        var data: T? = null

        viewModelScope.launch(Dispatchers.Main) {
            data = requestFlow(requestCall = responseBlock, errorBlock = errorBlock, showLoading = notifyLoading)
        }

        return data
    }

}