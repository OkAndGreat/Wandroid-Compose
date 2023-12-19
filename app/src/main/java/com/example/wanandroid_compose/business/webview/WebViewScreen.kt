package com.example.wanandroid_compose.business.webview

import android.content.Intent
import android.net.Uri
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

/**
 * @Author: wangzhongtai
 * @Time: 2023/12/19
 * @Description:
 */

@Composable
fun WebViewScreen(webUrl: String) {
    AndroidView(factory = {
        WebView(it).apply {
            settings.javaScriptEnabled = true
            loadUrl(webUrl)
        }
    }, update = { webView ->

        webView.loadUrl(webUrl)
    }
    )
}
