package com.lzy.demo.widget.hellocharts.formatter;


import com.lzy.demo.widget.hellocharts.model.PointValue;

public interface LineChartValueFormatter {

    public int formatChartValue(char[] formattedValue, PointValue value);
}
