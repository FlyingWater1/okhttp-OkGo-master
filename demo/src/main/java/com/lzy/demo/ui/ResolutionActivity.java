package com.lzy.demo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.demo.R;
import com.lzy.demo.base.BaseActivity;
import com.vondear.rxtools.activity.ActivityScanerCode;

public class ResolutionActivity extends BaseActivity implements View.OnClickListener{
    private static final int SCAN_REQUEST_CODE = 100;
    private static final int CAMERA_PERMISSION = 110;
    EditText reel_id_new,reel_id_raw;
    TextView scan_code_new,scan_code_raw;
    TextView resolution_btn;
    LinearLayout resolution_liner,new_liner,raw_liner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolution);
        initView();
    }

    private void initView() {
        reel_id_raw = (EditText)findViewById(R.id.reel_id_raw);
        reel_id_new = (EditText)findViewById(R.id.reel_id_new);
        scan_code_raw = (TextView)findViewById(R.id.scan_code_raw);
        scan_code_new = (TextView)findViewById(R.id.scan_code_new);
        raw_liner = (LinearLayout) findViewById(R.id.raw_liner);
        new_liner = (LinearLayout)findViewById(R.id.new_liner);
        resolution_liner = (LinearLayout)findViewById(R.id.resolution_liner);
        resolution_btn = (TextView)findViewById(R.id.resolution_btn);
        scan_code_raw.setOnClickListener(this);
        scan_code_new.setOnClickListener(this);
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SCAN_REQUEST_CODE) {
                //Todo Handle the isbn number entered manually
                String isbn = data.getStringExtra("isbn_code");
                if (!TextUtils.isEmpty(isbn)) {
                    vibrate();
                    //todo something
                    Toast.makeText(this, "解析到的内容为" + isbn, Toast.LENGTH_LONG).show();
                    if (isbn.contains("http")) {
                        Intent intent = new Intent(this, com.lzy.demo.WebViewActivity.class);
                        intent.putExtra(com.lzy.demo.WebViewActivity.RESULT, isbn);
                        startActivity(intent);
                    }else{
                        reel_id_raw.setText(isbn);
                        reel_id_raw.setSelection(isbn.length());//将光标移至文字末尾
                        raw_liner.setVisibility(View.GONE);
                        new_liner.setVisibility(View.VISIBLE);
                    }
                }
            }else{
                String isbn = data.getStringExtra("isbn_code");
                if (!TextUtils.isEmpty(isbn)) {
                    vibrate();
                    //todo something
                    Toast.makeText(this, "解析到的内容为" + isbn, Toast.LENGTH_LONG).show();
                    if (isbn.contains("http")) {
                        Intent intent = new Intent(this, com.lzy.demo.WebViewActivity.class);
                        intent.putExtra(com.lzy.demo.WebViewActivity.RESULT, isbn);
                        startActivity(intent);
                    }else{
                        reel_id_new.setText(isbn);
                        reel_id_new.setSelection(isbn.length());//将光标移至文字末尾
                        new_liner.setVisibility(View.GONE);
                        resolution_liner.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scan_code_raw:
                startActivityForResult(new Intent(this,ActivityScanerCode.class),SCAN_REQUEST_CODE);
                break;
            case R.id.scan_code_new:
                startActivityForResult(new Intent(this,ActivityScanerCode.class),CAMERA_PERMISSION);
                break;
        }
    }
}
