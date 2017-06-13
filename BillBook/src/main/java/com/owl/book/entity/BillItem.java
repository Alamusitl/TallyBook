package com.owl.book.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.owl.book.util.DateTimeUtil;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.Date;
import java.util.List;

/**
 * Created by Alamusi on 2017/5/9.
 */
@Entity
public class BillItem extends BaseObservable {

    @Id(autoincrement = true)
    private Long id;
    @Convert(converter = BillTypeConverter.class, columnType = Integer.class)
    private BillType billType;
    @NotNull
    private float money;
    private String desc;
    @NotNull
    private Date date;
    private long accountId;
    @ToOne(joinProperty = "accountId")
    private Account account;
    private long billTypeItemId;
    @ToOne(joinProperty = "billTypeItemId")
    private BillTypeItem billTypeItem;
    private long memberId;
    @ToMany(joinProperties = {
            @JoinProperty(name = "memberId", referencedName = "memberId")
    })
    @OrderBy("memberId ASC")
    private List<Member> members;
    @Transient
    private String mShowDate;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1851095063)
    private transient BillItemDao myDao;
    @Generated(hash = 1501133588)
    private transient Long account__resolvedKey;
    @Generated(hash = 474825789)
    private transient Long billTypeItem__resolvedKey;

    public BillItem() {
        billType = BillType.COST;
        date = DateTimeUtil.getCurrDate();
        mShowDate = DateTimeUtil.getFormatDateNoYear(date);
        account = new Account();
    }

    @Generated(hash = 1626574267)
    public BillItem(Long id, BillType billType, float money, String desc, @NotNull Date date, long accountId,
                    long billTypeItemId, long memberId) {
        this.id = id;
        this.billType = billType;
        this.money = money;
        this.desc = desc;
        this.date = date;
        this.accountId = accountId;
        this.billTypeItemId = billTypeItemId;
        this.memberId = memberId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        setShowDate(DateTimeUtil.getFormatDateNoYear(date));
    }

    @Bindable
    public String getShowDate() {
        return mShowDate;
    }

    private void setShowDate(String showDate) {
        mShowDate = showDate;
    }

    public float getMoney() {
        return this.money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getBillTypeItemId() {
        return billTypeItemId;
    }

    public void setBillTypeItemId(long billTypeItemId) {
        this.billTypeItemId = billTypeItemId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public BillType getBillType() {
        return this.billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 2143533054)
    public Account getAccount() {
        long __key = this.accountId;
        if (account__resolvedKey == null || !account__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AccountDao targetDao = daoSession.getAccountDao();
            Account accountNew = targetDao.load(__key);
            synchronized (this) {
                account = accountNew;
                account__resolvedKey = __key;
            }
        }
        return account;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1716871290)
    public void setAccount(@NotNull Account account) {
        if (account == null) {
            throw new DaoException(
                    "To-one property 'accountId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.account = account;
            accountId = account.getId();
            account__resolvedKey = accountId;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 877650884)
    public BillTypeItem getBillTypeItem() {
        long __key = this.billTypeItemId;
        if (billTypeItem__resolvedKey == null || !billTypeItem__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BillTypeItemDao targetDao = daoSession.getBillTypeItemDao();
            BillTypeItem billTypeItemNew = targetDao.load(__key);
            synchronized (this) {
                billTypeItem = billTypeItemNew;
                billTypeItem__resolvedKey = __key;
            }
        }
        return billTypeItem;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 73191743)
    public void setBillTypeItem(@NotNull BillTypeItem billTypeItem) {
        if (billTypeItem == null) {
            throw new DaoException(
                    "To-one property 'billTypeItemId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.billTypeItem = billTypeItem;
            billTypeItemId = billTypeItem.getId();
            billTypeItem__resolvedKey = billTypeItemId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 808519059)
    public List<Member> getMembers() {
        if (members == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberDao targetDao = daoSession.getMemberDao();
            List<Member> membersNew = targetDao._queryBillItem_Members(memberId);
            synchronized (this) {
                if (members == null) {
                    members = membersNew;
                }
            }
        }
        return members;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1358688666)
    public synchronized void resetMembers() {
        members = null;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1392616716)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBillItemDao() : null;
    }

    public enum BillType {
        EARN(0), COST(1),;
        final int id;

        BillType(int id) {
            this.id = id;
        }
    }

    public static class BillTypeConverter implements PropertyConverter<BillType, Integer> {
        @Override
        public BillType convertToEntityProperty(Integer databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            switch (databaseValue) {
                case 0:
                    return BillType.EARN;
                case 1:
                    return BillType.COST;
            }
            return BillType.COST;
        }

        @Override
        public Integer convertToDatabaseValue(BillType entityProperty) {
            if (entityProperty == null) {
                return null;
            }
            return entityProperty.id;
        }
    }
}
