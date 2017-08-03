package com.terry.mybasedlib.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 * <p>
 * Created by Wang on 2017/5/24.
 */

public class TimeUtils {

    private static final DateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private static final DateFormat FORMAT = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());

    /**
     * 将时间戳转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param millis 毫秒时间戳
     * @return 时间字符串
     */
    public static String millis2String(long millis) {
        return millis2String(millis, DEFAULT_FORMAT);
    }

    public static String dateFormat(long millis) {
        return millis2String(millis, FORMAT);
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为format</p>
     *
     * @param millis 毫秒时间戳
     * @param format 时间格式
     * @return 时间字符串
     */
    public static String millis2String(long millis, DateFormat format) {
        return format.format(new Date(millis));
    }


    public static String ChartTimeFormat(String time) {
        String t = null;
        if (EmptyUtils.isNotEmpty(time)) {
            String[] split = time.split(" ");
            String[] split1 = split[1].split(":");
            t = split1[0] + ":" + split1[1];
        }
        return t;

    }

    public static String NoticeTimeFormat(String time) {
        String t = null;
        if (EmptyUtils.isNotEmpty(time)) {
            String[] split = time.split(" ");
            String[] split1 = split[0].split("-");
            t = split1[0] + "/" + split1[1] + "/" + split1[2];
        }
        return t;

    }

    public static String ChartTimeFormat(String time, String min) {
        String t = null;
        if (EmptyUtils.isNotEmpty(time)) {
            String[] spl = time.split(" ");
            String[] sp = spl[1].split(":");
            String[] sp2 = spl[0].split("-");
            switch (min) {
                case "5":
                    t = sp[0] + ":" + sp[1];
                    break;
                case "15":
                case "30":
                case "60":
                    t = sp2[1] + "/" + sp2[2] + " " + sp[0] + ":" + sp[1];
                    break;
                case "day":
                    t = sp2[1] + "/" + sp2[2];
                    break;
            }


        }
        return t;

    }


}
