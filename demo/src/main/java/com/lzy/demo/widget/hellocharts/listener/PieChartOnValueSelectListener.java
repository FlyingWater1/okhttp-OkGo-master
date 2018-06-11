package com.lzy.demo.widget.hellocharts.listener;


import com.lzy.demo.widget.hellocharts.model.SliceValue;

public interface PieChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int arcIndex, SliceValue value);

}
