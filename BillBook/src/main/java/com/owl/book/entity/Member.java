package com.owl.book.entity;

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
 * Created by Imagine Owl on 2017/5/23.
 */
@Entity
public class Member extends BaseObservable {

    @Id
    @Index
    private long id;
    @NotNull
    private String memberName;
    @Transient
    private boolean isMemberSelect;
    @NotNull
    private boolean isMemberDefault;

    @Generated(hash = 944793846)
    public Member(long id, @NotNull String memberName, boolean isMemberDefault) {
        this.id = id;
        this.memberName = memberName;
        this.isMemberDefault = isMemberDefault;
    }

    @Generated(hash = 367284327)
    public Member() {
    }

    public Member(long id, String memberName) {
        this.id = id;
        this.memberName = memberName;
        this.isMemberSelect = false;
        this.isMemberDefault = false;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getMemberName() {
        return this.memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
        notifyPropertyChanged(BR.memberName);
    }

    @Bindable
    public boolean isMemberSelect() {
        return isMemberSelect;
    }

    public void setMemberSelect(boolean memberSelect) {
        isMemberSelect = memberSelect;
        notifyPropertyChanged(BR.memberSelect);
    }

    @Bindable
    public boolean getIsMemberDefault() {
        return this.isMemberDefault;
    }

    public void setIsMemberDefault(boolean isMemberDefault) {
        this.isMemberDefault = isMemberDefault;
        notifyPropertyChanged(BR.isMemberDefault);
    }
}
