package com.owl.book.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.book.BR;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by Alamusi on 2017/5/10.
 */
@Entity
public class BillTypeItem extends BaseObservable {

    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String billTypeItemName;
    @NotNull
    private int billTypeItemDrawableId;
    private long bookId;
    @ToOne(joinProperty = "bookId")
    private Book book;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 258253111)
    private transient BillTypeItemDao myDao;
    @Generated(hash = 893611298)
    private transient Long book__resolvedKey;

    @Generated(hash = 561012914)
    public BillTypeItem(Long id, @NotNull String billTypeItemName,
                        int billTypeItemDrawableId, long bookId) {
        this.id = id;
        this.billTypeItemName = billTypeItemName;
        this.billTypeItemDrawableId = billTypeItemDrawableId;
        this.bookId = bookId;
    }

    @Generated(hash = 1334461430)
    public BillTypeItem() {
    }

    public BillTypeItem(String billTypeItemName, int billTypeItemDrawableId) {
        this.billTypeItemName = billTypeItemName;
        this.billTypeItemDrawableId = billTypeItemDrawableId;
    }

    public BillTypeItem(String billTypeItemName, int billTypeItemDrawableId, long bookId) {
        this.billTypeItemName = billTypeItemName;
        this.billTypeItemDrawableId = billTypeItemDrawableId;
        this.bookId = bookId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public long getBookId() {
        return this.bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 8805314)
    public Book getBook() {
        long __key = this.bookId;
        if (book__resolvedKey == null || !book__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BookDao targetDao = daoSession.getBookDao();
            Book bookNew = targetDao.load(__key);
            synchronized (this) {
                book = bookNew;
                book__resolvedKey = __key;
            }
        }
        return book;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1979200873)
    public void setBook(@NotNull Book book) {
        if (book == null) {
            throw new DaoException(
                    "To-one property 'bookId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.book = book;
            bookId = book.getId();
            book__resolvedKey = bookId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 860260996)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBillTypeItemDao() : null;
    }
}
