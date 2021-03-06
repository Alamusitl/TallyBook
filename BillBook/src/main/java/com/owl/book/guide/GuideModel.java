package com.owl.book.guide;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import com.owl.book.BR;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class GuideModel extends BaseObservable {

    private ObservableArrayList<Boolean> mIsSelected;

    private ObservableBoolean mIsLastView;

    public GuideModel(int childCount) {
        mIsSelected = new ObservableArrayList<>();
        mIsLastView = new ObservableBoolean();
        for (int i = 0; i < childCount; i++) {
            mIsSelected.add(false);
        }
        setSelected(0);
    }

    public boolean isSelected(int index) {
        return mIsSelected.get(index);
    }

    public void setSelected(int index) {
        reset();
        mIsSelected.set(index, true);
        if (index == mIsSelected.size() - 1) {
            setIsLastView(true);
        } else {
            setIsLastView(false);
        }
        notifyChange();
    }

    private void reset() {
        for (int i = 0; i < mIsSelected.size(); i++) {
            mIsSelected.set(i, false);
        }
    }

    @Bindable
    public boolean getIsLastView() {
        return mIsLastView.get();
    }

    public void setIsLastView(boolean isLastView) {
        mIsLastView.set(isLastView);
        notifyPropertyChanged(BR.isLastView);
    }
}
