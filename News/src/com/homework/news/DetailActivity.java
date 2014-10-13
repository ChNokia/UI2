package com.homework.news;

/**
 * Created by Yushchenko on 26.09.2014.
 */
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DetailActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_main);

        webView = (WebView) findViewById(R.id.webViewDetail);

        webView.loadUrl("file:///android_asset/html/NewsTemplate.html");

        webView.getSettings().setJavaScriptEnabled(true);
    }

}