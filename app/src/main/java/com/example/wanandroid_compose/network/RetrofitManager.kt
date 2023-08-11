package com.example.wanandroid_compose.network

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author:ztaiwang
 * @date:2023/8/11
 */
object RetrofitManager {
    private var retrofit: Retrofit? = null
    private val cookieStore = HashMap<String, List<Cookie>>()

    private const val CONNECT_TIME_OUT = 10 * 1000L
    const val READ_TIMEOUT_MILLIS = 15 * 1000L
    const val WRITE_TIMEOUT_MILLIS = 20 * 1000L
    private const val PlayAndroid_URL = "https://example.com/"

    private val loggerIntercept = HttpLoggingInterceptor { }.apply {
//        setlevel用来设置日志打印的级别，共包括了四个级别：NONE,BASIC,HEADER,BODY
//        BASEIC:请求/响应行
//        HEADER:请求/响应行 + 头
//        BODY:请求/响应行 + 头 + 体
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    fun getRetrofit(): Retrofit? {
        return retrofit
    }

    fun initRetrofit() {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .cookieJar(object : CookieJar {
                override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                    cookieStore[url.host] = cookies
                }

                override fun loadForRequest(url: HttpUrl): List<Cookie> {
                    val cookies = cookieStore[url.host]
                    return cookies ?: ArrayList()
                }
            })
            .addInterceptor(loggerIntercept)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(PlayAndroid_URL)
            // 设置请求的client
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}