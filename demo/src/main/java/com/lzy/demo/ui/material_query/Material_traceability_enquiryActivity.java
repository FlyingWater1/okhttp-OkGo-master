package com.lzy.demo.ui.material_query;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.demo.R;
import com.lzy.demo.ui.material_management.adapter.TraceAdapter;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.model.material_management.SMTMaterial;
import com.lzy.demo.utils.ProgressDialogUtils;
import com.lzy.demo.utils.WcfHelper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * PCBA物料追溯查询
 */
public class Material_traceability_enquiryActivity extends BaseActivity {
    @Bind(R.id.horizontalListView)
    ListView horizontalListView;
    static String NameSpace = "http://tempuri.org/";
    static String URL="http://192.168.20.243:8080/LoadingMaterialService.svc";
    static String SOAP_ACTION="http://tempuri.org/ILoadingMaterialService/SMTMaterialQuery";
    static String MethodName="SMTMaterialQuery";

    String[] titles={"项目","SN","物料编码","线别","类型","面别","站位号","料号","批次号","工厂","上料时间","上料人员","作业时间","作业人员"};

    String result;

    TextView text_wcf;

    List<SMTMaterial> smtMaterials;
    List<String> smtMateriallist;
    TraceAdapter traceAdapter;

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            text_wcf.setText(msg.obj.toString());
            text_wcf.setText("WCF返回的数据是：" + result);
        }

    };

    Runnable runnable = new Runnable(){

        @Override
        public void run() {
            try {
                result =  CallWebService();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            Message msg = new Message();
            msg.obj = result;
            handler.sendMessage(msg);

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_traceability_enquiry);
        ButterKnife.bind(this);
        text_wcf = (TextView)findViewById(R.id.text_wcf);
        setView();
    }

    private void setView() {
        ((TextView)findView(R.id.tv_title)).setText("物料追溯查询");
        //显示进度条
        ProgressDialogUtils.showProgressDialog(this, "数据加载中...");
        new Thread(runnable).start();
        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("Sn", "1");
        WcfHelper.callWebService(URL, NameSpace,MethodName,SOAP_ACTION,properties, new WcfHelper.WebServiceCallBack() {
            @SuppressLint("LongLogTag")
            @Override
            public void callBack(SoapObject result) {
                //关闭进度条
                ProgressDialogUtils.dismissProgressDialog();
                if(result != null){
                    Log.e("WcfActivity++++++++++++++++++++++++++++++++++","soapObject.getPropertyCount()：" +result);
//                    smtMateriallist = new ArrayList();
//                    smtMateriallist = parseSoapObject(result);
//                    horizontalListView.setAdapter(new ArrayAdapter<String>(Material_traceability_enquiryActivity.this, android.R.layout.simple_list_item_1, smtMateriallist));
                    smtMaterials = traceSoapObject(result);
                    traceAdapter = new TraceAdapter(smtMaterials,Material_traceability_enquiryActivity.this);
                    horizontalListView.setAdapter(traceAdapter);
                }else{
                    Toast.makeText(Material_traceability_enquiryActivity.this, "获取WebService数据错误", Toast.LENGTH_SHORT).show();
                }
            }
        });

        horizontalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    int size = 0;

    @SuppressLint("LongLogTag")
    public String CallWebService() throws InstantiationException, IllegalAccessException {
        //指定的命名空间和调用的方法名
        SoapObject request = new SoapObject(NameSpace, MethodName);

        //设置需调用接口需要传入的参数
//        request.addProperty("userID", "MES001");
//        request.addProperty("password", "888");
//        request.addProperty("language", "chinese");
        request.addProperty("Sn", "1");
//        request.addProperty("smtMaterial", smtMaterial);

        // 生成调用方法的SOAP请求信息,并指定SOAP的版本
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);

        // 下面这两句是一样的作用，写一句就行了
        envelope.bodyOut = request;
//        envelope.setOutputSoapObject(request);
        envelope.implicitTypes = true;
        // 设置是否调用的是dotNet开发的WebService
        envelope.dotNet = true;
        HttpTransportSE transport = new HttpTransportSE(URL,3000);
        try {
            // 调用
            transport.call(SOAP_ACTION, envelope);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 获取返回的数据
        SoapObject soapObject = (SoapObject) envelope.bodyIn;
        if(null==soapObject){
            return "";
        }

//        smtMaterials = analysisPlanData(soapObject);
//        horizontalListView.setAdapter(new ArrayAdapter<String>(Material_traceability_enquiryActivity.this, android.R.layout.simple_list_item_1, smtMateriallist));

        String result = soapObject.getProperty(0).toString();

        // 获取返回的结果
        Log.e("WcfActivity++++++++++++++++++++++++++++++++++","WCF返回的数据是：" +result);
        System.out.println(result);
        return result;
    }

    @SuppressLint("LongLogTag")
    private List<String> parseSoapObject(SoapObject result){
        List<String> list = new ArrayList<String>();
        smtMaterials = new ArrayList();
        SoapObject provinceSoapObject = (SoapObject) result.getProperty("SMTMaterialQueryResult");
        if(provinceSoapObject == null) {
            return null;
        }
//        SoapObject traceSoapObject = (SoapObject) provinceSoapObject.getProperty("SMTMaterial");
//        if(traceSoapObject == null) {
//            return null;
//        }
        Log.e("WcfActivity++++++++++++++++++++++++++++++++++","WCF返回的数据是："+provinceSoapObject.getPropertyCount());
        for(int i=0; i<provinceSoapObject.getPropertyCount(); i++){
            list.add(provinceSoapObject.getProperty(i).toString());
            SoapObject traceSoapObject = (SoapObject) provinceSoapObject.getProperty(i);
            SMTMaterial smtMaterial = new SMTMaterial();
            smtMaterial.setSN(traceSoapObject.getPropertyAsString("SN"));
            smtMaterial.setBOARD_SIDE(traceSoapObject.getPropertyAsString("BOARD_SIDE"));
            smtMaterial.setBOARD_TYPE(traceSoapObject.getPropertyAsString("BOARD_TYPE"));
            smtMaterial.setBOM_NO(traceSoapObject.getPropertyAsString("BOM_NO"));
            smtMaterial.setCREATED_BY(traceSoapObject.getPropertyAsString("CREATED_BY"));
            smtMaterial.setCREATED_DATE(traceSoapObject.getPropertyAsString("CREATED_DATE"));
            smtMaterial.setFACTORY_NAME(traceSoapObject.getPropertyAsString("FACTORY_NAME"));
            smtMaterial.setKEY_PART_NO(traceSoapObject.getPropertyAsString("KEY_PART_NO"));
            smtMaterial.setKP_LOT(traceSoapObject.getPropertyAsString("KP_LOT"));
            smtMaterial.setLINE_NAME(traceSoapObject.getPropertyAsString("LINE_NAME"));
            smtMaterial.setLOAD_BY(traceSoapObject.getPropertyAsString("LOAD_BY"));
            smtMaterial.setLOAD_DATE(traceSoapObject.getPropertyAsString("LOAD_DATE"));
            smtMaterial.setPROJECT_NAME(traceSoapObject.getPropertyAsString("PROJECT_NAME"));
            smtMaterial.setTRACK_NO(traceSoapObject.getPropertyAsString("TRACK_NO"));
            smtMaterials.add(smtMaterial);

            Log.e("WcfActivity++++++++++++++++++++++++++++++++++","parseSoapObject()：" +provinceSoapObject.getProperty(i).toString()+"smtMaterials="+smtMaterials.get(i).getBOM_NO());
        }

        return list;
    }

    @SuppressLint("LongLogTag")
    private List<SMTMaterial> traceSoapObject(SoapObject result){
        List<String> list = new ArrayList<String>();
        smtMaterials = new ArrayList();
        SoapObject provinceSoapObject = (SoapObject) result.getProperty("SMTMaterialQueryResult");
        if(provinceSoapObject == null) {
            return null;
        }
        Log.e("WcfActivity++++++++++++++++++++++++++++++++++","WCF返回的数据是："+provinceSoapObject.getPropertyCount());
        for(int i=0; i<provinceSoapObject.getPropertyCount(); i++){
            list.add(provinceSoapObject.getProperty(i).toString());
            SoapObject traceSoapObject = (SoapObject) provinceSoapObject.getProperty(i);
            SMTMaterial smtMaterial = new SMTMaterial();
            smtMaterial.setSN(traceSoapObject.getPropertyAsString("SN"));
            smtMaterial.setBOARD_SIDE(traceSoapObject.getPropertyAsString("BOARD_SIDE"));
            smtMaterial.setBOARD_TYPE(traceSoapObject.getPropertyAsString("BOARD_TYPE"));
            smtMaterial.setBOM_NO(traceSoapObject.getPropertyAsString("BOM_NO"));
            smtMaterial.setCREATED_BY(traceSoapObject.getPropertyAsString("CREATED_BY"));
            smtMaterial.setCREATED_DATE(traceSoapObject.getPropertyAsString("CREATED_DATE"));
            smtMaterial.setFACTORY_NAME(traceSoapObject.getPropertyAsString("FACTORY_NAME"));
            smtMaterial.setKEY_PART_NO(traceSoapObject.getPropertyAsString("KEY_PART_NO"));
            smtMaterial.setKP_LOT(traceSoapObject.getPropertyAsString("KP_LOT"));
            smtMaterial.setLINE_NAME(traceSoapObject.getPropertyAsString("LINE_NAME"));
            smtMaterial.setLOAD_BY(traceSoapObject.getPropertyAsString("LOAD_BY"));
            smtMaterial.setLOAD_DATE(traceSoapObject.getPropertyAsString("LOAD_DATE"));
            smtMaterial.setPROJECT_NAME(traceSoapObject.getPropertyAsString("PROJECT_NAME"));
            smtMaterial.setTRACK_NO(traceSoapObject.getPropertyAsString("TRACK_NO"));
            smtMaterials.add(smtMaterial);

            Log.e("WcfActivity++++++++++++++++++++++++++++++++++","parseSoapObject()：" +provinceSoapObject.getProperty(i).toString()+"smtMaterials="+smtMaterials.get(i).getBOM_NO());
        }

        return smtMaterials;
    }


}
