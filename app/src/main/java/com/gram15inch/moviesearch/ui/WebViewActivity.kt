package com.gram15inch.moviesearch.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.gram15inch.domain.policy.ExtraPolicy
import com.gram15inch.moviesearch.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private val binding by lazy {ActivityWebViewBinding.inflate(layoutInflater)}
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val webUrl = intent.getStringExtra(ExtraPolicy.WEB_URL)

        webUrl?.let { url ->
            binding.run {
                webView.webViewClient = WebViewClient()
                webView.settings.javaScriptEnabled = true
                webView.settings.builtInZoomControls = true
                webView.settings.setSupportZoom(true)
                webView.settings.displayZoomControls = false
                webView.loadUrl(url)
            }
        }
    }
}