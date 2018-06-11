package com.lzy.demo.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.lzy.demo.R;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.model.material_management.LoadingMaterial;
import com.lzy.demo.utils.WcfHelper;

import org.apache.http.HttpEntity;
import org.apache.http.protocol.HTTP;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class WcfActivity extends BaseActivity {

    TextView text_wcf;

    static String NameSpace = "http://tempuri.org/";
    static String URL="http://192.168.20.243:8010/MateriaInfoService.svc";
    static String SOAP_ACTION="http://tempuri.org/IMateriaInfoService/SMTLoadingMaterialUpdateSN";
    static String MethodName="SMTLoadingMaterialUpdateSN";

    WcfHelper wcfHelper;
    String result;

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            text_wcf.setText(msg.obj.toString());
            text_wcf.setText("WCF返回的数据是：" + result);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcf);
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
//                        // 详见StrictMode文档
//                         StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                                         .detectDiskReads().detectDiskWrites().detectNetwork()
//                                         .penaltyLog().build());
//                         StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                                         .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
//                                         .penaltyLog().penaltyDeath().build());
//                     }
        text_wcf = (TextView)findViewById(R.id.text_wcf);
        new Thread(runnable).start();
//        wcfHelper = new WcfHelper(this);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                wcfHelper.say();
//                wcfHelper.sayHello();
//                wcfHelper.speak();
//                wcfHelper.speakHello();
//        }
//        }).start();
    }

    Runnable runnable = new Runnable(){

        @Override
        public void run() {
            LoadingMaterial loadingMaterial = new LoadingMaterial();
            loadingMaterial.USER_ID = "MES001";
            loadingMaterial.BoardTypeCode = "324";
            loadingMaterial.FAILURE_CODE = "2342";
            loadingMaterial.RESULT = "pass";
            loadingMaterial.LOCATION_ID = 0;
            loadingMaterial.STATION_NAME = "smt";
            loadingMaterial.PROJECT_NAME = "smt";
            result =  CallWebService(loadingMaterial);
            Message msg = new Message();
            msg.obj = result;
            handler.sendMessage(msg);

        }

    };

    @SuppressLint("LongLogTag")
    public String CallWebService(LoadingMaterial loadingMaterial){
        //指定的命名空间和调用的方法名
        SoapObject request = new SoapObject(NameSpace, MethodName);

        //设置需调用接口需要传入的参数
//        request.addProperty("userID", "MES001");
//        request.addProperty("password", "888");
//        request.addProperty("language", "chinese");
//        request.addProperty("resultMsg", "");
        request.addProperty("LoadingMaterial", loadingMaterial);

        // 生成调用方法的SOAP请求信息,并指定SOAP的版本
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);

        // 下面这两句是一样的作用，写一句就行了
        envelope.bodyOut = request;
//        envelope.setOutputSoapObject(request);
        envelope.implicitTypes = true;
        // 设置是否调用的是dotNet开发的WebService
        envelope.dotNet = true;
        HttpTransportSE transport = new HttpTransportSE(URL);
        try {
            // 调用
            transport.call(SOAP_ACTION, envelope);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 获取返回的数据
        SoapObject object = (SoapObject) envelope.bodyIn;
        if(null==object){
            return "";
        }
        String result = object.getProperty(0).toString();

        // 获取返回的结果
        Log.e("WcfActivity++++++++++++++++++++++++++++++++++","WCF返回的数据是：" +result);

        System.out.println(result);

//        DefaultHttpClient httpClient = new DefaultHttpClient();
//
//        HttpResponse response = httpClient.execute(request);
//
//        HttpEntity responseEntity = response.getEntity();



//        Log.d("WCF", retrieveInputStream(responseEntity));
        return result;
    }


    protected String retrieveInputStream(HttpEntity httpEntity) {

        int length = (int) httpEntity.getContentLength();

        if (length < 0)

            length = 10000;

        StringBuffer stringBuffer = new StringBuffer(length);

        try {

            InputStreamReader inputStreamReader = new InputStreamReader(httpEntity.getContent(), HTTP.UTF_8);

            char buffer[] = new char[length];

            int count;

            while ((count = inputStreamReader.read(buffer, 0, length - 1)) > 0) {

                stringBuffer.append(buffer, 0, count);

            }

        } catch (UnsupportedEncodingException e) {



        } catch (IllegalStateException e) {



        } catch (IOException e) {



        }

        return stringBuffer.toString();

    }

}
