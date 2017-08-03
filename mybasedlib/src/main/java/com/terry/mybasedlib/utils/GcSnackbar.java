package com.terry.mybasedlib.utils;

import android.view.View;

/**
 * Created by tang on 2017/1/20.
 */

public class GcSnackbar {

    private static int messageShowCount = 0;
    private static int gcCount = 5;

    public static void count() {
        messageShowCount++;
        if (messageShowCount >= gcCount) {
            System.gc();
            messageShowCount = 0;
        }
    }

    public static void Snack(View view, String text) {
//        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
        count();
    }
}
