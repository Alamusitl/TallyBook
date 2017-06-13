package com.owl.book.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.owl.book.BR;
import com.owl.book.R;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Entity of Account，Use for greenDao & DataBinding Data
 * Created by Imagine Owl on 2017/5/18.
 */
@Entity
public class Account extends BaseObservable implements Parcelable {

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel source) {
            return new Account(source);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
    @Id(autoincrement = true)
    private Long id;
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
        accountIconWhite = R.drawable.icon_net_account_white;
        accountIconGrey = R.drawable.icon_net_account_grey;
        accountBgColor = R.color.color_57BFEB;
        accountLabelColor = R.color.color_6286EE;
        accountName = "选择账户";
        accountBalance = "0.00";
        isAccountSelect = false;
    }

    public Account(int accountIconGrey, int accountIconWhite, String accountName) {
        this();
        this.accountIconGrey = accountIconGrey;
        this.accountIconWhite = accountIconWhite;
        this.accountName = accountName;
    }

    @Generated(hash = 2088352750)
    public Account(Long id, int accountIconWhite, int accountIconGrey, int accountBgColor,
                   int accountLabelColor, @NotNull String accountName,
                   @NotNull String accountBalance) {
        this.id = id;
        this.accountIconWhite = accountIconWhite;
        this.accountIconGrey = accountIconGrey;
        this.accountBgColor = accountBgColor;
        this.accountLabelColor = accountLabelColor;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public Account(Parcel parcel) {
        accountIconWhite = parcel.readInt();
        accountIconGrey = parcel.readInt();
        accountBgColor = parcel.readInt();
        accountLabelColor = parcel.readInt();
        accountName = parcel.readString();
        accountBalance = parcel.readString();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(accountIconWhite);
        dest.writeInt(accountIconGrey);
        dest.writeInt(accountBgColor);
        dest.writeInt(accountLabelColor);
        dest.writeString(accountName);
        dest.writeString(accountBalance);
    }
}
