package com.example.wanandroid_compose.business.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.wanandroid_compose.base.BaseViewModel
import com.example.wanandroid_compose.bean.homeArticle.HomeArticle
import com.example.wanandroid_compose.network.RetrofitManager
import com.example.wanandroid_compose.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author:ztaiwang
 * @date:2023/8/13
 */
class HomeViewModel : BaseViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }

    private val _homeFeedList = mutableStateOf<List<HomeArticle>>(emptyList())
    val homeFeedList: State<List<HomeArticle>> = _homeFeedList

    fun getHomeFeedList() {
        viewModelScope.launch(Dispatchers.Main) {
            val data = requestWithCoroutine(responseBlock = {
                val api = RetrofitManager.getRetrofitApi()
                val call = api?.getHomeArticle(0)
                call?.execute()?.body()
            }, errorBlock = {

            }, notifyLoading = {

            })
            data?.datas?.let {
                LogUtil.d(TAG, data.toString())
                _homeFeedList.value = it
            }
        }
    }
}