package com.lzy.demo.widget.hellocharts.listener;


import com.lzy.demo.widget.hellocharts.model.PointValue;

public interface LineChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int lineIndex, int pointIndex, PointValue value);

}
