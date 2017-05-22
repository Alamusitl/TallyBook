package com.owl.book.tally.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.book.BR;
import com.owl.book.tally.AccountItem;
import com.owl.book.util.DateTimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class OneTally extends BaseObservable {

    private boolean mIsEarn;
    private boolean mPay;
    private int mTallyType;
    private String mMoney;
    private List<String> mMembers;
    private String mDescription;
    private AccountItem mAccountItem;
    private Date mDate;

    private String mShowDate;

    public OneTally() {
        mDate = DateTimeUtil.getCurrDate();
        mShowDate = DateTimeUtil.getFormatDateNoYear(mDate);
        mAccountItem = new AccountItem();
    }

    public boolean isEarn() {
        return mIsEarn;
    }

    public void setEarn(boolean earn) {
        mIsEarn = earn;
        mPay = !earn;
    }

    public boolean isPay() {
        return mPay;
    }

    public void setPay(boolean pay) {
        mPay = pay;
        mIsEarn = !pay;
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

    @Bindable
    public AccountItem getAccountItem() {
        return mAccountItem;
    }

    public void setAccountItem(AccountItem accountItem) {
        mAccountItem = accountItem;
        notifyPropertyChanged(BR.accountItem);
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
