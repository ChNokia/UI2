package com.homework.news;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class DetailActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_main);

        webView = (WebView) findViewById(R.id.webViewDetail);

        webView.loadUrl("file:///android_asset/html/NewsTemplate.html");
        webView.getSettings().setJavaScriptEnabled(true);
    }

}