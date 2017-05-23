package com.owl.book.dao;

import com.owl.book.R;
import com.owl.book.tally.account.Account;
import com.owl.book.tally.account.AccountDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/17.
 */

public class AccountManager extends BaseDaoManager<AccountDao> {

    private static AccountManager sInstance = null;

    private AccountDao mAccountDao = null;

    private AccountManager() {
        mAccountDao = DaoManager.getInstance().getDaoSession().getAccountDao();
        if (!hasDataInDao(mAccountDao)) {
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

    public List<Account> getAccountList() {
        Query<Account> accountQuery = mAccountDao.queryBuilder().orderAsc(AccountDao.Properties.Id).build();
        return accountQuery.list();
    }

    @Override
    protected void initTable() {
        mAccountDao.insert(new Account(1, R.drawable.icon_alipay, "支付宝"));
        mAccountDao.insert(new Account(2, R.drawable.icon_alipay, "微信钱包"));
        mAccountDao.insert(new Account(3, R.drawable.icon_alipay, "现金"));
        mAccountDao.insert(new Account(4, R.drawable.icon_alipay, "招商银行卡"));
        mAccountDao.insert(new Account(5, R.drawable.icon_alipay, "工商银行卡"));
    }
}
