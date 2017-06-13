package com.owl.book.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.book.util.DateTimeUtil;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;

import java.util.Date;

/**
 * Created by Alamusi on 2017/5/9.
 */
@Entity
public class BillItem extends BaseObservable {

    @Id
    @Index
    private long id;
    @Transient
    private BillType billType;
    @NotNull
    private int billTypeInt;
    @NotNull
    private float money;
    private String desc;
    @NotNull
    @Transient
    private Account account;
    @NotNull
    private Date date;
    @NotNull
    @Transient
    private BillTypeItem billTypeItem;
    @Transient
    private String mShowDate;

    public BillItem() {
        billType = BillType.COST;
        date = DateTimeUtil.getCurrDate();
        mShowDate = DateTimeUtil.getFormatDateNoYear(date);
        account = new Account();
    }

    @Generated(hash = 2084822396)
    public BillItem(long id, int billTypeInt, float money, String desc,
                    @NotNull Date date) {
        this.id = id;
        this.billTypeInt = billTypeInt;
        this.money = money;
        this.desc = desc;
        this.date = date;
    }

    @Bindable
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        setShowDate(DateTimeUtil.getFormatDateNoYear(date));
    }

    @Bindable
    public String getShowDate() {
        return mShowDate;
    }

    private void setShowDate(String showDate) {
        mShowDate = showDate;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBillTypeInt() {
        return this.billTypeInt;
    }

    public void setBillTypeInt(int billTypeInt) {
        this.billTypeInt = billTypeInt;
    }

    public float getMoney() {
        return this.money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public enum BillType {
        EARN, COST
    }
}
