package com.gurudev.fullscreenvideowebview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;

public class fullscreenvideo extends WebView {

    public fullscreenvideo(Context context) {
        super(context);
        initView(context);
    }

    public fullscreenvideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView(Context context) {
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setUseWideViewPort(true);
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setDomStorageEnabled(true);
        this.setWebChromeClient(new chromeClientFullScreen(context));
    }

    public class chromeClientFullScreen extends WebChromeClient {
        private Context context;
        private View mCustomView;
        private CustomViewCallback mCustomViewCallback;
        private int mOriginalSystemUiVisibility;
        int orientation = getResources().getConfiguration().orientation;

        chromeClientFullScreen(Context context) {
            this.context = context;
        }

        public Bitmap getDefaultVideoPoster() {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(context.getResources(), 2130837573);
        }

        public void onHideCustomView() {
            ((FrameLayout) ((Activity) context).getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            ((Activity) context).setRequestedOrientation(orientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback) {
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = ((Activity) context).getWindow().getDecorView().getSystemUiVisibility();
            ((Activity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout) ((Activity) context).getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }
}
