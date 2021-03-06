package com.lzy.demo.logcollector;

import android.content.Context;
import android.util.Log;

import com.lzy.demo.logcollector.capture.CrashHandler;
import com.lzy.demo.logcollector.upload.HttpParameters;
import com.lzy.demo.logcollector.upload.UploadLogManager;
import com.lzy.demo.logcollector.utils.Constants;
import com.lzy.demo.logcollector.utils.LogCollectorUtility;
import com.lzy.demo.logcollector.utils.LogHelper;


/**
 * @author jiabin
 */
public class LogCollector {

    private static final String TAG = LogCollector.class.getName();

    private static String Upload_Url;

    private static Context mContext;

    private static boolean isInit = false;

    private static HttpParameters mParams;

    public static void init(Context c, String upload_url, HttpParameters params) {

        if (c == null) {
            return;
        }

        if (isInit) {
            return;
        }

        Upload_Url = upload_url;
        mContext = c;
        mParams = params;

        CrashHandler crashHandler = CrashHandler.getInstance(c);
        crashHandler.init();

        isInit = true;

    }

    public static void upload(boolean isWifiOnly) {
        if (mContext == null || Upload_Url == null) {
            Log.d(TAG, "please check if init() or not");
            return;
        }
        if (!LogCollectorUtility.isNetworkConnected(mContext)) {
            return;
        }

        boolean isWifiMode = LogCollectorUtility.isWifiConnected(mContext);

        if (isWifiOnly && !isWifiMode) {
            return;
        }

        UploadLogManager.getInstance(mContext).uploadLogFile(Upload_Url, mParams);
    }

    public static void setDebugMode(boolean isDebug) {
        Constants.DEBUG = isDebug;
        LogHelper.enableDefaultLog = isDebug;
    }
}
