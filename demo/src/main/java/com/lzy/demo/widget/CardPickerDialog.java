/*
 * Copyright (C) 2016 Bilibili
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lzy.demo.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.lzy.demo.R;


/**
 * @author xyczero
 * @time 16/5/29
 */
public class CardPickerDialog extends DialogFragment implements View.OnClickListener {
    public static final String TAG = "CardPickerDialog";
    ImageView[] mCards = new ImageView[12];
    Button mConfirm;
    Button mCancel;

    private int mCurrentTheme;
    private ClickListener mClickListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppTheme_AppCompat_Dialog_Alert);
        mCurrentTheme = ThemeHelper.getTheme(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_theme_picker, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCancel = (Button) view.findViewById(android.R.id.button2);
        mConfirm = (Button) view.findViewById(android.R.id.button1);
        mCards[0] = (ImageView) view.findViewById(R.id.theme_indigo);
        mCards[1] = (ImageView) view.findViewById(R.id.theme_purple);
        mCards[2] = (ImageView) view.findViewById(R.id.theme_blue);
        mCards[3] = (ImageView) view.findViewById(R.id.theme_green);
        mCards[4] = (ImageView) view.findViewById(R.id.theme_green_light);
        mCards[5] = (ImageView) view.findViewById(R.id.theme_yellow);
        mCards[6] = (ImageView) view.findViewById(R.id.theme_orange);
        mCards[7] = (ImageView) view.findViewById(R.id.theme_red);
        mCards[8] = (ImageView) view.findViewById(R.id.theme_brown_light);
        mCards[9] = (ImageView) view.findViewById(R.id.theme_brown);
        mCards[10] = (ImageView) view.findViewById(R.id.theme_cyan_light);
        mCards[11] = (ImageView) view.findViewById(R.id.theme_cyan);
        setImageButtons(mCurrentTheme);
        for (ImageView card : mCards) {
            card.setOnClickListener(this);
        }
        mCancel.setOnClickListener(this);
        mConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case android.R.id.button1:
                if (mClickListener != null) {
                    mClickListener.onConfirm(mCurrentTheme);
                }
            case android.R.id.button2:
                dismiss();
                break;
            case R.id.theme_indigo:
                mCurrentTheme = ThemeHelper.CARD_SAKURA;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_purple:
                mCurrentTheme = ThemeHelper.CARD_HOPE;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_blue:
                mCurrentTheme = ThemeHelper.CARD_STORM;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_green:
                mCurrentTheme = ThemeHelper.CARD_WOOD;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_green_light:
                mCurrentTheme = ThemeHelper.CARD_LIGHT;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_yellow:
                mCurrentTheme = ThemeHelper.CARD_THUNDER;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_orange:
                mCurrentTheme = ThemeHelper.CARD_SAND;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_red:
                mCurrentTheme = ThemeHelper.CARD_FIREY;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_brown_light:
                mCurrentTheme = ThemeHelper.CARD_BROWN_LIGHT;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_brown:
                mCurrentTheme = ThemeHelper.CARD_BROWN;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_cyan_light:
                mCurrentTheme = ThemeHelper.CARD_CYAN_LIGHT;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_cyan:
                mCurrentTheme = ThemeHelper.CARD_CYAN;
                setImageButtons(mCurrentTheme);
                break;
            default:
                break;
        }
    }

    private void setImageButtons(int currentTheme) {
        mCards[0].setSelected(currentTheme == ThemeHelper.CARD_SAKURA);
        mCards[1].setSelected(currentTheme == ThemeHelper.CARD_HOPE);
        mCards[2].setSelected(currentTheme == ThemeHelper.CARD_STORM);
        mCards[3].setSelected(currentTheme == ThemeHelper.CARD_WOOD);
        mCards[4].setSelected(currentTheme == ThemeHelper.CARD_LIGHT);
        mCards[5].setSelected(currentTheme == ThemeHelper.CARD_THUNDER);
        mCards[6].setSelected(currentTheme == ThemeHelper.CARD_SAND);
        mCards[7].setSelected(currentTheme == ThemeHelper.CARD_FIREY);
        mCards[8].setSelected(currentTheme == ThemeHelper.CARD_BROWN_LIGHT);
        mCards[9].setSelected(currentTheme == ThemeHelper.CARD_BROWN);
        mCards[10].setSelected(currentTheme == ThemeHelper.CARD_CYAN_LIGHT);
        mCards[11].setSelected(currentTheme == ThemeHelper.CARD_CYAN);
    }

    public void setClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    public interface ClickListener {
        void onConfirm(int currentTheme);
    }
}
