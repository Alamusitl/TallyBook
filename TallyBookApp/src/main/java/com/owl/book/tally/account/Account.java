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
    private int icon;
    @NotNull
    private String name;
    private String balance;
    @Transient
    private boolean isSelect;

    public Account() {
        name = "选择账户";
        balance = "0.00";
        isSelect = false;
    }

    public Account(long id, int icon, String name) {
        this();
        this.id = id;
        this.icon = icon;
        this.name = name;
    }

    @Generated(hash = 1079990225)
    public Account(long id, int icon, @NotNull String name, String balance) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.balance = balance;
    }

    @Bindable
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
        notifyPropertyChanged(BR.icon);
    }

    @Bindable
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
        notifyPropertyChanged(BR.balance);
    }

    @Bindable
    public boolean getIsSelect() {
        return this.isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
        notifyPropertyChanged(BR.isSelect);
    }
}
