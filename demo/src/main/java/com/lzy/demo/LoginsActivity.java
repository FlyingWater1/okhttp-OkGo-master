package com.lzy.demo;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.ui.ImsActivity;
import com.lzy.demo.ui.JellyInterpolator;
import com.lzy.demo.widget.CardPickerDialog;
import com.lzy.demo.widget.ThemeHelper;
import com.vondear.rxtools.view.RxToast;
import com.vondear.rxtools.view.dialog.RxDialogLoading;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Random;

import butterknife.ButterKnife;

import static com.lzy.demo.logcollector.utils.LogCollectorUtility.REQUEST_READ_PHONE_STATE;

public class LoginsActivity extends BaseActivity implements View.OnClickListener,CardPickerDialog.ClickListener{
//
//    @Bind(R.id.et_username)
//    EditText etUsername;
//    @Bind(R.id.et_password)
//    EditText etPassword;
//    @Bind(R.id.bt_go)
//    Button btGo;
//    @Bind(R.id.cv)
//    CardView cv;
//    @Bind(R.id.fab)
//    FloatingActionButton fab;

    private TextView mBtnLogin;

    private View progress;

    private View mInputLayout;

    private float mWidth, mHeight;

    private LinearLayout mName;

    RelativeLayout mPsw;

    private EditText edit_username,edit_password;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private CheckBox checkBox;

    RxDialogLoading rxDialogLoading;

    ImageView change_theme;


    static String NameSpace = "http://tempuri.org/";
    static String URL="http://192.168.20.243:8080/UserLoginService.svc";
    static String SOAP_ACTION="http://tempuri.org/IUserLoginService/ValidateUser";
    static String MethodName="ValidateUser";

    String result;

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            rxDialogLoading.dismiss();
            if (msg.obj.toString().equals("true")){
                editor.putString("username", edit_username.getText().toString());
                editor.putString("password", edit_password.getText().toString());
                editor.commit();
                startActivity(new Intent(LoginsActivity.this, ImsActivity.class));
            }else{
                RxToast.warning(LoginsActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT, true).show();
            }
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login2);
        ButterKnife.bind(this);
