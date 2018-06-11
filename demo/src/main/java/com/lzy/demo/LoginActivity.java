package com.lzy.demo;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.widget.CardPickerDialog;
import com.lzy.demo.widget.ThemeHelper;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.lzy.demo.logcollector.utils.LogCollectorUtility.REQUEST_READ_PHONE_STATE;

public class LoginActivity extends BaseActivity implements ActivityCompat.OnRequestPermissionsResultCallback,CardPickerDialog.ClickListener {

//    @Bind(R.id.et_username)
    EditText etUsername;
//    @Bind(R.id.et_password)
    EditText etPassword;
//    @Bind(R.id.bt_go)
    TextView btGo;
//    @Bind(R.id.cv)
    CardView cv;
//    @Bind(R.id.fab)
    FloatingActionButton fab;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btGo = (TextView) findViewById(R.id.bt_go);
        cv = (CardView) findViewById(R.id.cv);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    public void setTheme(){
        CardPickerDialog dialog = new CardPickerDialog();
        dialog.setClickListener(LoginActivity.this);
        dialog.show(getSupportFragmentManager(), CardPickerDialog.TAG);
    }

    @OnClick({R.id.bt_go,
            R.id.fab,
            R.id.change_theme,
            R.id.btn_red,
            R.id.btn_pink,
            R.id.btn_purple,
            R.id.btn_blue,
            R.id.btn_green,
            R.id.btn_blue_grey})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options =
                            ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                    startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
                } else {
                    startActivity(new Intent(this, RegisterActivity.class));
                }
                break;
            case R.id.bt_go:
                Explode explode = new Explode();
                explode.setDuration(500);

                getWindow().setExitTransition(explode);
                getWindow().setEnterTransition(explode);
                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                Intent i2 = new Intent(this, LoginsActivity.class);
                startActivity(i2, oc2.toBundle());
//                finish();
                break;


            case R.id.change_theme:
                CardPickerDialog dialog = new CardPickerDialog();
                dialog.setClickListener(LoginActivity.this);
                dialog.show(getSupportFragmentManager(), CardPickerDialog.TAG);
//                Aesthetic.get()
//                        .colorPrimaryRes(R.color.pink_400)
////                        .textColorPrimaryRes(R.color.pink_400)
//                        .colorAccentRes(R.color.md_purple)
//                        .colorStatusBarAuto()
//                        .colorNavigationBarAuto()
//                        .bottomNavigationBackgroundMode(BottomNavBgMode.PRIMARY_DARK)
//                        .bottomNavigationIconTextMode(BottomNavIconTextMode.BLACK_WHITE_AUTO)
//                        .apply();
                break;
            case R.id.btn_red:
//                Aesthetic.get()
//                        .colorPrimaryRes(R.color.red_400)
//                        .colorAccentRes(R.color.md_amber)
//                        .colorStatusBarAuto()
//                        .colorNavigationBarAuto()
//                        .bottomNavigationBackgroundMode(BottomNavBgMode.PRIMARY_DARK)
//                        .bottomNavigationIconTextMode(BottomNavIconTextMode.BLACK_WHITE_AUTO)
//                        .apply();
                break;
            case R.id.btn_purple:
//                Aesthetic.get()
//                        .colorPrimaryRes(R.color.purple_400)
//                        .colorAccentRes(R.color.md_lime)
//                        .colorStatusBarAuto()
//                        .colorNavigationBarAuto()
//                        .bottomNavigationBackgroundMode(BottomNavBgMode.PRIMARY_DARK)
//                        .bottomNavigationIconTextMode(BottomNavIconTextMode.BLACK_WHITE_AUTO)
//                        .apply();
                break;
            case R.id.btn_blue:
//                Aesthetic.get()
//                        .colorPrimaryRes(R.color.blue_400)
//                        .colorAccentRes(R.color.md_pink)
//                        .colorStatusBarAuto()
//                        .colorNavigationBarAuto()
//                        .bottomNavigationBackgroundMode(BottomNavBgMode.PRIMARY_DARK)
//                        .bottomNavigationIconTextMode(BottomNavIconTextMode.BLACK_WHITE_AUTO)
//                        .apply();
                break;
            case R.id.btn_blue_grey:
//                Aesthetic.get()
//                        .colorPrimaryRes(R.color.blue_grey_400)
//                        .colorAccentRes(R.color.md_pink)
//                        .colorStatusBarAuto()
//                        .colorNavigationBarAuto()
//                        .bottomNavigationBackgroundMode(BottomNavBgMode.PRIMARY_DARK)
//                        .bottomNavigationIconTextMode(BottomNavIconTextMode.BLACK_WHITE_AUTO)
//                        .apply();
                break;
            case R.id.btn_green:
//                setTheme(R.style.GreenTheme);
//                Aesthetic.get()
//                        .colorPrimaryRes(R.color.green_400)
//                        .colorAccentRes(R.color.md_blue_grey)
//                        .colorStatusBarAuto()
//                        .colorNavigationBarAuto()
//                        .bottomNavigationBackgroundMode(BottomNavBgMode.PRIMARY_DARK)
//                        .bottomNavigationIconTextMode(BottomNavIconTextMode.BLACK_WHITE_AUTO)
//                        .apply();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        } else {
            //TODO
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_READ_PHONE_STATE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("imei", "permission is granted after requested！");
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Log.d("imei", "permission is not granted after requested！");
                //这里表示申请权限后被用户拒绝了
                finish();
            } else {
                Log.d("imei", "permission is not granted after requested！");
            }
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ThemeUtils.getColorById(this, R.color.theme_color_primary_dark));
            ActivityManager.TaskDescription description = new ActivityManager.TaskDescription(null, null,
                    ThemeUtils.getThemeAttrColor(this, android.R.attr.colorPrimary));
            setTaskDescription(description);
        }
    }

    @Override
    public void onConfirm(int currentTheme) {
        if (ThemeHelper.getTheme(LoginActivity.this) != currentTheme) {
            ThemeHelper.setTheme(LoginActivity.this, currentTheme);
            ThemeUtils.refreshUI(LoginActivity.this, new ThemeUtils.ExtraRefreshable() {
                        @Override
                        public void refreshGlobal(Activity activity) {
                            //for global setting, just do once
                            if (Build.VERSION.SDK_INT >= 21) {
                                final LoginActivity context = LoginActivity.this;
                                ActivityManager.TaskDescription taskDescription =
                                        new ActivityManager.TaskDescription(null, null,
                                                ThemeUtils.getThemeAttrColor(context, android.R.attr.colorPrimary));
                                setTaskDescription(taskDescription);
                                getWindow().setStatusBarColor(
                                        ThemeUtils.getColorById(context, R.color.theme_color_primary_dark));
                            }
                        }

                        @Override
                        public void refreshSpecificView(View view) {
                            //TODO: will do this for each traversal
                        }
                    }
            );

        }
    }
}
