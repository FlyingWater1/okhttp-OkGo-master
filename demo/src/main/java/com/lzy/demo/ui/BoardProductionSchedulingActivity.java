package com.lzy.demo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.widget.TextView;

import com.lzy.demo.R;
import com.lzy.demo.base.BaseActivity;

import butterknife.Bind;

public class BoardProductionSchedulingActivity extends BaseActivity {

    @Bind(R.id.date)
    TextView date;
    @Bind(R.id.time)
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_production_scheduling);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);

//        date.setText(System.currentTimeMillis()+"");

        new TimeThread().start(); //启动新的线程


    }

    class TimeThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;  //消息(一个整型值)
                    mHandler.sendMessage(msg);// 每隔1秒发送一个msg给mHandler
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    //在主线程里面处理消息并更新UI界面
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    long sysTime = System.currentTimeMillis();
                    CharSequence sysDateStr = DateFormat.format("yyyy-MM-dd", sysTime);
                    CharSequence sysTimeStr = DateFormat.format("yyyy-MM-dd EEEE HH:mm:ss", sysTime);

                    date.setText(sysDateStr); //更新时间
                    time.setText(sysTimeStr); //更新时间
                    break;
                 default:
                 break;

            }
        }
    };


}
