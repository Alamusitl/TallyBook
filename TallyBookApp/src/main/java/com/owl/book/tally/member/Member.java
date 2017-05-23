package com.owl.book.tally.member;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Imagine Owl on 2017/5/23.
 */
@Entity
public class Member {

    @Id
    @Index
    private long id;
    @NotNull
    private String name;

    @Generated(hash = 1746766827)
    public Member(long id, @NotNull String name) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
