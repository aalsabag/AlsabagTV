package com.example.alsabagtv

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class MainActivity : AppCompatActivity() {
    private lateinit var superSafeWebView: WebView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        superSafeWebView = WebView(applicationContext)
        //Add lines to open debugger
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        superSafeWebView.webViewClient = object : ErrorTolerantWebView(){
            override fun onPageFinished(view: WebView?, url: String?) {
                Log.d("CREATED", "Page finished loading")
                Log.d("CREATED", url)
                if (url != null) {
                    if (url.contains("id=")){
                        Thread.sleep(5000)
                        Log.d("CREATED", "Removing pop up ads")
                        superSafeWebView.evaluateJavascript("var adScript = async function() {let response = await fetch(\"https://cdn.jsdelivr.net/gh/aalsabag/AlsabagTV@master/ad_scripts/ad_script_latest.js\");\n" +
                                "  let script = await response.text();\n" +
                                "  eval(script);};adScript();", null)

                    }
                }
                super.onPageFinished(view, url)
            }
        }
        superSafeWebView.settings.domStorageEnabled = true
        superSafeWebView.settings.setAppCacheEnabled(true)
        superSafeWebView.settings.loadsImagesAutomatically = true
        superSafeWebView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        superSafeWebView.settings.javaScriptEnabled = true
        superSafeWebView.settings.mediaPlaybackRequiresUserGesture = false
        setContentView(superSafeWebView)
        superSafeWebView.loadUrl("http://www.elahmad.com/tv/mobiletv/")
    }

    override fun onBackPressed(){
        if(superSafeWebView.canGoBack()) {
            Log.d("CREATED", "Can go back")
            superSafeWebView.goBack()
        }else {
            super.onBackPressed()
        }
    }
}
