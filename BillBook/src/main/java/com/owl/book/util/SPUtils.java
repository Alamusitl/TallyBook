package com.owl.book.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class SPUtils {

    private static final String SP_NAME = "TB_SP";
    private static final String IS_FIRST_LAUNCH = "isFirstLaunch";

    public static boolean isFirstLaunch(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(IS_FIRST_LAUNCH, true);
    }

    public static void setFirstLaunchFlag(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(IS_FIRST_LAUNCH, false);
        editor.apply();
    }
}
