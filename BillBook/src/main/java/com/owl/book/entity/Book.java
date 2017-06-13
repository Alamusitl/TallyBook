package com.owl.book.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.book.BR;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Imagine Owl on 2017/6/8.
 */
@Entity
public class Book extends BaseObservable {

    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String bookName;
    @NotNull
    private int bookBg;
    @NotNull
    private boolean isBookSelect;

    @Generated(hash = 1342505335)
    public Book(Long id, @NotNull String bookName, int bookBg,
                boolean isBookSelect) {
        this.id = id;
        this.bookName = bookName;
        this.bookBg = bookBg;
        this.isBookSelect = isBookSelect;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }

    public Book(String bookName, int bookBg, boolean isBookSelect) {
        this.bookName = bookName;
        this.bookBg = bookBg;
        this.isBookSelect = isBookSelect;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Bindable
    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        notifyPropertyChanged(BR.bookName);
    }

    @Bindable
    public int getBookBg() {
        return this.bookBg;
    }

    public void setBookBg(int bookBg) {
        this.bookBg = bookBg;
        notifyPropertyChanged(BR.bookBg);
    }

    @Bindable
    public boolean getIsBookSelect() {
        return this.isBookSelect;
    }

    public void setIsBookSelect(boolean isBookSelect) {
        this.isBookSelect = isBookSelect;
        notifyPropertyChanged(BR.isBookSelect);
    }
}
