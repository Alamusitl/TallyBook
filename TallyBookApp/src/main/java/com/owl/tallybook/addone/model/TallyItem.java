package com.owl.tallybook.addone.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.tallybook.BR;

/**
 * Created by Alamusi on 2017/5/10.
 */

public class TallyItem extends BaseObservable {

    private String mTypeName;
    private int mTypeImageId;

    @Bindable
    public String getTypeName() {
        return mTypeName;
    }

    public void setTypeName(String typeName) {
        mTypeName = typeName;
        notifyPropertyChanged(BR.typeName);
    }

    @Bindable
    public int getTypeImageId() {
        return mTypeImageId;
    }

    public void setTypeImageId(int typeImageId) {
        mTypeImageId = typeImageId;
        notifyPropertyChanged(BR.typeImageId);
    }
}
