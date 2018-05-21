package com.lzy.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lzy.demo.R;
import com.lzy.demo.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityLogin extends BaseActivity {


    @Bind(R.id.login_btn)
    Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        ButterKnife.bind(this);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityLogin.this, ImsActivity.class));
                finish();
            }
        });
    }
}
