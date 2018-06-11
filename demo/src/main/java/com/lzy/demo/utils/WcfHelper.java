package com.lzy.demo.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lzy.demo.ui.WcfActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 54330 on 2018/5/29.
 */

public class WcfHelper {

    static String NameSpace = "http://tempuri.org/";
    static String URL="http://192.168.50.199:8070/UserLoginService.svc";
    static String SOAP_ACTION="http://tempuri.org/IUserLoginService/ValidateUser";
    static String MethodName="ValidateUser";
    WcfActivity wcf;
    public WcfHelper(WcfActivity wcf) {
        this.wcf = wcf;
    }
    private static final ExecutorService executorService = Executors
            .newFixedThreadPool(3);
    /**
     *
     * @param url
     *            WebService服务器地址
     * @param methodName
     *            WebService的调用方法名
     * @param properties
     *            WebService的参数
     * @param webServiceCallBack
     *            回调接口
     */
    public static void callWebService(String url, final String NameSpace, final String methodName,final String SOAP_ACTION,
                                      HashMap<String, String> properties,
                                      final WebServiceCallBack webServiceCallBack) {
        // 创建HttpTransportSE对象，传递WebService服务器地址
        final HttpTransportSE httpTransportSE = new HttpTransportSE(url,3000);
        // 创建SoapObject对象
        SoapObject soapObject = new SoapObject(NameSpace, methodName);

        // SoapObject添加参数
        if (properties != null) {
            for (Iterator<Map.Entry<String, String>> it = properties.entrySet()
                    .iterator(); it.hasNext();) {
                Map.Entry<String, String> entry = it.next();
                soapObject.addProperty(entry.getKey(), entry.getValue());
            }
        }

        // 实例化SoapSerializationEnvelope，传入WebService的SOAP协议的版本号
        final SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        // 设置是否调用的是.Net开发的WebService
        soapEnvelope.setOutputSoapObject(soapObject);
        soapEnvelope.dotNet = true;
        httpTransportSE.debug = true;

        // 用于子线程与主线程通信的Handler
        final Handler mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                // 将返回值回调到callBack的参数中
                webServiceCallBack.callBack((SoapObject) msg.obj);
            }

        };

        // 开启线程去访问WebService
        executorService.submit(new Runnable() {

            @SuppressLint("LongLogTag")
            @Override
            public void run() {
                SoapObject resultSoapObject = null;
                try {
                    httpTransportSE.call(SOAP_ACTION, soapEnvelope);
                    if (soapEnvelope.getResponse() != null) {
                        // 获取服务器响应返回的SoapObject
                        resultSoapObject = (SoapObject) soapEnvelope.bodyIn;
                    }
                } catch (HttpResponseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } finally {
                    // 将获取的消息利用Handler发送到主线程
                    mHandler.sendMessage(mHandler.obtainMessage(0,
                            resultSoapObject));
                    Log.e("WcfHelper++++++++++++++++++++++++++++++++++","soapObject.getPropertyCount()：" +resultSoapObject);
                }
            }
        });
    }
    /**
     *
     * @param url
     *            WebService服务器地址
     * @param methodName
     *            WebService的调用方法名
     * @param properties
     *            WebService的参数
     * @param webServiceCallBack
     *            回调接口
     */
    public static void callWebService(String url, final String NameSpace, final String methodName,final String SOAP_ACTION,
                                      String key,String value,
                                      HashMap<String, String> properties,
                                      final WebServiceCallBack webServiceCallBack) {
        // 创建HttpTransportSE对象，传递WebService服务器地址
        final HttpTransportSE httpTransportSE = new HttpTransportSE(url,3000);
        // 创建SoapObject对象
        SoapObject soapObject = new SoapObject(NameSpace, methodName);

        // SoapObject添加参数
        if (properties != null) {
            for (Iterator<Map.Entry<String, String>> it = properties.entrySet()
                    .iterator(); it.hasNext();) {
                Map.Entry<String, String> entry = it.next();
                soapObject.addProperty(entry.getKey(), entry.getValue());
            }
        }
//        soapObject.addProperty(key, value);

        // 实例化SoapSerializationEnvelope，传入WebService的SOAP协议的版本号
        final SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        // 设置是否调用的是.Net开发的WebService
        soapEnvelope.setOutputSoapObject(soapObject);
        soapEnvelope.dotNet = true;
        httpTransportSE.debug = true;

        // 用于子线程与主线程通信的Handler
        final Handler mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                // 将返回值回调到callBack的参数中
                webServiceCallBack.callBack((SoapObject) msg.obj);
            }

        };

        // 开启线程去访问WebService
        executorService.submit(new Runnable() {

            @SuppressLint("LongLogTag")
            @Override
            public void run() {
                SoapObject resultSoapObject = null;
                try {
                    httpTransportSE.call(SOAP_ACTION, soapEnvelope);
                    if (soapEnvelope.getResponse() != null) {
                        // 获取服务器响应返回的SoapObject
                        resultSoapObject = (SoapObject) soapEnvelope.bodyIn;
                    }
                } catch (HttpResponseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } finally {
                    // 将获取的消息利用Handler发送到主线程
                    mHandler.sendMessage(mHandler.obtainMessage(0,
                            resultSoapObject));
                    Log.e("WcfHelper++++++++++++++++++++++++++++++++++","soapObject.getPropertyCount()：" +resultSoapObject);
                }
            }
        });
    }

    /**
     *
     *
     * @author xiaanming
     *
     */
    public interface WebServiceCallBack {
        public void callBack(SoapObject result);
    }


    /**
     * POST请求无参数
     * */
    public String speak() {
        String result = null;
        try {
            HttpPost request = new HttpPost(
                    "http://localhost:8070/UserLoginService.svc");

            HttpResponse httpResponse = new DefaultHttpClient()
                    .execute(request);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = retrieveInputStream(httpResponse.getEntity());
                Log.v("POST====>", result);
                Message msg = new Message();
                msg.obj = result;
                wcf.handler.sendMessage(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * POST请求带参数
     * */
    public String speakHello() {
        String result = null;
        try {
            HttpPost request = new HttpPost(
                    "http://192.168.50.199:8070/UserLoginService.svc");
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            // 先封装一个 JSON 对象
            JSONObject param = new JSONObject();
            param.put("userID", "MES001");
            // 绑定到请求 Entry
            StringEntity se = new StringEntity(param.toString());
            request.setEntity(se);

            // 发送请求
            HttpResponse httpResponse = new DefaultHttpClient()
                    .execute(request);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = retrieveInputStream(httpResponse.getEntity());
                Log.v("POST====>", result);
                Message msg = new Message();
                msg.obj = result;
                wcf.handler.sendMessage(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * GET方法调用带参数
     * */
    public String sayHello() {
        String result = null;
        try {

            HttpGet request = new HttpGet(
                    "http://localhost:8070/UserLoginService.svc");
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse httpResponse = httpClient.execute(request);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = retrieveInputStream(httpResponse.getEntity());
                Log.v("POST====>", result);
                Message msg = new Message();
                msg.obj = result;
                wcf.handler.sendMessage(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * GET方法调用不带参数
     * */
    public String say() {
        String result = null;
        try {

            HttpGet request = new HttpGet("http://localhost:8070/UserLoginService.svc");
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse httpResponse = httpClient.execute(request);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = retrieveInputStream(httpResponse.getEntity());
                Log.v("POST====>", result);
                Message msg = new Message();
                msg.obj = result;
                wcf.handler.sendMessage(msg);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }

    protected String retrieveInputStream(HttpEntity httpEntity) {
        int length = (int) httpEntity.getContentLength();
        if (length < 0)
            length = 10000;
        StringBuffer stringBuffer = new StringBuffer(length);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(
                    httpEntity.getContent(), HTTP.UTF_8);
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
