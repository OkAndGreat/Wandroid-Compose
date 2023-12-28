package com.example.wanandroid_compose.business.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import com.example.wanandroid_compose.base.BaseViewModel
import com.example.wanandroid_compose.bean.homeArticle.HomeArticle
import com.example.wanandroid_compose.network.RetrofitManager
import com.example.wanandroid_compose.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

/**
 * @author:ztaiwang
 * @date:2023/8/13
 */
class HomeViewModel : BaseViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }

    val articleList = fetchHomeArticleList().cachedIn(viewModelScope)

    fun fetchHomeArticleList(): Flow<PagingData<HomeArticle>> {
        return Pager(
            config = PagingConfig(pageSize = 30),
            pagingSourceFactory = {
                HomeArticleDataSource(RetrofitManager.getRetrofitApi())
            }
        ).flow
    }

}