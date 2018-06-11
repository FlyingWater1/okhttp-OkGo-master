package com.lzy.demo.widget.hellocharts.provider;


import com.lzy.demo.widget.hellocharts.model.LineChartData;

public interface LineChartDataProvider {

    public LineChartData getLineChartData();

    public void setLineChartData(LineChartData data);

}
