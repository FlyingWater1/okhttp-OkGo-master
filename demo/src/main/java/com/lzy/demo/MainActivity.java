/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lzy.demo;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lzy.demo.base.BaseMainActivity;
import com.lzy.demo.logcollector.LogCollector;
import com.lzy.demo.okdownload.OkDownloadFragment;
import com.lzy.demo.okgo.OkGoFragment;
import com.lzy.demo.okrx2.OkRx2Fragment;
import com.lzy.demo.okrx2.OkRxFragment;
import com.lzy.demo.okupload.OkUploadFragment;
import com.lzy.demo.ui.PointCodeFragment;
import com.lzy.demo.widget.Effects;
import com.lzy.demo.widget.Manager;
import com.lzy.demo.widget.NiftyNotificationView;
import com.lzy.demo.widget.ThemeHelper;
import com.vondear.rxtools.activity.ActivityScanerCode;
import com.vondear.rxtools.view.RxToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：jeasonlzy（）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/11
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MainActivity extends BaseMainActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.viewPager) ViewPager viewPager;
    @Bind(R.id.tab) TabLayout tab;
    @Bind(R.id.bannar)
    ImageView bannar;
    @Bind(R.id.coolapsing_layout)
    CollapsingToolbarLayout coolapsing_layout;

    private List<Pair<String, Fragment>> items;

    private Effects effect;

    String msg="网络连接失败!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏展示
//        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initToolBar(toolbar, false, "");
        Glide.with(getApplicationContext())//
                .load("http://img15.3lian.com/2015/h1/308/d/204.jpg")//
//                .error(R.mipmap.ic_launcher)//
                .into(bannar);
        LogCollector.upload(true);//在wifi状态下上传

        items = new ArrayList<>();
        items.add(new Pair<String, Fragment>("Code", new PointCodeFragment()));
        items.add(new Pair<String, Fragment>("OkGo", new OkGoFragment()));
//        items.add(new Pair<String, Fragment>("Payment", new PayFragment()));
        items.add(new Pair<String, Fragment>("OkRx2", new OkRx2Fragment()));
        items.add(new Pair<String, Fragment>("OkRx", new OkRxFragment()));
        items.add(new Pair<String, Fragment>("OkDownload", new OkDownloadFragment()));
        items.add(new Pair<String, Fragment>("OkUpload", new OkUploadFragment()));

        viewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(viewPager);


//        if (ThemeHelper.isDefaultTheme(this)) {
//            coolapsing_layout.setContentScrimResource(R.color.pink);
//            return;
//        }
        if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_SAKURA) {
            coolapsing_layout.setContentScrimResource(R.color.pink);
            return;
        } else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_STORM) {
            coolapsing_layout.setContentScrimResource(R.color.blue);
            return;
        } else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_HOPE) {
            coolapsing_layout.setContentScrimResource(R.color.purple);
            return;
        } else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_WOOD) {
            coolapsing_layout.setContentScrimResource(R.color.green);
            return;
        } else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_LIGHT) {
            coolapsing_layout.setContentScrimResource(R.color.green_light);
            return;
        } else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_THUNDER) {
            coolapsing_layout.setContentScrimResource(R.color.yellow);
            return;
        } else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_SAND) {
            coolapsing_layout.setContentScrimResource(R.color.orange);
            return;
        } else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_FIREY) {
            coolapsing_layout.setContentScrimResource(R.color.red);
            return;
        }else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_BROWN_LIGHT) {
            coolapsing_layout.setContentScrimResource(R.color.brown_light);
            return;
        }else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_BROWN) {
            coolapsing_layout.setContentScrimResource(R.color.brown);
            return;
        }else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_CYAN_LIGHT) {
            coolapsing_layout.setContentScrimResource(R.color.cyan_light);
            return;
        }else if (ThemeHelper.getTheme(this) == ThemeHelper.CARD_CYAN) {
            coolapsing_layout.setContentScrimResource(R.color.cyan);
            return;
        }
//        coolapsing_layout.setBackgroundResource();



    }


    @Override
    protected void onResume() {
        super.onResume();
        if (!isNetworkAvalible(this)){
            effect= Effects.slideOnTop;
            NiftyNotificationView.build(this,msg, effect,R.id.mLyout)
                    .setIcon(R.drawable.lion)         //You must call this method if you use ThumbSlider effect
                    .show();
        }else{
            Manager.getInstance().displayNotify(false);
        }
    }

    @OnClick(R.id.fab)
    public void fab(View view) {
//        WebActivity.runActivity(this, "我的Github,欢迎star", "https://github.com/jeasonlzy");
        startActivity(new Intent(this,ActivityScanerCode.class));
    }

    /**
     * 判断网络情况
     * @param context 上下文
     * @return false 表示没有网络 true 表示有网络
     */
    public static boolean isNetworkAvalible(Context context) {
        // 获得网络状态管理器
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 建立网络数组
            NetworkInfo[] net_info = connectivityManager.getAllNetworkInfo();

            if (net_info != null) {
                for (int i = 0; i < net_info.length; i++) {
                    // 判断获得的网络状态是否是处于连接状态
                    if (net_info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    /**
     * 第一种解决办法 通过监听keyUp
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                RxToast.Tipinfo(this, "再按一次退出程序.", Toast.LENGTH_SHORT, true).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }

        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected boolean translucentStatusBar() {
        return true;
    }

    private class MainAdapter extends FragmentPagerAdapter {

        MainAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position).second;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return items.get(position).first;
        }
    }
}
