package com.jainamj.myapplication.data.api

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.jainamj.myapplication.base.mvp.WebViewInterface
import org.jetbrains.anko.email
import org.jetbrains.anko.makeCall
import timber.log.Timber

open class MyWebViewClient(var webViewInterface: WebViewInterface, var context: Context) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
        Timber.e("shouldOverrideUrlLoading url: " + url)
        handleUrl(view, url!!)
        return true
    }

    @TargetApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest?): Boolean {
        Timber.e("shouldOverrideUrlLoading N url: " + request?.url.toString())
        handleUrl(view, request?.url.toString())
        return true
    }

    private fun handleUrl(view: WebView, url: String) {
        when {
            url.startsWith("mailto:") -> {
                val address = url.substringAfter("mailto:")
                Timber.e("add: " + address)
                with(context) {
                    email(address)
                }
            }
            url.startsWith("tel:") -> {
                val number = url.substringAfter("tel:")
                Timber.e("num: " + number)
                with(context) {
                    makeCall(number)
                }
            }
            else -> view.loadUrl(url)
        }
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        Timber.e("onPageStarted " + url)
        webViewInterface.showProgressBar()
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        Timber.e("onPageFinished url: " + url)
        hideProgressBar()
        super.onPageFinished(view, url)
    }

    @TargetApi(Build.VERSION_CODES.N)
    override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
        hideProgressBar()
        super.onReceivedError(view, request, error)
    }

    override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
        hideProgressBar()
        super.onReceivedError(view, errorCode, description, failingUrl)
    }

    private fun hideProgressBar() = webViewInterface.hideProgressbar()

}