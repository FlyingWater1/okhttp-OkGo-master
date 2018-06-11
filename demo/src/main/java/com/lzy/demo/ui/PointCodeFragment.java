package com.lzy.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzy.demo.R;
import com.lzy.demo.base.BaseFragment;
import com.vondear.rxtools.view.RxBarCode;
import com.vondear.rxtools.view.RxQRCode;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PointCodeFragment extends BaseFragment {

    @Bind(R.id.iv_linecode)
    ImageView mIvLinecode;
    @Bind(R.id.iv_code)
    ImageView mIvCode;
    @Bind(R.id.left_text)
    TextView mTextViewleft;
    @Bind(R.id.center_text)
    TextView mTextViewcenter;
    @Bind(R.id.right_text)
    TextView mTextViewright;

    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_point_code, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initView() {
        mTextViewleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(),ActivityCobweb.class));

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.LEFT|Gravity.CENTER;
//                params.leftMargin = 10;
                params.rightMargin =10;
                mIvLinecode.setLayoutParams(params);
                mIvCode.setLayoutParams(params);
            }
        });

        mTextViewcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.CENTER;
                mIvLinecode.setLayoutParams(params);
                mIvCode.setLayoutParams(params);
            }
        });

        mTextViewright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.RIGHT|Gravity.CENTER;
                params.leftMargin = 10;
//                params.rightMargin =120;
                mIvLinecode.setLayoutParams(params);
                mIvCode.setLayoutParams(params);
            }
        });
    }



    public void initData() {
        // TODO Auto-generated method stub
        RxQRCode.createQRCode("时间戳:" + System.currentTimeMillis(), 600, 600, mIvCode);
//        mIvLinecode.setImageBitmap(RxBarCode.createBarCode("" + System.currentTimeMillis(), 800, 300));

        //条形码生成方式一  推荐此方法
        RxBarCode.builder("" + System.currentTimeMillis()).
                backColor(getResources().getColor(com.vondear.rxtools.R.color.transparent)).
                codeColor(getResources().getColor(com.vondear.rxtools.R.color.black)).
                codeWidth(400).
                codeHeight(100).
                into(mIvLinecode);
    }
}
