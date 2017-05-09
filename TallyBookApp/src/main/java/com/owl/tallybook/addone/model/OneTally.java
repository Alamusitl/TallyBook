package com.owl.tallybook.addone.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class OneTally {

    private boolean mIsIncome;
    private int mTallyType;
    private float mMoney;
    private List<String> mMembers;
    private String mDescription;
    private int mMoneyType;
    private Date mDate;

    public boolean isIncome() {
        return mIsIncome;
    }

    public void setIncome(boolean income) {
        mIsIncome = income;
    }

    public int getTallyType() {
        return mTallyType;
    }

    public void setTallyType(int tallyType) {
        mTallyType = tallyType;
    }

    public float getMoney() {
        return mMoney;
    }

    public void setMoney(float money) {
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
    }
}
