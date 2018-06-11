package com.lzy.demo.utils;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by 54330 on 2018/5/30.
 */

public class HelloService implements ISoapService {
    static String NameSpace = "http://tempuri.org/";
    static String URL="http://192.168.50.199:8070/UserService.svc";
    static String SOAP_ACTION="http://tempuri.org/IUserService/GetRightsAndRolesOfUser";
    static String MethodName="GetRightsAndRolesOfUser";

    private String words;

    public HelloService(String words) {
        this.words = words;
    }

    public SoapObject LoadResult() {
        SoapObject soapObject = new SoapObject(NameSpace, MethodName);
        soapObject.addProperty("userId", "mes001");
        soapObject.addProperty("resultMsg", "");
        soapObject.addProperty("logUser", "");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12); // 版本
        envelope.bodyOut = soapObject;
        envelope.dotNet = true;
        envelope.setOutputSoapObject(soapObject);

        HttpTransportSE trans = new HttpTransportSE(URL);
        trans.debug = true; // 使用调试功能

        try {
            trans.call(SOAP_ACTION, envelope);
            System.out.println("Call Successful!");
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            System.out.println("XmlPullParserException");
            e.printStackTrace();
        }

        SoapObject result = (SoapObject) envelope.bodyIn;

        return result;
    }
}