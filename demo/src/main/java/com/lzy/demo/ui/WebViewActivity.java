package com.lzy.demo.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lzy.demo.R;

/**
 * Created by sdj on 2017/11/24.
 */

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    public static final String RESULT = "result_data";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        initViews();
    }
    private void initViews(){
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/echart/myechart.html");

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

//                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //最好在这里调用js代码 以免网页未加载完成
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(2000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        webView.loadUrl("javascript:createBarLineChart();");
//                    }
//                }).start();
//                webView.loadUrl("javascript:createChart('line'," + EchartsDataBean.getInstance().getEchartsLineJson() + ");");
//                findViewById(R.id.rl_bottom).setVisibility(View.VISIBLE);
//                if (dialog.isShowing()) {
//                    dialog.dismiss();
//                }
            }
        });

    }
}
