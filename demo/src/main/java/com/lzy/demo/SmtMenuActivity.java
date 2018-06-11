package com.lzy.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.demo.adapter.FirstAdapter;
import com.lzy.demo.adapter.SecondAdapter;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.model.SmtModel;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.List;

public class SmtMenuActivity extends BaseActivity {

    List<SmtModel.DataBean.ChildsBeanXX> childsBeanXX;
    private ListView lv_first,lv_second,lv_third;

    FirstAdapter mFirstAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smt_menu);
        lv_first = (ListView) findViewById(R.id.lv_first);
        lv_second = (ListView) findViewById(R.id.lv_second);
        lv_third = (ListView) findViewById(R.id.lv_third);
        onGet();

        lv_first.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mFirstAdapter.setSelectItem(position);
                mFirstAdapter.notifyDataSetChanged();
                List<SmtModel.DataBean.ChildsBeanXX.ChildsBeanX> SecondChildsBeanXXList = childsBeanXX.get(position).getChilds();
                SecondAdapter secondAdapter = new SecondAdapter(SecondChildsBeanXXList,SmtMenuActivity.this);
                lv_second.setAdapter(secondAdapter);
                secondAdapter.notifyDataSetChanged();
            }
        });
    }

    public void onGet() {
        EasyHttp.get("http://192.168.50.100:7002/api/values?userId=ZJY-TZ00011")
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
                        mFirstAdapter = new FirstAdapter(childsBeanXX,SmtMenuActivity.this);
                        lv_first.setAdapter(mFirstAdapter);

                        List<SmtModel.DataBean.ChildsBeanXX.ChildsBeanX> SecondChildsBeanXXList = childsBeanXX.get(0).getChilds();
                        SecondAdapter secondAdapter = new SecondAdapter(SecondChildsBeanXXList,SmtMenuActivity.this);
                        lv_second.setAdapter(secondAdapter);

                    }
                });
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}


