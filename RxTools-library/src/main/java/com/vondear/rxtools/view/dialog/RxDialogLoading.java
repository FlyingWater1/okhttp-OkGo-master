package com.vondear.rxtools.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.vondear.rxtools.R;
import com.vondear.rxtools.ThemeHelper;
import com.vondear.rxtools.view.RxToast;
import com.vondear.rxtools.view.progressing.SpinKitView;

/**
 * @author Vondear
 * @date 2017/3/16
 */

public class RxDialogLoading extends RxDialog {

    private SpinKitView mLoadingView;
    private View mDialogContentView;
    private TextView mTextView;

    public RxDialogLoading(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public RxDialogLoading(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public RxDialogLoading(Context context) {
        super(context);
        initView(context);
    }

    public RxDialogLoading(Activity context) {
        super(context);
        initView(context);
    }

    public RxDialogLoading(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    private void initView(Context context) {
        mDialogContentView = LayoutInflater.from(context).inflate(R.layout.dialog_loading_spinkit, null);
        mLoadingView = (SpinKitView) mDialogContentView.findViewById(R.id.spin_kit);
        mTextView = (TextView) mDialogContentView.findViewById(R.id.name);
        setContentView(mDialogContentView);

        if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_SAKURA) {
//            RxToast.normal("pink");
            mLoadingView.setColor(R.color.pink);
            return;
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_STORM) {
//            RxToast.normal("blue");
            mLoadingView.setColor(R.color.blue);
            return;
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_HOPE) {
//            RxToast.normal("purple");
            mLoadingView.setColor(R.color.purple);
            return;
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_WOOD) {
            mLoadingView.setColor(R.color.green);
            return;
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_LIGHT) {
            mLoadingView.setColor(R.color.green_light);
            return;
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_THUNDER) {
            mLoadingView.setColor(R.color.yellow);
            return;
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_SAND) {
            mLoadingView.setColor(R.color.orange);
            return;
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_FIREY) {
            mLoadingView.setColor(R.color.red);
            return;
        }else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_BROWN_LIGHT) {
            mLoadingView.setColor(R.color.brown_light);
            return;
        }else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_BROWN) {
            mLoadingView.setColor(R.color.brown);
            return;
        }else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_CYAN_LIGHT) {
            mLoadingView.setColor(R.color.cyan_light);
            return;
        }else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_CYAN) {
            mLoadingView.setColor(R.color.cyan);
            return;
        }
    }

    public void setLoadingText(CharSequence charSequence) {
        mTextView.setText(charSequence);
    }

    public void setLoadingColor(int color){
        mLoadingView.setColor(color);
    }

    public void cancel(RxCancelType code, String str) {
        cancel();
        switch (code) {
            case normal:
                RxToast.normal(str);
                break;
            case error:
                RxToast.error(str);
                break;
            case success:
                RxToast.success(str);
                break;
            case info:
                RxToast.info(str);
                break;
            default:
                RxToast.normal(str);
                break;
        }
    }

    public void cancel(String str) {
        cancel();
        RxToast.normal(str);
    }

    public SpinKitView getLoadingView() {
        return mLoadingView;
    }

    public View getDialogContentView() {
        return mDialogContentView;
    }

    public TextView getTextView() {
        return mTextView;
    }

    public enum RxCancelType {normal, error, success, info}
}
