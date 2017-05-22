package com.owl.book.tally;

import android.databinding.BaseObservable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Entity of Account，Use for greenDao & DataBinding Data
 * Created by Imagine Owl on 2017/5/18.
 */
@Entity()
public class AccountItem extends BaseObservable {

    @Id
    @Index
    private long id;
    @NotNull
    private int icon;
    @NotNull
    private String name;
    private String balance;
    private boolean isSelect;

    public AccountItem() {
        name = "选择账户";
        balance = "0.00";
        isSelect = false;
    }

    public AccountItem(long id, int icon, String name) {
        this();
        this.id = id;
        this.icon = icon;
        this.name = name;
    }

    @Generated(hash = 1201783870)
    public AccountItem(long id, int icon, @NotNull String name, String balance,
                       boolean isSelect) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.balance = balance;
        this.isSelect = isSelect;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public boolean getIsSelect() {
        return this.isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }
}
