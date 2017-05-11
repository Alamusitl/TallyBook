package com.owl.tallybook.addone.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.tallybook.BR;
import com.owl.tallybook.util.DateTimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class OneTally extends BaseObservable {

    private boolean mSelectEarn;
    private boolean mSelectPay;
    private int mTallyType;
    private String mMoney;
    private List<String> mMembers;
    private String mDescription;
    private int mMoneyType;
    private Date mDate;

    private String mShowDate;

    public OneTally() {
        mDate = DateTimeUtil.getCurrDate();
        mShowDate = DateTimeUtil.getFormatDateNoYear(mDate);
    }

    public boolean isSelectEarn() {
        return mSelectEarn;
    }

    public void setSelectEarn(boolean selectEarn) {
        mSelectEarn = selectEarn;
        mSelectPay = !selectEarn;
    }

    public boolean isSelectPay() {
        return mSelectPay;
    }

    public void setSelectPay(boolean selectPay) {
        mSelectPay = selectPay;
        mSelectEarn = !selectPay;
    }

    public int getTallyType() {
        return mTallyType;
    }

    public void setTallyType(int tallyType) {
        mTallyType = tallyType;
    }

    public String getMoney() {
        return mMoney;
    }

    public void setMoney(String money) {
        mMoney = money;
    }

    public List<String> getMembers() {
        return mMembers;
    }

    public void setMembers(List<String> members) {
        mMembers = members;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getMoneyType() {
        return mMoneyType;
    }

    public void setMoneyType(int moneyType) {
        mMoneyType = moneyType;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
        setShowDate(DateTimeUtil.getFormatDateNoYear(mDate));
    }

    @Bindable
    public String getShowDate() {
        return mShowDate;
    }

    private void setShowDate(String showDate) {
        mShowDate = showDate;
        notifyPropertyChanged(BR.showDate);
    }
}
