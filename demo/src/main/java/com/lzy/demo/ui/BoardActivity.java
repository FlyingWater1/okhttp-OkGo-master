package com.lzy.demo.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.SeekBar;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.lzy.demo.R;
import com.lzy.demo.base.DemoBase;
import com.lzy.demo.base.MyAxisValueFormatter;
import com.lzy.demo.base.MyValueFormatter;
import com.lzy.demo.utils.CircleProgressBar;
import com.lzy.demo.utils.TimeUtils;
import com.lzy.demo.widget.hellocharts.gesture.ContainerScrollType;
import com.lzy.demo.widget.hellocharts.model.Axis;
import com.lzy.demo.widget.hellocharts.model.AxisValue;
import com.lzy.demo.widget.hellocharts.model.Column;
import com.lzy.demo.widget.hellocharts.model.ColumnChartData;
import com.lzy.demo.widget.hellocharts.model.Line;
import com.lzy.demo.widget.hellocharts.model.LineChartData;
import com.lzy.demo.widget.hellocharts.model.PointValue;
import com.lzy.demo.widget.hellocharts.model.SubcolumnValue;
import com.lzy.demo.widget.hellocharts.model.ValueShape;
import com.lzy.demo.widget.hellocharts.model.Viewport;
import com.lzy.demo.widget.hellocharts.util.CommonUtils;
import com.lzy.demo.widget.hellocharts.view.ColumnChartView;
import com.lzy.demo.widget.hellocharts.view.LineChartView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BoardActivity extends DemoBase implements SeekBar.OnSeekBarChangeListener, OnChartValueSelectedListener {
//    @Bind(R.id.line_progress)
    private CircleProgressBar mLineProgressBar;
//    @Bind(R.id.solid_progress)
    private CircleProgressBar mSolidProgressBar;
//    @Bind(R.id.custom_progress1)
    private CircleProgressBar mCustomProgressBar1;
//    @Bind(R.id.custom_progress3)
    private CircleProgressBar mCustomProgressBar2;

//    @Bind(R.id.chart)
    ColumnChartView columnChartView;
//    @Bind(R.id.lineView)
    LineChartView lineChartView;

//    @Bind(R.id.scroll_view)
    ScrollView scrollView;


    private BarChart mChart;
    private SeekBar mSeekBarX, mSeekBarY;

    DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        mLineProgressBar = (CircleProgressBar) findViewById(R.id.line_progress);
        mSolidProgressBar = (CircleProgressBar) findViewById(R.id.solid_progress);
        mCustomProgressBar1 = (CircleProgressBar) findViewById(R.id.custom_progress1);
        mCustomProgressBar2 = (CircleProgressBar) findViewById(R.id.custom_progress3);
        mLineProgressBar.setProgress(40);
        mSolidProgressBar.setProgress(80);
        mCustomProgressBar1.setProgress(70);
        mCustomProgressBar2.setProgress(50);
        mSolidProgressBar.setStyle(CircleProgressBar.SOLID);

        columnChartView = (ColumnChartView) findViewById(R.id.chart);
        lineChartView = (LineChartView) findViewById(R.id.lineView);
        scrollView = (ScrollView) findViewById(R.id.scroll_view);

        decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        drawLine();
        drawChart();



//        mSeekBarX = (SeekBar) findViewById(R.id.seekBar1);
//        mSeekBarX.setOnSeekBarChangeListener(this);
//
//        mSeekBarY = (SeekBar) findViewById(R.id.seekBar2);
//        mSeekBarY.setOnSeekBarChangeListener(this);

        mChart = (BarChart) findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);

        mChart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(40);

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        mChart.setDoubleTapToZoomEnabled(false);//设置双击图表放大缩小  false 不允许

        mChart.setDrawGridBackground(false);
        mChart.setDrawBarShadow(false);

        mChart.setDrawValueAboveBar(false);
        mChart.setHighlightFullBarEnabled(false);



        // change the position of the y-labels
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setValueFormatter(new MyAxisValueFormatter());
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        mChart.getAxisRight().setEnabled(false);

        XAxis xLabels = mChart.getXAxis();
        xLabels.setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴坐标值放置位置  BOTTOM 为下  TOP为上

        // mChart.setDrawXLabels(false);
        // mChart.setDrawYLabels(false);

        // setting data
