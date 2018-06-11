package com.lzy.demo.ui.material_query;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.demo.R;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.ui.material_query.adapter.ConnectPlateAdapter;
import com.lzy.demo.ui.material_query.entity.ConnectPlateModel;
import com.lzy.demo.utils.ProgressDialogUtils;
import com.lzy.demo.utils.WcfHelper;

import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 连板绑定信息查询
 */
public class MaterialConnectingPlateActivity extends BaseActivity {
    @Bind(R.id.horizontalListView)
    ListView horizontalListView;
    static String NameSpace = "http://tempuri.org/";
    static String URL="http://192.168.20.243:8080/LoadingMaterialService.svc";
    static String SOAP_ACTION="http://tempuri.org/ILoadingMaterialService/SplitBoardQueryApp";
    static String MethodName="SplitBoardQueryApp";

    List<ConnectPlateModel> connectPlateModelList;
    ConnectPlateAdapter connectPlateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_connect_plate);
        ButterKnife.bind(this);
        setView();
    }

    private void setView() {
        ((TextView)findView(R.id.tv_title)).setText("连板绑定信息查询");
        //显示进度条
        ProgressDialogUtils.showProgressDialog(this, "数据加载中...");
        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("SN", "1");
        WcfHelper.callWebService(URL, NameSpace,MethodName,SOAP_ACTION, properties, new WcfHelper.WebServiceCallBack() {
            @SuppressLint("LongLogTag")
            @Override
            public void callBack(SoapObject result) {
                //关闭进度条
                ProgressDialogUtils.dismissProgressDialog();
                        if(result != null){
                    Log.e("WcfActivity++++++++++++++++++++++++++++++++++","soapObject.getPropertyCount()：" +result);
                    connectPlateModelList = traceSoapObject(result);
                    connectPlateAdapter = new ConnectPlateAdapter(connectPlateModelList,MaterialConnectingPlateActivity.this);
                    horizontalListView.setAdapter(connectPlateAdapter);
                }else{
                    Toast.makeText(MaterialConnectingPlateActivity.this, "获取WebService数据错误", Toast.LENGTH_SHORT).show();
                }
            }
        });

        horizontalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @SuppressLint("LongLogTag")
    private List<ConnectPlateModel> traceSoapObject(SoapObject result){
        List<String> list = new ArrayList<String>();
        connectPlateModelList = new ArrayList();
        SoapObject provinceSoapObject = (SoapObject) result.getProperty("SplitBoardQueryAppResult");
        if(provinceSoapObject == null) {
            return null;
        }
//        SoapObject traceSoapObject = (SoapObject) provinceSoapObject.getProperty("SMTMaterial");
//        if(traceSoapObject == null) {
//            return null;
//        }
        for(int i=0; i<provinceSoapObject.getPropertyCount(); i++){
            list.add(provinceSoapObject.getProperty(i).toString());
            SoapObject traceSoapObject = (SoapObject) provinceSoapObject.getProperty(i);
            ConnectPlateModel connectPlateModel = new ConnectPlateModel();
            connectPlateModel.setPANEL_SN(traceSoapObject.getPropertyAsString("PANEL_SN"));
            connectPlateModel.setSN(traceSoapObject.getPropertyAsString("SN"));
            connectPlateModel.setPROJECT_NAME(traceSoapObject.getPropertyAsString("PROJECT_NAME"));
            connectPlateModel.setPRODUCT_INSTRUCTION(traceSoapObject.getPropertyAsString("PRODUCT_INSTRUCTION"));
            connectPlateModel.setBOM_NO(traceSoapObject.getPropertyAsString("BOM_NO"));
            connectPlateModelList.add(connectPlateModel);
        }

        return connectPlateModelList;
    }


}
