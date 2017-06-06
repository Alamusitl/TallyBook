package com.owl.book.util;

import android.content.res.Resources;
import android.util.TypedValue;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Imagine Owl on 2017/6/6.
 */

public class ViewUtils {

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int dp2px(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, Resources.getSystem().getDisplayMetrics());
    }

    public static int generateViewId() {
        for (; ; ) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            // Roll over to 1, not 0.
            if (newValue > 0x00FFFFFF) {
                newValue = 1;
            }
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
}
