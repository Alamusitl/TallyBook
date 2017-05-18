package com.owl.book.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * 账户类型
 * Entity mapped to table 'ACCOUNT'
 * Created by Imagine Owl on 2017/5/17.
 */
@Entity()
public class Account {

    @Id
    @Index
    private long id;
    @NotNull
    private String name;

    @Generated(hash = 966534093)
    public Account(long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 882125521)
    public Account() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
