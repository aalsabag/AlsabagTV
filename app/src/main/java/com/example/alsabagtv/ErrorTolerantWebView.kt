package com.example.alsabagtv

import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.View
import android.webkit.*
import android.widget.TextView
import android.widget.Toast


open class ErrorTolerantWebView: WebViewClient() {
    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError
    ) {
        Log.d("LOAD", "onReceivedError :$error")
//        if (view!!.canGoBack()) {
//            view!!.
//        }

        val toast = Toast.makeText(
            view?.context,
            "Failed to load Alsabagtv ad management script. Using backup...",
            Toast.LENGTH_LONG
        )
        toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 0)
        val toastView: View = toast.view
        toastView.setBackgroundColor(Color.GREEN)
        val toastText: TextView = toastView.findViewById(android.R.id.message);
        toastText.setTextColor(Color.WHITE)
        toast.show()
        super.onReceivedError(view, request, error)
    }

    override fun onReceivedHttpError(
        view: WebView?,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse
    ) {
        Log.d("LOAD", "onReceivedHttpError:$errorResponse")
    }
}