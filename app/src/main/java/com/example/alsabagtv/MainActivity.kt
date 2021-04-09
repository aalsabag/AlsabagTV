package com.example.alsabagtv

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.WindowManager
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
        //Add lines to open debugger
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
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
                                    "try { " +
                                    "var element = document.getElementsByTagName('iframe');"+
                                    "if (element[0]) {" +
                                    "if(element[0].name.includes('youtube')){" +
                                    "element[1].remove();" +
                                    "}else {"+
                                    "document.getElementsByTagName('iframe')[0].remove();"+
                                    "}"+
                                    "}" +
                                    "} catch (error) {" +
                                    "console.log(error);" +
                                    "console.log(\"error 1\");" +
                                    "}"+

                                    "try {" +
                                    "document.getElementsByClassName(\"_zb9zv92 _egf31ph\")[0].remove();" +
                                    "} catch (error) {" +
                                    "console.log(error);" +
                                    "console.log(\"error 5\");" +
                                    "}"+

                                    "try {" +
                                     "   document.getElementsByClassName(\"_zyjw2i2 _bu8cnqq\")[0].remove();" +
                                    "} catch (error) {" +
                                        "console.log(error);" +
                                        "console.log(\"error 5\");" +
                                    "}" +

                                   "try {" +
                                   "     document.getElementById(\"_cqiw04c\").remove();" +
                                    " } catch (error) {" +
                                    "    console.log(error); " +
                                    "    console.log(\"error 6.5\")" +
                                    "}" +

                                    "try {" +
                                    "document.getElementsByClassName(\"megbylsm\")[0].remove();" +
                                    "} catch (error) {" +
                                    "console.log(error);" +
                                    "console.log(\"error 6\");" +
                                    "}"+


                                    "try {" +
                                    "		document.getElementsByClassName(\"_vgbnxwp\")[0].remove()" +
                                    "	} catch (error) {" +
                                    "		console.log(error);" +
                                    "		console.log(\"error 7\");" +
                                    "	}" +

                                    "try {" +
                                    "document.getElementsByClassName(\"_hyaprrm\")[0].remove();" +
                                    "} catch (error) {" +
                                    "console.log(error);" +
                                    "console.log(\"error 8\");" +
                                    "}"+

                                    "if (document.getElementsByClassName(\"_9ehkpq\")[0]){"+
                                    "document.getElementsByClassName(\"_9ehkpq\")[0].click()"+
                                    "}"+
                                    "if (document.getElementsByClassName(\"_aeonhsr\")[0]){"+
                                    "document.getElementsByClassName(\"_aeonhsr\")[0].click()"+
                                    "}"+
                                    "if (document.getElementById(\"ad_asd\")){"+
                                    "document.getElementById(\"ad_asd\").remove()"+
                                    "}"+

                                    "try { " +
                                    "if (document.getElementById(\"player\")){"+
                                    "var searchEles = document.getElementById(\"player\").children;" +
                                    "for(var i = 0; i < searchEles.length; i++) {" +
                                    "if(searchEles[i].id == 'player') {" +
                                    "searchEles[i].play();" +
                                    "}" +
                                    "}" +
                                    "document.getElementById(\"player\").play();"+
                                    "}" +
                                    "} catch (error) {" +
                                    "console.log(error);" +
                                    "console.log(\"error 2\");" +
                                    "}"+

                                    "try {" +
                                    "if (document.getElementById(\"1player_2\")){"+
                                    "document.getElementById(\"1player_2\").play();"+
                                    "}"+
                                    "} catch (error) {" +
                                    "console.log(error);" +
                                    "console.log(\"error 3\");" +
                                    "}"+

                                    "try {" +
                                    "document.getElementsByClassName(\"_6sdryz9\")[0].click();" +
                                    "} catch (error) {" +
                                    "console.log(error);" +
                                    "console.log(\"error 4\");" +
                                    "}"+

                                    "try {" +
                                    "var elms = document.getElementById(\"player\").getElementsByTagName(\"*\");" +
                                    "for (var i = 0; i < elms.length; i++) {" +
                                    "if (elms[i].id === \"player\") {" +
                                    "elms[i].style[\"object-fit\"] = \"cover\";" +
                                    "break;" +
                                    "}"+
                                    "}"+
                                    "} catch(error) {" +
                                    "console.log(error);" +
                                    "console.log(\"error 6\");" +
                                    "}" +

                                    "if (document.querySelectorAll('html > div').length == 1) {document.querySelector('html > div').remove()}" +

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
            Log.d("CREATED", "Can go back")
            superSafeWebView.goBack()
        }else {
            super.onBackPressed()
        }
    }

}
