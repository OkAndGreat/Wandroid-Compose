package com.example.wanandroid_compose.util

import com.example.wanandroid_compose.base.BaseResponse
import com.example.wanandroid_compose.network.ApiException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

/**
 * @author:ztaiwang
 * @date:2023/8/12
 */
/**
 * 通过flow执行请求，需要在协程作用域中执行
 * @param errorBlock 错误回调
 * @param requestCall 执行的请求
 * @param showLoading 开启和关闭加载框
 * @return 请求结果
 */
suspend fun <T> requestFlow(
    errorBlock: ((Throwable) -> Unit),
    requestCall: suspend () -> BaseResponse<T>?,
    showLoading: ((Boolean) -> Unit)? = null
): T? {
    var data: T? = null
    val flow = requestFlowResponse(errorBlock, requestCall, showLoading)
    flow.collect {
        data = it?.data
    }
    return data
}

/**
 * 通过flow执行请求，需要在协程作用域中执行
 * @param errorBlock 错误回调
 * @param requestCall 执行的请求
 * @param showLoading 开启和关闭加载框
 * @return Flow<BaseResponse<T>>
 */
suspend fun <T> requestFlowResponse(
    errorBlock: (Throwable) -> Unit,
    requestCall: suspend () -> BaseResponse<T>?,
    showLoading: ((Boolean) -> Unit)? = null
): Flow<BaseResponse<T>?> {
    val flow = flow {
        val response = requestCall()

        if (response?.isFailed() == true) {
            throw ApiException(response.errorCode, response.errorMsg)
        }
        emit(response)
    }.flowOn(Dispatchers.IO)
        .onStart {
            showLoading?.invoke(true)
        }
        .catch { e ->
            errorBlock.invoke(e)
        }
        .onCompletion {
            showLoading?.invoke(false)
        }
    return flow
}