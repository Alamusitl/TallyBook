package com.owl.book.account;

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
    private int accountIconWhite;
    @NotNull
    private int accountIconGrey;
    @NotNull
    private int accountBgColor;
    @NotNull
    private int accountLabelColor;
    @NotNull
    private String accountName;
    @NotNull
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
        this.accountName = accountName;
    }

    @Generated(hash = 901559345)
    public Account(long id, int accountIconWhite, int accountIconGrey,
                   int accountBgColor, int accountLabelColor, @NotNull String accountName,
                   @NotNull String accountBalance) {
        this.id = id;
        this.accountIconWhite = accountIconWhite;
        this.accountIconGrey = accountIconGrey;
        this.accountBgColor = accountBgColor;
        this.accountLabelColor = accountLabelColor;
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

    public void setAccountSelect(boolean accountSelect) {
        isAccountSelect = accountSelect;
        notifyPropertyChanged(BR.accountSelect);
    }

    @Bindable
    public int getAccountIconWhite() {
        return this.accountIconWhite;
    }

    public void setAccountIconWhite(int accountIconWhite) {
        this.accountIconWhite = accountIconWhite;
        notifyPropertyChanged(BR.accountIconWhite);
    }

    @Bindable
    public int getAccountIconGrey() {
        return this.accountIconGrey;
    }

    public void setAccountIconGrey(int accountIconGrey) {
        this.accountIconGrey = accountIconGrey;
        notifyPropertyChanged(BR.accountIconGrey);
    }

    @Bindable
    public int getAccountBgColor() {
        return this.accountBgColor;
    }

    public void setAccountBgColor(int accountBgColor) {
        this.accountBgColor = accountBgColor;
        notifyPropertyChanged(BR.accountBgColor);
    }

    @Bindable
    public int getAccountLabelColor() {
        return this.accountLabelColor;
    }

    public void setAccountLabelColor(int accountLabelColor) {
        this.accountLabelColor = accountLabelColor;
        notifyPropertyChanged(BR.accountLabelColor);
    }
}
