package com.lzy.demo.ui;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.lzy.demo.LoginsActivity;
import com.lzy.demo.R;
import com.lzy.demo.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    private ImageView iv_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        iv_bg = ((ImageView)findViewById(R.id.iv_bg));
        jump();
    }

    private void jump()
    {
        Animation localAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        localAnimation.setFillAfter(true);
        this.iv_bg.startAnimation(localAnimation);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
            public void onAnimationEnd(Animation paramAnonymousAnimation)
            {

//                do
//                {
//                    if ((ShareUtils.getIBoolean("IS_SMS_CHECK")) && (ShareUtils.getIBoolean("is_login")))
//                    {
//                        startActivity(new Intent(SplashActivity.this,LoginsActivity.class));
//                        finish();
//                        return;
//                    }
//                    if (!ShareUtils.getIBoolean("IS_SMS_CHECK"))
//                    {
//                        SplashActivity.this.skipActivity(MainActivity.class);
//                        SplashActivity.this.finish();
//                        return;
//                    }
//                } while ((!ShareUtils.getIBoolean("IS_SMS_CHECK")) || (ShareUtils.getIBoolean("is_login")));
                SplashActivity.this.skipActivity(LoginsActivity.class);
                SplashActivity.this.finish();
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {}

            public void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
    }
}
