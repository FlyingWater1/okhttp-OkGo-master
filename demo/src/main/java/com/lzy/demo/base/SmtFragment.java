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
package com.lzy.demo.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.demo.GApp;
import com.lzy.demo.R;
import com.lzy.demo.SmtMenuActivity;
import com.lzy.demo.adapter.FirstAdapter;
import com.lzy.demo.adapter.SecondAdapter;
import com.lzy.demo.model.ItemModel;
import com.lzy.demo.model.SmtModel;
import com.lzy.demo.widget.MyListView;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.content.Context.MODE_PRIVATE;

/**
 * ================================================
 * 作    者：Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：2017/6/9
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class SmtFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

//    @Bind(R.id.refreshLayout) SwipeRefreshLayout refreshLayout;
    @Bind(R.id.lv_first)MyListView lv_first;
    @Bind(R.id.lv_second)MyListView lv_second;
    @Bind(R.id.lv_third)MyListView lv_third;
    protected Context context;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    List<SmtModel.DataBean.ChildsBeanXX> childsBeanXX;

    FirstAdapter mFirstAdapter;
    String username ;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_smt_menu, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }


    @Override
    public void onRefresh() {
        setRefreshing(false);
    }

    @Override
    public void onLoadMoreRequested() {
//        refreshLayout.postDelayed(new Runnable() {
//        @Override
//        public void run() {
//            if (childsBeanXX.size()>0){
//                childsBeanXX.clear();
//                onGet(username);
//            }
//        }
//    }, 500);
    }


    protected void initData() {

        preferences = getActivity().getSharedPreferences(GApp.MODE_PRENAME,MODE_PRIVATE);
        username = preferences.getString("username","");
        onGet(username);

        lv_first.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mFirstAdapter.setSelectItem(position);
                mFirstAdapter.notifyDataSetChanged();
                List<SmtModel.DataBean.ChildsBeanXX.ChildsBeanX> SecondChildsBeanXXList = childsBeanXX.get(position).getChilds();
                SecondAdapter secondAdapter = new SecondAdapter(SecondChildsBeanXXList,getActivity());
                lv_second.setAdapter(secondAdapter);
                secondAdapter.notifyDataSetChanged();
            }
        });

//        refreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
//        refreshLayout.setOnRefreshListener(this);

    }
    public void onGet(String username) {
        EasyHttp.get("http://192.168.50.100:7002/api/values?userId="+username)//ZJY-TZ00011
                .baseUrl("http://192.168.50.100:7002")
//                .readTimeOut(30 * 1000)//局部定义读超时 ,可以不用定义
//                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)
                //.headers("","")//设置头参数
                //.params("name","张三")//设置参数
                //.addInterceptor()
                //.addConverterFactory()
                //.addCookie()
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        showToast(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String response) {
//                        if (response != null) showToast(response.toString());
                        Log.e("请求成功：",response.toString());
                        Gson gson = new Gson();
                        SmtModel smtModel = gson.fromJson(response.toString(), SmtModel.class);
                        childsBeanXX = smtModel.getData().get(0).getChilds();
                        mFirstAdapter = new FirstAdapter(childsBeanXX,getActivity());
                        lv_first.setAdapter(mFirstAdapter);

                        List<SmtModel.DataBean.ChildsBeanXX.ChildsBeanX> SecondChildsBeanXXList = childsBeanXX.get(0).getChilds();
                        SecondAdapter secondAdapter = new SecondAdapter(SecondChildsBeanXXList,getActivity());
                        lv_second.setAdapter(secondAdapter);

                    }
                });
    }

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    public void setRefreshing(final boolean refreshing) {
//        refreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                refreshLayout.setRefreshing(refreshing);
//            }
//        });
    }
}
