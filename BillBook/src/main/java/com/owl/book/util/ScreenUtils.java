package com.owl.book.util;

import android.content.res.Resources;

/**
 * Created by Imagine Owl on 2017/6/9.
 */

public class ScreenUtils {

    public static int getStatusBarHeight() {
        Resources resources = Resources.getSystem();
        int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resId);
    }

    public static int getNavigationBarHeight() {
        Resources resources = Resources.getSystem();
        int resId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resId);
    }
}
