package com.owl.book.util;

import android.content.Context;

/**
 * Android resource Utils
 * Created by Alamusi on 2017/5/12.
 */

public class ResUtils {

    /**
     * get Drawable Id from drawable name
     *
     * @param context      current Context
     * @param drawableName drawable Name
     * @return drawable Id
     */
    public static int getDrawableId(Context context, String drawableName) {
        return context.getResources().getIdentifier(drawableName, "drawable", context.getPackageName());
    }
}
