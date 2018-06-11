package com.lzy.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.demo.R;
import com.lzy.demo.utils.ProgressDialogUtils;
import com.lzy.demo.utils.WebServiceUtils;

import org.ksoap2.serialization.SoapObject;

import java.util.HashMap;

/**
 * 显示天气的Activity
 *
 * @see
 *
 * @author xiaanming
 *
 */
public class WeatherActivity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather_layout);
		init();
	}

	private void init() {
		final TextView mTextWeather = (TextView) findViewById(R.id.weather);
		ProgressDialogUtils.showProgressDialog(this, "数据加载中...");
		HashMap<String, String> properties = new HashMap<String, String>();
		properties.put("theCityName", getIntent().getStringExtra("city"));

		WebServiceUtils.callWebService(WebServiceUtils.WEB_SERVER_URL, "getWeatherbyCityName", properties, new WebServiceUtils.WebServiceCallBack() {

			@Override
			public void callBack(SoapObject result) {
				ProgressDialogUtils.dismissProgressDialog();
				if(result != null){
					SoapObject detail = (SoapObject) result.getProperty("getWeatherbyCityNameResult");
					StringBuilder sb = new StringBuilder();
					for(int i=0; i<detail.getPropertyCount(); i++){
						sb.append(detail.getProperty(i)).append("\r\n");
					}
					mTextWeather.setText(sb.toString());
				}else{
					Toast.makeText(WeatherActivity.this, "获取WebService数据错误", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
