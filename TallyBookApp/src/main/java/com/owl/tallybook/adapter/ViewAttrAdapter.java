package com.owl.tallybook.adapter;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.owl.tallybook.R;

/**
 * DataBinding Adapter for View attr
 * Created by Alamusi on 2017/5/11.
 */

public class ViewAttrAdapter {

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, @DrawableRes int resId) {
        view.setImageResource(resId == 0 ? R.drawable.icon_other : resId);
    }
}