//        mSeekBarX.setProgress(12);
//        mSeekBarY.setProgress(100);

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setFormToTextSpace(4f);//设置梅格单位值大小 4f为4
        l.setXEntrySpace(6f);


        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < 13 + 1; i++) {//设置柱状图放大范围  0最大
            float mult = (120 + 1);//设置柱状图取值范围
            float val1 = (float) (Math.random() * mult) + mult / 3;
            float val2 = (float) (Math.random() * mult) + mult / 3;
            float val3 = (float) (Math.random() * mult) + mult / 3;
            float val4 = (float) (Math.random() * mult) + mult / 3;

            yVals1.add(new BarEntry(
                    i,
                    new float[]{val1, val2, val3, val4},
                    getResources().getDrawable(R.drawable.star)));
        }

        BarDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
//            set1.setDrawValues(!set1.isDrawValuesEnabled());//设置是否显示进度值
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "");//标题
//            set1.setDrawValues(!set1.isDrawValuesEnabled());//设置是否显示进度值
            set1.setDrawIcons(false);
            set1.setColors(getColors());
            set1.setStackLabels(new String[]{"色差", "划伤", "裂口", "颜色"});

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueFormatter(new MyValueFormatter());
            data.setValueTextColor(Color.WHITE);

            mChart.setData(data);
        }

        mChart.setFitBars(true);
        mChart.invalidate();

    }


    private void drawLine() {


//        //时间格式转换
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        //转换成字符串
//        String sDateTime = sdf.format(x_name);



        CommonUtils.solveScrollConflict(lineChartView,scrollView);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
//        String[] lineLabels = {"16:00", "15:45", "15:30", "15:15", "15:00", "14:45", "14:30","14:00","13:45"};
        String[] lineLabels = new String[24];
        long currentTime = calendar.get(Calendar.HOUR_OF_DAY);
        for (int i = 0; i < 24; i++) {
            lineLabels[i] = TimeUtils.dateToString(currentTime, TimeUtils.dateFormat_day);
            currentTime += (1 * 60 * 60 * 1000);
        }
        calendar.clear();
        int maxNumberOfLines = 1;
        int numberOfPoints = lineLabels.length;
        ValueShape shape = ValueShape.CIRCLE;
        float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];
        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {


                randomNumbersTab[i][j] = (float) Math.random() * 100f;
            }
        }



        List<Line> lines = new ArrayList<Line>();
        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        for (int i = 0; i < maxNumberOfLines; ++i) {
            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, randomNumbersTab[i][j]));
            }
            Line line = new Line(values);
            line.setColor(getResources().getColor(R.color.red));

            line.setShape(shape);
            line.setPointRadius(3);
            line.setStrokeWidth(1);
            line.setCubic(false);
            line.setFilled(false);
            line.setHasLabels(true);
            line.setHasLabelsOnlyForSelected(false);
            line.setHasLines(true);
            line.setHasPoints(true);
            line.setCubic(true);
            //line.setPointColor(R.color.transparent);
            line.setHasGradientToTransparent(true);
