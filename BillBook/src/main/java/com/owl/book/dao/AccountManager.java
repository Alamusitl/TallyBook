package com.owl.book.dao;

import com.owl.book.R;
import com.owl.book.entity.Account;
import com.owl.book.entity.AccountDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/17.
 */

public class AccountManager extends BaseDaoManager<AccountDao, Account> {

    private static AccountManager sInstance = null;

    private AccountManager() {
        mDao = DaoManager.getInstance().getDaoSession().getAccountDao();
        if (!hasDataInDao(mDao)) {
            initTable();
        }
    }

    public static AccountManager getInstance() {
        if (sInstance == null) {
            synchronized (AccountManager.class) {
                if (sInstance == null) {
                    sInstance = new AccountManager();
                }
            }
        }
        return sInstance;
    }

    @Override
    protected void initTable() {
        mDao.insert(new Account(1, R.drawable.icon_alipay, "支付宝"));
        mDao.insert(new Account(2, R.drawable.icon_alipay, "微信钱包"));
        mDao.insert(new Account(3, R.drawable.icon_alipay, "现金"));
        mDao.insert(new Account(4, R.drawable.icon_alipay, "招商银行卡"));
        mDao.insert(new Account(5, R.drawable.icon_alipay, "工商银行卡"));
    }

    @Override
    public List<Account> getList() {
        Query<Account> accountQuery = mDao.queryBuilder().orderAsc(AccountDao.Properties.Id).build();
        return accountQuery.list();
    }

    @Override
    public void insert(Account data) {
        mDao.insertOrReplace(data);
    }

    @Override
    public void update(Account data) {
        mDao.update(data);
    }

    @Override
    public void delete(Account data) {
        mDao.delete(data);
    }
}
