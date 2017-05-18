package com.owl.book;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Imagine Owl on 2017/5/18.
 */

public class ChooseItem extends BaseObservable {

    private int mIcon;
    private String mName;
    private String mBalance;
    private boolean mIsSelect;

    public ChooseItem() {
        mIsSelect = false;
        mBalance = "余额：0.00";
    }

    public ChooseItem(String name) {
        this();
        mName = name;
    }

    @Bindable
    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        mIcon = icon;
        notifyPropertyChanged(BR.icon);
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getBalance() {
        return mBalance;
    }

    public void setBalance(String balance) {
        mBalance = balance;
        notifyPropertyChanged(BR.balance);
    }

    @Bindable
    public boolean isSelect() {
        return mIsSelect;
    }

    public void setSelect(boolean select) {
        mIsSelect = select;
        notifyPropertyChanged(BR.select);
    }
}
