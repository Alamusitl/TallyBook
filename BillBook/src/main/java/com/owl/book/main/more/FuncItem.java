package com.owl.book.main.more;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Bitmap;

import com.owl.book.BR;

/**
 * Created by Imagine Owl on 2017/6/9.
 */

public class FuncItem extends BaseObservable {

    private int funcItemIcon;
    private String funcItemName;
    private Bitmap funcItemBitmap;

    @Bindable
    public int getFuncItemIcon() {
        return funcItemIcon;
    }

    public void setFuncItemIcon(int funcItemIcon) {
        this.funcItemIcon = funcItemIcon;
        notifyPropertyChanged(BR.funcItemIcon);
    }

    @Bindable
    public String getFuncItemName() {
        return funcItemName;
    }

    public void setFuncItemName(String funcItemName) {
        this.funcItemName = funcItemName;
        notifyPropertyChanged(BR.funcItemName);
    }

    @Bindable
    public Bitmap getFuncItemBitmap() {
        return funcItemBitmap;
    }

    public void setFuncItemBitmap(Bitmap funcItemBitmap) {
        this.funcItemBitmap = funcItemBitmap;
        notifyPropertyChanged(BR.funcItemBitmap);
    }
}
