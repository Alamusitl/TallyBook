package com.owl.book.util;

import android.util.Log;

/**
 * Created by Imagine Owl on 2017/5/24.
 */

public class LogUtil {

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }
}
