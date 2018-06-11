package com.lzy.demo.widget.hellocharts.formatter;


import com.lzy.demo.widget.hellocharts.model.BubbleValue;

public interface BubbleChartValueFormatter {

    public int formatChartValue(char[] formattedValue, BubbleValue value);
}
