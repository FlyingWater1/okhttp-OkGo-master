package com.lzy.demo.ui.material_query;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.demo.GApp;
import com.lzy.demo.R;
import com.lzy.demo.adapter.MaterialItemAdapter;
import com.lzy.demo.adapter.MenuItemAdapter;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.model.APPMemuModel;
import com.lzy.demo.model.MenuItemModel;
import com.lzy.demo.widget.GridViewForScrollView;

import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.List;

public class Material_queryActivity extends BaseActivity {

    static String NameSpace = "http://tempuri.org/";
    static String URL="http://192.168.20.243:8080/UserLoginService.svc";
    static String SOAP_ACTION="http://tempuri.org/IUserLoginService/GetAllMemuByUserAPP";
    static String MethodName="GetAllMemuByUserAPP";

    MenuItemAdapter adapter;
    GridViewForScrollView gridView;

    SharedPreferences preferences;

    String uesrname;

    ImageView nothing;


    int images[] = new int[]{R.drawable.layout_gray_bg,R.drawable.layout_green_bg,R.drawable.layout_red_bg,R.drawable.layout_pink_bg,
            R.drawable.layout_yellow_bg,R.drawable.layout_purle_bg,};

    String titles[] = new String[]{"物料信息追溯","连扳信息查询","生产过程查询","机台属性查询","SN状态查询","写号信息查询"};
    MaterialItemAdapter materialItemAdapter;
    List<MenuItemModel> menuItemModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);
        setView();
    }

    private void setView() {
        ((TextView)findView(R.id.tv_title)).setText("查询");
        preferences = getSharedPreferences(GApp.MODE_PRENAME,MODE_PRIVATE);
        uesrname = preferences.getString("username","");
        gridView = (GridViewForScrollView) findViewById(R.id.gridView);

        for (int i = 0; i < titles.length; i++) {
            menuItemModelList.add(new MenuItemModel(titles[i],images[i]));
        }
        materialItemAdapter = new MaterialItemAdapter(this,menuItemModelList);
        gridView.setAdapter(materialItemAdapter);


        nothing = (ImageView) findViewById(R.id.nothing);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (menuItemModelList.get(position).getTitle()){
                    case "物料信息追溯":
                        startActivity(new Intent(Material_queryActivity.this,Material_traceability_enquiryActivity.class));
                        break;
                    case "连扳信息查询":
                        startActivity(new Intent(Material_queryActivity.this,MaterialConnectingPlateActivity.class));
                        break;
                    case "生产过程查询":
                        startActivity(new Intent(Material_queryActivity.this,MaterialProductiveProcessActivity.class));
                        break;
                    case "机台属性查询":
//                        startActivity(new Intent(Material_queryActivity.this,MaterialProductiveProcessActivity.class));
                        break;
                    case "SN状态查询":
                        startActivity(new Intent(Material_queryActivity.this,MaterialSnStatusActivity.class));
                        break;
                    case "写号信息查询":
                        startActivity(new Intent(Material_queryActivity.this,MaterialWriteNoActivity.class));
                        break;
                }
            }
        });

//        appMemuModelList = new ArrayList();
//        ProgressDialogUtils.showProgressDialog(this, "数据加载中...");
//        HashMap<String, String> properties = new HashMap<String, String>();
//        properties.put("userId", uesrname);
//        properties.put("Id", getIntent().getStringExtra("id"));
//        WcfHelper.callWebService(URL, NameSpace,MethodName,SOAP_ACTION,properties, new WcfHelper.WebServiceCallBack() {
//            @SuppressLint("LongLogTag")
//            @Override
//            public void callBack(SoapObject result) {
//                //关闭进度条
//                ProgressDialogUtils.dismissProgressDialog();
//                if(result != null){
//                    traceSoapObject(result);
//                    if (appMemuModelList.size()>0){
//                        adapter = new MenuItemAdapter(Store_bindActivity.this,appMemuModelList);
//                        gridView.setAdapter(adapter);
//                    }else{
//                        nothing.setVisibility(View.VISIBLE);
//                        gridView.setVisibility(View.GONE);
//                    }
//
//                    Log.e("ImsActivity++++++++++++++++++++++++++++++++++","callBack()：" +result);
//                }else{
//                    Toast.makeText(Store_bindActivity.this, "获取WebService数据错误", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//            }
//        });
    }

    List<APPMemuModel> appMemuModelList;

    @SuppressLint("LongLogTag")
    private void traceSoapObject(SoapObject result){
        List<String> list = new ArrayList<String>();

        SoapObject provinceSoapObject = (SoapObject) result.getProperty("GetAllMemuByUserAPPResult");
        if(provinceSoapObject == null) {
            return ;
        }
        for(int i=0; i<provinceSoapObject.getPropertyCount(); i++){
            list.add(provinceSoapObject.getProperty(i).toString());
            SoapObject traceSoapObject = (SoapObject) provinceSoapObject.getProperty(i);
            APPMemuModel appMemuModel = new APPMemuModel();
            appMemuModel.setId(traceSoapObject.getPropertyAsString("Id"));
            appMemuModel.setName(traceSoapObject.getPropertyAsString("Name"));
            appMemuModelList.add(appMemuModel);

        }

    }
}
