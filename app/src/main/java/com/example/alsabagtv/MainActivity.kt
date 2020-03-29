package com.example.alsabagtv

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var superSafeWebView: WebView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        superSafeWebView = WebView(applicationContext)
        superSafeWebView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                Log.d("CREATED", "Page finished loading")
                Log.d("CREATED", url )
                if (url != null) {
                    if (url.contains("id=")){
                        Thread.sleep(5000)
                        Log.d("CREATED", "Removing pop up ads")
                        superSafeWebView.loadUrl(
                            "javascript:(function() { " +
                                    "document.getElementsByTagName('iframe')[0].remove();"+
                                    "})()");
                    }
                }
                super.onPageFinished(view, url)
            }
        };
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
