package com.owl.book.main.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.owl.book.BR;

/**
 * 底部导航栏Item的Model
 * Created by Alamusi on 2017/4/20.
 */

public class BottomNavItem extends BaseObservable {

    private int mIndex;
    private int mSelectImageId;
    private int mDefaultImageId;
    private int mTextId;
    private boolean mSelect;

    public BottomNavItem(int index, int selectImageId, int defaultImageId, int textId, boolean select) {
        mIndex = index;
        mSelectImageId = selectImageId;
        mDefaultImageId = defaultImageId;
        mTextId = textId;
        mSelect = select;
    }

    @BindingAdapter({"imageId"})
    public static void setImage(ImageView view, int resId) {
        view.setImageResource(resId);
    }

    @Bindable
    public int getIndex() {
        return mIndex;
    }

    public void setIndex(int index) {
        mIndex = index;
        notifyPropertyChanged(BR.index);
    }

    @Bindable
    public int getSelectImageId() {
        return mSelectImageId;
    }

    public void setSelectImageId(int selectImageId) {
        mSelectImageId = selectImageId;
        notifyPropertyChanged(BR.selectImageId);
    }

    @Bindable
    public int getDefaultImageId() {
        return mDefaultImageId;
    }

    public void setDefaultImageId(int defaultImageId) {
        mDefaultImageId = defaultImageId;
        notifyPropertyChanged(BR.defaultImageId);
    }

    @Bindable
    public int getTextId() {
        return mTextId;
    }

    public void setTextId(int textId) {
        mTextId = textId;
        notifyPropertyChanged(BR.textId);
    }

    @Bindable
    public boolean isSelect() {
        return mSelect;
    }

    public void setSelect() {
        mSelect = !mSelect;
        notifyPropertyChanged(BR.select);
    }

}
