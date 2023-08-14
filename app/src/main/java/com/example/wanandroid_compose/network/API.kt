package com.example.wanandroid_compose.network

import com.example.wanandroid_compose.base.BaseResponse
import com.example.wanandroid_compose.bean.homeArticle.HomeArticleList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author:ztaiwang
 * @date:2023/8/12
 */
interface API {
    /**
     * 获得首页普通文章数据
     * @param page
     * @return
     */
    @GET("/article/list/{page}/json")
    fun getHomeArticle(@Path("page") page: Int): Call<BaseResponse<HomeArticleList>>?
}