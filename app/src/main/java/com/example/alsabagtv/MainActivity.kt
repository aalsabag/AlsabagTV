package com.example.alsabagtv

import android.os.Build
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var superSafeWebView: WebView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        superSafeWebView = WebView(applicationContext)
        superSafeWebView.settings.domStorageEnabled = true;
        superSafeWebView.settings.setAppCacheEnabled(true);
        superSafeWebView.settings.loadsImagesAutomatically = true;
        superSafeWebView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW;
        superSafeWebView.settings.javaScriptEnabled = true

        setContentView(superSafeWebView)
        superSafeWebView.loadUrl("http://www.elahmad.com/tv/mobiletv/")
    }

    override fun onBackPressed(){
        if(superSafeWebView.canGoBack()) {
            print("Can go back")
            superSafeWebView.goBack()
        }else {
            super.onBackPressed()
        }
    }
}
