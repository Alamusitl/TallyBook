package com.owl.book.tally.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.book.BR;

/**
 * Created by Alamusi on 2017/5/10.
 */

public class TallyItem extends BaseObservable {

    private String mItemName;
    private int mItemDrawableId;

    public TallyItem(String typeName, int typeImageId) {
        mItemName = typeName;
        mItemDrawableId = typeImageId;
    }

    @Bindable
    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String itemName) {
        mItemName = itemName;
        notifyPropertyChanged(BR.itemName);
    }

    @Bindable
    public int getItemDrawableId() {
        return mItemDrawableId;
    }

    public void setItemDrawableId(int itemDrawableId) {
        mItemDrawableId = itemDrawableId;
        notifyPropertyChanged(BR.itemDrawableId);
    }
}
