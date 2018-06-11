package com.lzy.demo;/*
 * Copyright (C) 2018 zhouyou(478319399@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.model.TestModel;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.List;


public class TestActivity extends BaseActivity {

    ListView test_list;
    MyAdapter myAdapter;
    List<TestModel.ItemBean> itemBeans;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
        onGet();
        test_list = (ListView)findViewById(R.id.test_list);


    }

    public void onGet() {
        EasyHttp.get("http://192.168.50.100:7002/api/test")
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
                        TestModel testModel = gson.fromJson(response.toString(), TestModel.class);
                        itemBeans = testModel.getItem();
                        myAdapter = new MyAdapter(itemBeans,TestActivity.this);
                        test_list.setAdapter(myAdapter);

                    }
                });
               /* .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        showToast(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String response) {
                        if (response != null) showToast(response.toString());
                    }
});*/
    }


    class MyAdapter extends BaseAdapter {

        private List<TestModel.ItemBean> list = null;

        private Context context = null;

        private LayoutInflater inflater = null;

        public MyAdapter(List<TestModel.ItemBean> list, Context context) {
            this.list = list;
            this.context = context;
            // 布局装载器对象
            inflater = LayoutInflater.from(context);
        }

        // 适配器中数据集中数据的个数
        @Override
        public int getCount() {
            return list.size();
        }

        // 获取数据集中与指定索引对应的数据项
        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        // 获取指定行对应的ID
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.layout_include, null);
                viewHolder.text_id = (TextView)convertView.findViewById(R.id.text_id);
                viewHolder.text_label1 = (TextView)convertView.findViewById(R.id.text_values1);
                viewHolder.text_label2 = (TextView)convertView.findViewById(R.id.text_values2);
                viewHolder.text_label3 = (TextView)convertView.findViewById(R.id.text_values3);
                viewHolder.text_label4 = (TextView)convertView.findViewById(R.id.text_values4);
                viewHolder.text_label5 = (TextView)convertView.findViewById(R.id.text_values5);
                viewHolder.text_label6 = (TextView)convertView.findViewById(R.id.text_values6);
                viewHolder.text_label7 = (TextView)convertView.findViewById(R.id.text_values7);
                viewHolder.text_label8 = (TextView)convertView.findViewById(R.id.text_values8);
                viewHolder.text_label9 = (TextView)convertView.findViewById(R.id.text_values9);
                viewHolder.text_label10 = (TextView)convertView.findViewById(R.id.text_values10);
                viewHolder.text_label11 = (TextView)convertView.findViewById(R.id.text_values11);
                viewHolder.text_label12 = (TextView)convertView.findViewById(R.id.text_values12);
                viewHolder.text_label13 = (TextView)convertView.findViewById(R.id.text_values13);
                viewHolder.text_label14 = (TextView)convertView.findViewById(R.id.text_values14);
                viewHolder.text_label15 = (TextView)convertView.findViewById(R.id.text_values15);
                viewHolder.text_label16 = (TextView)convertView.findViewById(R.id.text_values16);
                viewHolder.text_label17 = (TextView)convertView.findViewById(R.id.text_values17);
                viewHolder.text_label18 = (TextView)convertView.findViewById(R.id.text_values18);
                viewHolder.text_label19 = (TextView)convertView.findViewById(R.id.text_values19);
                viewHolder.text_label20 = (TextView)convertView.findViewById(R.id.text_values20);
                viewHolder.text_label21 = (TextView)convertView.findViewById(R.id.text_values21);
                viewHolder.text_label22 = (TextView)convertView.findViewById(R.id.text_values22);
                viewHolder.text_label23 = (TextView)convertView.findViewById(R.id.text_values23);
                convertView.setTag(viewHolder);// 通过setTag将ViewHolder和convertView绑定
            }  else {
                viewHolder = (ViewHolder) convertView.getTag(); // 获取，通过ViewHolder找到相应的控件
            }
            TestModel.ItemBean testModel = list.get(position);
            viewHolder.text_id.setText("第"+(position+1)+"项");
            viewHolder.text_label1.setText(testModel.getSTART_TIME()+"");
            viewHolder.text_label2.setText(testModel.getEND_TIME()+"");
            viewHolder.text_label3.setText(testModel.getTINSOLDER_NO()+"");
            viewHolder.text_label4.setText(testModel.getPROJECT_ID()+"");
            viewHolder.text_label5.setText(testModel.getPROJECT_NAME()+"");
            viewHolder.text_label6.setText(testModel.getTINSOLDER_SUPPLY()+"");
            viewHolder.text_label7.setText(testModel.getTINSOLDER_TYPE()+"");
            viewHolder.text_label8.setText(testModel.getBATCH_NO()+"");
            viewHolder.text_label9.setText(testModel.getTINSOLDER_KP_NO()+"");
            viewHolder.text_label10.setText(testModel.getSHELF_LIFE()+"");
            viewHolder.text_label11.setText(testModel.getGETWARM_BEGINTIME()+"");
            viewHolder.text_label12.setText(testModel.getGETWARM_ENDTIME()+"");
            viewHolder.text_label13.setText(testModel.getALL_IN_TIMES()+"");
            viewHolder.text_label14.setText(testModel.getMO_NUMBER()+"");
            viewHolder.text_label15.setText(testModel.getTINSOLDER_STATUS()+"");
            viewHolder.text_label16.setText(testModel.getTINSOLDER_STATUS_NAME()+"");
            viewHolder.text_label17.setText(testModel.getIF_EXPIRED()+"");
            viewHolder.text_label18.setText(testModel.getLINE_ID()+"");
            viewHolder.text_label19.setText(testModel.getLINE_NAME()+"");
            viewHolder.text_label20.setText(testModel.getCREATED_BY()+"");
            viewHolder.text_label21.setText(testModel.getCREATED_DATE()+"");
            viewHolder.text_label22.setText(testModel.getLAST_UPDATED_BY()+"");
            viewHolder.text_label23.setText(testModel.getLAST_UPDATED_DATE()+"");
            return convertView;
        }

        class ViewHolder {
            TextView text_id;
            TextView text_label1;
            TextView text_label2;
            TextView text_label3;
            TextView text_label4;
            TextView text_label5;
            TextView text_label6;
            TextView text_label7;
            TextView text_label8;
            TextView text_label9;
            TextView text_label10;
            TextView text_label11;
            TextView text_label12;
            TextView text_label13;
            TextView text_label14;
            TextView text_label15;
            TextView text_label16;
            TextView text_label17;
            TextView text_label18;
            TextView text_label19;
            TextView text_label20;
            TextView text_label21;
            TextView text_label22;
            TextView text_label23;
        }
    }


}