package com.lzy.demo.widget.hellocharts.formatter;


import com.lzy.demo.widget.hellocharts.model.SliceValue;

public interface PieChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SliceValue value);
}
