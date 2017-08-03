package com.terry.mybasedlib.utils;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.jp.index.R;
import com.jp.index.widget.MyKMarkerView;
import com.jp.index.widget.MyMarkerView;
import com.jp.index.widget.MyYAxisValueFormatter;

/**
 * Created by tang on 2017/1/17.
 */

public class ChartManager {

    private static String lineName = null;
    private static String lineName1 = null;
    private static XAxis xAxisBar;
    private static YAxis axisLeftBar;
    private static YAxis axisRightBar;
    private static XAxis xAxisK;
    private static YAxis axisLeftK;
    private static YAxis axisRightK;


    /**
     * @param context
     * @param mLineChart
     * @Description:初始化图表的样式
     */
    public static void initDataStyle(Context context, LineChart mLineChart) {
        mLineChart.setTouchEnabled(true);
        mLineChart.setScaleEnabled(false);
        mLineChart.setDescription(null);

        //设置点击折线点时，显示其数值
        MyMarkerView mv = new MyMarkerView(context, R.layout.custom_marker_view);
        mv.setChartView(mLineChart); // For bounds control
        mLineChart.setMarker(mv); // Set the marker to the chart
        //设置折线的描述的样式（默认在图表的左下角）
        Legend title = mLineChart.getLegend();
        title.setForm(Legend.LegendForm.LINE);
        title.setTextColor(Color.WHITE);
        //设置x轴的样式
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setAxisLineColor(Color.parseColor("#66CDAA"));
        xAxis.setAxisLineWidth(0.5f);
        xAxis.setDrawGridLines(true);
        //设置是否显示x轴
        xAxis.setEnabled(true);
        xAxis.setDrawLabels(true);

        xAxis.setTextColor(Color.WHITE);


//        LimitLine ll = new LimitLine(0);
//        ll.setLineWidth(1f);
//        ll.setLineColor(getResources().getColor(R.color.minute_jizhun));
//        ll.enableDashedLine(10f, 10f, 0f);
//        ll.setLineWidth(1);
//        mLeftYAxis.addLimitLine(ll);


        //设置左边y轴的样式
        YAxis yAxisLeft = mLineChart.getAxisLeft();
//        yAxisLeft.setAxisLineColor(Color.parseColor("#66CDAA"));
        yAxisLeft.setAxisLineWidth(0.5f);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setLabelCount(5, true);
        yAxisLeft.setTextColor(Color.WHITE);
//        yAxisLeft.setValueFormatter(new MyYLAxisValueFormatter());

        //设置右边y轴的样式
        YAxis yAxisRight = mLineChart.getAxisRight();
        yAxisRight.setEnabled(true);
        yAxisRight.setDrawLabels(true);
        yAxisRight.setLabelCount(5, true);
        yAxisRight.setTextColor(Color.WHITE);
        yAxisRight.setValueFormatter(new MyYAxisValueFormatter());


    }

    public static void initKDataStyle(Context context, final CandleStickChart mLineChart) {
        //设置图表是否支持触控操作
        mLineChart.setTouchEnabled(true);
        mLineChart.setScaleEnabled(false);
        mLineChart.setDescription(null);
//        mLineChart.setDescription("df");
        //设置点击折线点时，显示其数值
        MyKMarkerView mv = new MyKMarkerView(context, R.layout.mykmarkerview);
        mv.setChartView(mLineChart);
        mLineChart.setMarkerView(mv);
        //设置折线的描述的样式（默认在图表的左下角）
        Legend title = mLineChart.getLegend();
        title.setForm(Legend.LegendForm.LINE);
        title.setTextColor(Color.WHITE);
        //设置x轴的样式
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setAxisLineColor(Color.parseColor("#66CDAA"));
        xAxis.setAxisLineWidth(0.5f);
        xAxis.setDrawGridLines(true);
        //设置是否显示x轴
        xAxis.setEnabled(true);
        xAxis.setDrawLabels(true);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setTextSize(5f);

        //设置左边y轴的样式
        YAxis yAxisLeft = mLineChart.getAxisLeft();
//        yAxisLeft.setAxisLineColor(Color.parseColor("#66CDAA"));
        yAxisLeft.setAxisLineWidth(0.5f);
        yAxisLeft.setDrawGridLines(true);
        yAxisLeft.setSpaceTop(0f);
        yAxisLeft.setLabelCount(8, true);
        yAxisLeft.setTextColor(Color.WHITE);
        //设置右边y轴的样式
        YAxis yAxisRight = mLineChart.getAxisRight();
        yAxisRight.setDrawLabels(false);
        yAxisRight.setEnabled(true);
        yAxisRight.setLabelCount(8, true);
        yAxisRight.setSpaceTop(0f);
        yAxisRight.setTextColor(Color.WHITE);

    }


    /**
     * @param name
     * @Description:设置折线的名称
     */
    public static void setLineName(String name) {
        lineName = name;
    }

}


