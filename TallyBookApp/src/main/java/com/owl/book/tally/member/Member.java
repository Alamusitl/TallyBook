package com.owl.book.tally.member;

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

    @Generated(hash = 1637190266)
    public Member(long id, @NotNull String memberName) {
        this.id = id;
        this.memberName = memberName;
    }

    @Generated(hash = 367284327)
    public Member() {
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
}
