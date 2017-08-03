package com.terry.mybasedlib.utils;

import java.text.DecimalFormat;

/**
 * Created by admin on 2017/1/23.
 */

public class Doubleformat {
    private static final DecimalFormat DF = new DecimalFormat("######0.00");

    public static String format(double d) {
        return DF.format(d);
    }
}
