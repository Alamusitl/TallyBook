package com.owl.book.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.book.BR;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

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
    private long billItemId;
    @ToMany(joinProperties = {
            @JoinProperty(name = "billItemId", referencedName = "id")
    })
    private List<BillItem> billItemList;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1097957864)
    private transient BookDao myDao;

    @Generated(hash = 1463006795)
    public Book(Long id, @NotNull String bookName, int bookBg, boolean isBookSelect,
                long billItemId) {
        this.id = id;
        this.bookName = bookName;
        this.bookBg = bookBg;
        this.isBookSelect = isBookSelect;
        this.billItemId = billItemId;
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

    public long getBillItemId() {
        return this.billItemId;
    }

    public void setBillItemId(long billItemId) {
        this.billItemId = billItemId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1971525314)
    public List<BillItem> getBillItemList() {
        if (billItemList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BillItemDao targetDao = daoSession.getBillItemDao();
            List<BillItem> billItemListNew = targetDao
                    ._queryBook_BillItemList(billItemId);
            synchronized (this) {
                if (billItemList == null) {
                    billItemList = billItemListNew;
                }
            }
        }
        return billItemList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1625199234)
    public synchronized void resetBillItemList() {
        billItemList = null;
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
    @Generated(hash = 1115456930)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBookDao() : null;
    }
}
