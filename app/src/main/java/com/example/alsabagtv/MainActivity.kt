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
                                    "let ad_class_names=[\"_63myj5r _lk70fcs\",\"_zb9zv92 _egf31ph\",\"_zyjw2i2 _bu8cnqq\",\"megbylsm\",\"_vgbnxwp\",\"_hyaprrm\",\"ad_asd\",\"_xf3ope _tcde9lb\",\"_pvfdbgu _0x5jfo\"],ad_id_names=[\"ad_asd\"];for(let e=0;e<ad_class_names.length;e++)try{document.getElementsByClassName(ad_class_names[e])[0].remove()}catch(l){console.log(\"failed to remove by class name\"+ad_class_names[e])}for(let e=0;e<ad_id_names.length;e++)try{document.getElementById(ad_id_names[e]).remove()}catch(l){console.log(\"failed to remove by id \"+ad_id_names[e])}let click_class_names=[\"_9ehkpq\",\"_aeonhsr\",\"_6sdryz9\"];for(let e=0;e<click_class_names.length;e++)try{document.getElementsByClassName(click_class_names[e])[0].click()}catch(l){console.log(\"failed to remove by clicking \"+click_class_names[e])}try{var element=document.getElementsByTagName(\"iframe\");element[0]&&(element[0].name.includes(\"youtube\")?(console.log(\"removing youtube ad\"),element[1].remove()):(console.log(\"removing youtube ad\"),document.getElementsByTagName(\"iframe\")[0].remove()))}catch(e){console.log(\"failed to remove youtube ad\")}try{if(document.getElementById(\"player\")){for(var searchEles=document.getElementById(\"player\").children,i=0;i<searchEles.length;i++)\"player\"==searchEles[i].id&&searchEles[i].play();document.getElementById(\"player\").play()}}catch(e){console.log(\"first autoplay fail\")}try{document.getElementById(\"1player_2\")&&document.getElementById(\"1player_2\").play()}catch(e){console.log(\"second autoplay fail\")}try{var elms=document.getElementById(\"player\").getElementsByTagName(\"*\");for(i=0;i<elms.length;i)if(\"player\"===elms[i].id){elms[i].style[\"object-fit\"]=\"cover\";break}}catch(e){console.log(\"failed to resize video\")}1==document.querySelectorAll(\"html > div\").length&&document.querySelector(\"html > div\").remove(),console.log(\"script complete!\");" +
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
