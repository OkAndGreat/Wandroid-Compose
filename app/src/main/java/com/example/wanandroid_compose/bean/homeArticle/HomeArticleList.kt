package com.example.wanandroid_compose.bean.homeArticle

data class HomeArticleList(
    val curPage: Int,
    val datas: List<HomeArticle>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)