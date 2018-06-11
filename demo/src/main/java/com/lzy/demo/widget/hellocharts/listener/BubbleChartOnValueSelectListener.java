package com.lzy.demo.widget.hellocharts.listener;


import com.lzy.demo.widget.hellocharts.model.BubbleValue;

public interface BubbleChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int bubbleIndex, BubbleValue value);

}
