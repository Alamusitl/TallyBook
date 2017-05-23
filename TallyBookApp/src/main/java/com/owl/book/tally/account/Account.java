package com.owl.book.tally.account;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.book.BR;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Entity of Account，Use for greenDao & DataBinding Data
 * Created by Imagine Owl on 2017/5/18.
 */
@Entity
public class Account extends BaseObservable {

    @Id
    @Index
    private long id;
    @NotNull
    private int accountIcon;
    @NotNull
    private String accountName;
    private String accountBalance;
    @Transient
    private boolean isAccountSelect;

    public Account() {
        accountName = "选择账户";
        accountBalance = "0.00";
        isAccountSelect = false;
    }

    public Account(long id, int accountIcon, String accountName) {
        this();
        this.id = id;
        this.accountIcon = accountIcon;
        this.accountName = accountName;
    }

    @Generated(hash = 1951863264)
    public Account(long id, int accountIcon, @NotNull String accountName,
                   String accountBalance) {
        this.id = id;
        this.accountIcon = accountIcon;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public int getAccountIcon() {
        return this.accountIcon;
    }

    public void setAccountIcon(int accountIcon) {
        this.accountIcon = accountIcon;
        notifyPropertyChanged(BR.accountIcon);
    }

    @Bindable
    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
        notifyPropertyChanged(BR.accountName);
    }

    @Bindable
    public String getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
        notifyPropertyChanged(BR.accountBalance);
    }

    @Bindable
    public boolean isAccountSelect() {
        return this.isAccountSelect;
    }

    public void setAccountSelect(boolean isSelect) {
        this.isAccountSelect = isSelect;
        notifyPropertyChanged(BR.accountSelect);
    }
}