//            if (pointsHaveDifferentColor){
//                line.setPointColor(ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.length]);
//            }
            lines.add(line);

        }

        LineChartData data = new LineChartData(lines);
        for (int i = 0; i < numberOfPoints; i++) {
            axisValues.add(new AxisValue(i).setLabel(lineLabels[i]));
        }
        Axis axisX = new Axis(axisValues).setMaxLabelChars(5);
        axisX.setTextColor(getResources().getColor(R.color.grey_500))
                .setTextSize(10).setHasSeparationLineColor(getResources().getColor(R.color.red))
                .setHasTiltedLabels(true);
        data.setAxisXBottom(axisX);
        Axis axisY = new Axis().setHasSeparationLine(false).setMaxLabelChars(3)
                .setTextColor(getResources().getColor(R.color.grey_500))
                .setTextSize(10).setHasLines(true).setLineColor(getResources().getColor(R.color.red));
        data.setAxisYLeft(axisY);
        data.setBaseValue(Float.NEGATIVE_INFINITY);
        lineChartView.setLineChartData(data);

        lineChartView.setZoomEnabled(false);
        lineChartView.setScrollEnabled(true);
        lineChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        lineChartView.setValueSelectionEnabled(true);//点击折线点可以显示label
        // Reset viewport height range to (0,100)
        lineChartView.setViewportCalculationEnabled(false);

        //让布局能够水平滑动要设置setCurrentViewport比setMaximumViewport小
        final Viewport v = new Viewport(lineChartView.getMaximumViewport());
        v.bottom = 0;
        v.top = 125;
        v.left=0;
        v.right=numberOfPoints-1+0.5f;
        lineChartView.setMaximumViewport(v);
        v.left = 0;
        v.right = Math.min(6,numberOfPoints-1+0.5f);
        lineChartView.setCurrentViewport(v);
    }

    private void drawChart() {
        CommonUtils.solveScrollConflict(columnChartView,scrollView);
//        String[] chartLabels = {"15:45", "15:30", "15:15", "15:00", "14:45", "14:30"};

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
//        String[] lineLabels = {"16:00", "15:45", "15:30", "15:15", "15:00", "14:45", "14:30","14:00","13:45"};
        String[] chartLabels = new String[24];
        long currentTime = calendar.get(Calendar.HOUR_OF_DAY);
        for (int i = 0; i < 24; i++) {
            chartLabels[i] = TimeUtils.dateToString(currentTime, TimeUtils.dateFormat_day);
            currentTime += (1 * 60 * 60 * 1000);
        }
        calendar.clear();
        int numColumns = chartLabels.length;

        // Column can have many subcolumns, here by default I use 1 subcolumn in each of 8 columns.
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        for (int i = 0; i < numColumns; ++i) {
            values = new ArrayList<SubcolumnValue>();
            float height = (float) (Math.random() * 115) + 5;
            values.add(new SubcolumnValue(height, getResources().getColor(R.color.brown)).setLabel(decimalFormat.format(height))
                    .setLabelColor(getResources().getColor(R.color.red)).setLabelTextsize(CommonUtils.dp2px(this, 12)));

            Column column = new Column(values);
            column.setHasLabels(true).setHasLabelsOnlyForSelected(false);
            columns.add(column);
            axisValues.add(new AxisValue(i).setLabel(chartLabels[i]));
        }


        ColumnChartData data = new ColumnChartData(columns);
        // value.
        Axis axisx = new Axis(axisValues)
                .setTextColor(getResources().getColor(R.color.brown))
                .setTextSize(11).setHasLines(false).setHasSeparationLine(true).
                        setLineColor(getResources().getColor(R.color.white));
        data.setAxisXBottom(axisx);
        data.setFillRatio(0.5f);
        Axis axisY = new Axis().setHasLines(true).setHasSeparationLine(false).setMaxLabelChars(3);
        axisY.setTextColor(getResources().getColor(R.color.grey_500))
                .setTextSize(11).setLineColor(getResources().getColor(R.color.red))
                .setHasSeparationLineColor(getResources().getColor(R.color.red));
        data.setAxisYLeft(axisY);
        columnChartView.setColumnChartData(data);


        columnChartView.setZoomEnabled(false);
        columnChartView.setScrollEnabled(true);
        columnChartView.setInteractive(true);
        columnChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        columnChartView.setValueSelectionEnabled(true);//点击折线点可以显示label
        columnChartView.setViewportCalculationEnabled(true);
        final Viewport v = new Viewport(columnChartView.getMaximumViewport());
        v.bottom = 0;
        v.top = 135;
        v.left=-0.5f;
        v.right=numColumns-1+0.5f;
        columnChartView.setMaximumViewport(v);
        v.left = -0.5f;
        v.right = Math.min(6,numColumns-1+0.5f);
        columnChartView.setCurrentViewport(v);




    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < mSeekBarX.getProgress() + 1; i++) {
            float mult = (mSeekBarY.getProgress() + 1);
            float val1 = (float) (Math.random() * mult) + mult / 3;
            float val2 = (float) (Math.random() * mult) + mult / 3;
            float val3 = (float) (Math.random() * mult) + mult / 3;

            yVals1.add(new BarEntry(
                    i,
                    new float[]{val1, val2, val3},
                    getResources().getDrawable(R.drawable.star)));
        }

        BarDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Statistics Vienna 2014");
            set1.setDrawIcons(false);
            set1.setColors(getColors());
            set1.setStackLabels(new String[]{"Births", "Divorces", "Marriages"});

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueFormatter(new MyValueFormatter());
            data.setValueTextColor(Color.WHITE);

            mChart.setData(data);
        }

        mChart.setFitBars(true);
        mChart.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

        BarEntry entry = (BarEntry) e;

        if (entry.getYVals() != null)
            Log.i("VAL SELECTED", "Value: " + entry.getYVals()[h.getStackIndex()]);
        else
            Log.i("VAL SELECTED", "Value: " + entry.getY());
    }

    @Override
    public void onNothingSelected() {
        // TODO Auto-generated method stub

    }

    private int[] getColors() {

        int stacksize = 4;

        // have as many colors as stack-values per entry
        int[] colors = new int[stacksize];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = ColorTemplate.MATERIAL_COLORS[i];
        }

        return colors;
    }

}
