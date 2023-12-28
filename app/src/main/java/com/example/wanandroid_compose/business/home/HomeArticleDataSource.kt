package com.example.wanandroid_compose.business.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wanandroid_compose.bean.homeArticle.HomeArticle
import com.example.wanandroid_compose.network.API

/**
 * @Author: wangzhongtai
 * @Time: 2023/12/28
 * @Description:
 */
class HomeArticleDataSource(private val api: API?) : PagingSource<Int, HomeArticle>() {
    override fun getRefreshKey(state: PagingState<Int, HomeArticle>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeArticle> {
        val currentKey = params.key ?: 0
        val rsp = api?.getHomeArticle(currentKey)
        val datas = rsp?.data?.datas ?: listOf()
        return LoadResult.Page(
            data = datas,
            prevKey = if (currentKey == 0) null else currentKey - 1,
            nextKey = if (currentKey == rsp?.data?.pageCount) null else currentKey + 1
        )
    }
}