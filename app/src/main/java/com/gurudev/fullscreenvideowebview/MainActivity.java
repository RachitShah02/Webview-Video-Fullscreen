package com.gurudev.fullscreenvideowebview;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullscreenvideo fullscreenvideo = findViewById(R.id.fullscreen);
        fullscreenvideo.loadUrl("https://m.youtube.com");
    }
}
