package com.lzy.demo.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.lzy.demo.GApp;
import com.lzy.demo.R;
import com.lzy.demo.adapter.MenuItemAdapter;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.model.APPMemuModel;
import com.lzy.demo.ui.material_management.WarehouseActivity;
import com.lzy.demo.ui.material_query.Material_queryActivity;
import com.lzy.demo.utils.ProgressDialogUtils;
import com.lzy.demo.utils.WcfHelper;
import com.lzy.demo.widget.GridViewForScrollView;
import com.vondear.rxtools.activity.ActivityScanerCode;

import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImsActivity extends BaseActivity {
    static String NameSpace = "http://tempuri.org/";
    static String URL="http://192.168.20.243:8080/UserLoginService.svc";
    static String SOAP_ACTION="http://tempuri.org/IUserLoginService/GetAllMemuByUserAPP";
    static String MethodName="GetAllMemuByUserAPP";

    MenuItemAdapter adapter;
    GridViewForScrollView gridView;

    SharedPreferences preferences;

    String uesrname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ims);
        preferences = getSharedPreferences(GApp.MODE_PRENAME,MODE_PRIVATE);
        setView();
    }

    private void setView() {
        uesrname = preferences.getString("username","");
        gridView = (GridViewForScrollView) findViewById(R.id.gridView);
        //显示进度条
        appMemuModelList = new ArrayList();
        ProgressDialogUtils.showProgressDialog(this, "数据加载中...");
        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("userId", uesrname);
        properties.put("Id", "17");
        WcfHelper.callWebService(URL, NameSpace,MethodName,SOAP_ACTION,"userId",uesrname, properties, new WcfHelper.WebServiceCallBack() {
            @SuppressLint("LongLogTag")
            @Override
            public void callBack(SoapObject result) {
                //关闭进度条
                ProgressDialogUtils.dismissProgressDialog();
                if(result != null){
                   traceSoapObject(result);
                    adapter = new MenuItemAdapter(ImsActivity.this,appMemuModelList);
                    gridView.setAdapter(adapter);
                    Log.e("ImsActivity++++++++++++++++++++++++++++++++++","soapObject.getPropertyCount()：" +result);
//                    horizontalListView.setAdapter(new ArrayAdapter<String>(Material_traceability_enquiryActivity.this, android.R.layout.simple_list_item_1, smtMateriallist));
                }else{
                    Toast.makeText(ImsActivity.this, "获取WebService数据错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ImsActivity.this,WarehouseActivity.class).putExtra("id",appMemuModelList.get(position).getId()));

            }
        });
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

    public void startEchart(View view) {
        startActivity(new Intent(this,BoardActivity.class));
    }
    public void startCategory(View view) {
        startActivity(new Intent(this,Material_queryActivity.class));
    }
    public void startQRcode(View view) {
        startActivity(new Intent(this,ActivityScanerCode.class));
    }
    public void startInventory(View view) {
        startActivity(new Intent(this,Inventory_managementActivity.class));
    }
    public void startMaterialManagement(View view) {
        startActivity(new Intent(this,MaterialManagementActivity.class));
    }

    public void startBoard(View view) {
        startActivity(new Intent(this,BoardProductionSchedulingActivity.class));
    }
}
