package com.owl.book.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.book.BR;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Alamusi on 2017/5/10.
 */
@Entity
public class BillTypeItem extends BaseObservable {

    @Id
    @Index
    private long id;
    @NotNull
    private String billTypeItemName;
    @NotNull
    private int billTypeItemDrawableId;

    @Generated(hash = 2046311951)
    public BillTypeItem(long id, @NotNull String billTypeItemName,
                        int billTypeItemDrawableId) {
        this.id = id;
        this.billTypeItemName = billTypeItemName;
        this.billTypeItemDrawableId = billTypeItemDrawableId;
    }

    @Generated(hash = 1334461430)
    public BillTypeItem() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getBillTypeItemName() {
        return this.billTypeItemName;
    }

    public void setBillTypeItemName(String billTypeItemName) {
        this.billTypeItemName = billTypeItemName;
        notifyPropertyChanged(BR.billTypeItemName);
    }

    @Bindable
    public int getBillTypeItemDrawableId() {
        return this.billTypeItemDrawableId;
    }

    public void setBillTypeItemDrawableId(int billTypeItemDrawableId) {
        this.billTypeItemDrawableId = billTypeItemDrawableId;
        notifyPropertyChanged(BR.billTypeItemDrawableId);
    }

}
