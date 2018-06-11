package com.lzy.demo.widget.hellocharts.formatter;


import com.lzy.demo.widget.hellocharts.model.SubcolumnValue;

public interface ColumnChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SubcolumnValue value);

}
