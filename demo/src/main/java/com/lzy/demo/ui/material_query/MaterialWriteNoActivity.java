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
import com.lzy.demo.ui.material_query.adapter.ProductiveProcessAdapter;
import com.lzy.demo.ui.material_query.entity.ProductiveProcessModel;
import com.lzy.demo.utils.ProgressDialogUtils;
import com.lzy.demo.utils.WcfHelper;

import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 写号查询
 */
public class MaterialWriteNoActivity extends BaseActivity {

    @Bind(R.id.horizontalListView)
    ListView horizontalListView;
    static String NameSpace = "http://tempuri.org/";
    static String URL="http://192.168.20.243:8080/LoadingMaterialService.svc";
    static String SOAP_ACTION="http://tempuri.org/ILoadingMaterialService/SplitBoardQuery";
    static String MethodName="SplitBoardQuery";

    List<ProductiveProcessModel> productiveProcessModels;
    ProductiveProcessAdapter productiveProcessAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_write_no);
        ButterKnife.bind(this);
        setView();
    }

    private void setView() {
        ((TextView)findView(R.id.tv_title)).setText("写号信息查询");
        //显示进度条
        ProgressDialogUtils.showProgressDialog(this, "数据加载中...");
        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("Sn", "1");
        WcfHelper.callWebService(URL, NameSpace,MethodName,SOAP_ACTION, properties, new WcfHelper.WebServiceCallBack() {
            @SuppressLint("LongLogTag")
            @Override
            public void callBack(SoapObject result) {
                //关闭进度条
                ProgressDialogUtils.dismissProgressDialog();
                if(result != null){
                    Log.e("WcfActivity++++++++++++++++++++++++++++++++++","soapObject.getPropertyCount()：" +result);
//                    productiveProcessModels = resultSoapObject(result);
//                    productiveProcessAdapter = new ProductiveProcessAdapter(productiveProcessModels,MaterialWriteNoActivity.this);
//                    horizontalListView.setAdapter(productiveProcessAdapter);
                }else{
                    Toast.makeText(MaterialWriteNoActivity.this, "获取WebService数据错误", Toast.LENGTH_SHORT).show();
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
    private List<ProductiveProcessModel> resultSoapObject(SoapObject result){
        List<String> list = new ArrayList<String>();
        productiveProcessModels = new ArrayList();
        SoapObject provinceSoapObject = (SoapObject) result.getProperty("SplitBoardQueryResult");
        if(provinceSoapObject == null) {
            return null;
        }
        for(int i=0; i<provinceSoapObject.getPropertyCount(); i++){
            list.add(provinceSoapObject.getProperty(i).toString());
            SoapObject soapObject = (SoapObject) provinceSoapObject.getProperty(i);
            ProductiveProcessModel productiveProcessModel = new ProductiveProcessModel();
//            productiveProcessModel.setPANEL_SN(soapObject.getPropertyAsString("PANEL_SN"));
//            productiveProcessModel.setSN(soapObject.getPropertyAsString("SN"));
//            productiveProcessModel.setPROJECT_NAME(soapObject.getPropertyAsString("PROJECT_NAME"));
//            productiveProcessModel.setPRODUCT_INSTRUCTION(soapObject.getPropertyAsString("PRODUCT_INSTRUCTION"));
//            productiveProcessModel.setBOM_NO(soapObject.getPropertyAsString("BOM_NO"));
            productiveProcessModels.add(productiveProcessModel);
        }

        return productiveProcessModels;
    }
}