//        this.setTheme(R.style.AppTheme_NoActionBar);
        preferences = getSharedPreferences(GApp.MODE_PRENAME,MODE_PRIVATE);
        editor = preferences.edit();
        initView();
        edit_username.setText(preferences.getString("username",""));
        edit_password.setText(preferences.getString("password",""));
        rxDialogLoading = new RxDialogLoading(this);
        rxDialogLoading.setCanceledOnTouchOutside(false);

    }

    private void initView() {
        mBtnLogin = (TextView) findViewById(R.id.main_btn_login);
        progress = findViewById(R.id.layout_progress);
        mInputLayout = findViewById(R.id.input_layout);
        mName = (LinearLayout) findViewById(R.id.input_layout_name);
        mPsw = (RelativeLayout) findViewById(R.id.input_layout_psw);
        edit_username = findView(R.id.edit_username);
        edit_password = findView(R.id.edit_password);
        change_theme = findView(R.id.change_theme);

        mBtnLogin.setOnClickListener(this);

        change_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTheme();
            }
        });

        checkBox=(CheckBox) findViewById(R.id.cbDisplayPassword);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if(isChecked){
                    //如果选中，显示密码
                    edit_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    //否则隐藏密码
                    edit_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }

            }
        });
    }

    @Override
    public void onClick(View v) {

        rxDialogLoading.show();
        mWidth = mBtnLogin.getMeasuredWidth();
        mHeight = mBtnLogin.getMeasuredHeight();
        if (edit_username.getText().toString().equals("") || edit_password.getText().toString().equals("")){
//            RxToast.normal(LoginsActivity.this, "这是一个普通的没有ICON的Toast").show();


//            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.xxmassdeveloper.mpchartexample");
//            startActivity(LaunchIntent);

            rxDialogLoading.dismiss();
//            startActivity(new Intent(LoginsActivity.this, ImsActivity.class));
//            finish();
            RxToast.warning(LoginsActivity.this, "用户名、密码不能为空!", Toast.LENGTH_SHORT, true).show();
//            RxToast.Tipinfo(LoginsActivity.this, "这是一个提示信息的Toast.", Toast.LENGTH_SHORT, true).show();
            return;
        }else {


            mName.setVisibility(View.INVISIBLE);
            mPsw.setVisibility(View.INVISIBLE);

            inputAnimator(mInputLayout, mWidth, mHeight);
        }

    }


    Runnable runnable = new Runnable(){

        @Override
        public void run() {
//            editor.putString("username", edit_username.getText().toString());
//            editor.putString("password", edit_password.getText().toString());
            result =  CallWebService(edit_username.getText().toString(),edit_password.getText().toString());
            Message msg = new Message();
            msg.obj = result;
            handler.sendMessage(msg);

        }

    };


    @SuppressLint("LongLogTag")
    public String CallWebService(String username,String pass){
        //指定的命名空间和调用的方法名
        SoapObject request = new SoapObject(NameSpace, MethodName);

        //设置需调用接口需要传入的参数
        request.addProperty("userID", username);
        request.addProperty("password", pass);
        request.addProperty("language", "chinese");
        request.addProperty("resultMsg", "");

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
        Log.e("LoginsActivity++++++++++++++++++++++++++++++++++","WCF返回的数据是：" +result);

        System.out.println(result);
        return result;
    }


    public void setTheme(){
        CardPickerDialog dialog = new CardPickerDialog();
        dialog.setClickListener(this);
        dialog.show(getSupportFragmentManager(), CardPickerDialog.TAG);
    }




    public void onLogin(String username,String password) {
            EasyHttp.get("http://192.168.50.100:7002/api/Values?userName=" + username + "&password=" + password + "&language=chinese")
                    .baseUrl("http://192.168.50.100:7002")
//                    .readTimeOut(10 * 1000)//局部定义读超时 ,可以不用定义
//                    .writeTimeOut(10 * 1000)
                    .connectTimeout(10 * 1000)
                    //.headers("","")//设置头参数
                    //.params("name","张三")//设置参数
                    //.addInterceptor()
                    //.addConverterFactory()
                    //.addCookie()
                    .timeStamp(true)
                    .execute(new SimpleCallBack<String>() {
                        @Override
                        public void onError(ApiException e) {

                            RxToast.error(LoginsActivity.this, "这是一个提示错误的Toast！", Toast.LENGTH_SHORT, true).show();
                            rxDialogLoading.cancel(e.getMessage());
                            showToast(e.getMessage());
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    recovery();

                                }
                            }, 2000);
                        }

                        @Override
                        public void onSuccess(String response) {

                            rxDialogLoading.dismiss();
                            Log.e("请求成功：", response.toString());
                            try {
                                JSONObject jsonObject = new JSONObject(response);//每一层都是一个Object对象
                                String code = jsonObject.getString("Code");
                                String value = jsonObject.getString("Value");
                                if (code.equals("success")) {
                                    RxToast.success(LoginsActivity.this, "这是一个提示成功!", Toast.LENGTH_SHORT, true).show();
//                                    mBtnLogin.setText(R.string.soldre_tin);
//                                    SharedPreferences.Editor editor = getSharedPreferences(GApp.MODE_PRENAME,MODE_PRIVATE).edit();
                                    editor.putString("username", edit_username.getText().toString());
                                    editor.putString("password", edit_password.getText().toString());
                                    editor.commit();
                                    startActivity(new Intent(LoginsActivity.this, ImsActivity.class));
                                    finish();
                                } else {
                                    RxToast.error(LoginsActivity.this, value, Toast.LENGTH_SHORT, true).show();
                                    new Handler().postDelayed(new Runnable() {
                                        public void run() {
                                            recovery();

                                        }
                                    }, 2000);
                                }
                            }catch (Exception e){
                                e.getMessage();
                            }
                        }
                    });

    }

    private void inputAnimator(final View view, float w, float h) {



        ValueAnimator animator = ValueAnimator.ofFloat(0, w);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                params.leftMargin = (int) value;
                params.rightMargin = (int) value;
                view.setLayoutParams(params);
            }
        });
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mInputLayout, "scaleX", 1f, 0.5f);
        set.setDuration(1000);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.playTogether(animator, animator2);
        set.start();
        set.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                progress.setVisibility(View.VISIBLE);
                progressAnimator(progress);
                mInputLayout.setVisibility(View.INVISIBLE);

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        recovery();
                        new Thread(runnable).start();
//                        onLogin(edit_username.getText().toString(),edit_password.getText().toString());
                    }
                }, 500);

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // TODO Auto-generated method stub

            }
        });

    }

    private void progressAnimator(final View view) {
        PropertyValuesHolder animator = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1f);
        PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(view, animator, animator2);
        animator3.setDuration(1000);
        animator3.setInterpolator(new JellyInterpolator());
        animator3.start();

    }

    /**
     * 恢复初始状态
     */
    private void recovery() {
        progress.setVisibility(View.GONE);
        mInputLayout.setVisibility(View.VISIBLE);
        mName.setVisibility(View.VISIBLE);
        mPsw.setVisibility(View.VISIBLE);

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mInputLayout.getLayoutParams();
        params.leftMargin = 0;
        params.rightMargin = 0;
        mInputLayout.setLayoutParams(params);


        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mInputLayout, "scaleX", 0.5f,1f );
        animator2.setDuration(500);
        animator2.setInterpolator(new AccelerateDecelerateInterpolator());
        animator2.start();



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
                Log.e("imei", "permission is granted after requested！");
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                Log.e("imei", "permission is not granted after requested！");
                //这里表示申请权限后被用户拒绝了
                finish();
            } else {
                Log.e("imei", "permission is not granted after requested！");
            }
        }
    }

    @Override
    public void onConfirm(int currentTheme) {
        if (ThemeHelper.getTheme(LoginsActivity.this) != currentTheme) {
            ThemeHelper.setTheme(LoginsActivity.this, currentTheme);
            ThemeUtils.refreshUI(LoginsActivity.this, new ThemeUtils.ExtraRefreshable() {
                        @Override
                        public void refreshGlobal(Activity activity) {
                            //for global setting, just do once
                            if (Build.VERSION.SDK_INT >= 21) {
                                final LoginsActivity context = LoginsActivity.this;
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


    private int getSnackColor(int current) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return getResources().getColor(getResources().getIdentifier(
                "magicasrkura_color_" + random.nextInt(8), "color", getPackageName()));
    }
}
