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
        return try {
            val rsp = api?.getHomeArticle(currentKey)
                ?: throw IllegalStateException("API service is null")
            val datas = rsp.data?.datas ?: listOf()
            val endOfPaginationReached = currentKey + 1 >= (rsp.data?.pageCount ?: 0)
            LoadResult.Page(
                data = datas,
                prevKey = if (currentKey == 0) null else currentKey - 1,
                nextKey = if (endOfPaginationReached) null else currentKey + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}