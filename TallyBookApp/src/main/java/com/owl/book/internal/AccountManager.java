package com.owl.book.internal;

import com.owl.book.R;
import com.owl.book.dao.DaoManager;
import com.owl.book.tally.AccountItem;
import com.owl.book.tally.AccountItemDao;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/17.
 */

public class AccountManager {

    private static AccountManager sInstance = null;

    private AccountItemDao mAccountItemDao = null;

    private AccountManager() {
        mAccountItemDao = DaoManager.getInstance().getDaoSession().getAccountItemDao();
        if (!hasDataInDao()) {
            loadProperties();
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

    public List<AccountItem> getAccountList() {
        List<AccountItem> list = new ArrayList<>();
        Query<AccountItem> accountQuery = mAccountItemDao.queryBuilder().orderAsc(AccountItemDao.Properties.Id).build();
        List<AccountItem> accounts = accountQuery.list();
        for (AccountItem account : accounts) {
            list.add(account);
        }
        return list;
    }

    private boolean hasDataInDao() {
        Query<AccountItem> accountQuery = mAccountItemDao.queryBuilder().orderAsc(AccountItemDao.Properties.Id).build();
        if (accountQuery == null) {
            return false;
        }
        List<AccountItem> accounts = accountQuery.list();
        return !(accounts == null || accounts.isEmpty());
    }

    private void loadProperties() {
        mAccountItemDao.insert(new AccountItem(1, R.drawable.icon_alipay, "支付宝"));
        mAccountItemDao.insert(new AccountItem(2, R.drawable.icon_alipay, "微信钱包"));
        mAccountItemDao.insert(new AccountItem(3, R.drawable.icon_alipay, "现金"));
        mAccountItemDao.insert(new AccountItem(4, R.drawable.icon_alipay, "招商银行卡"));
        mAccountItemDao.insert(new AccountItem(5, R.drawable.icon_alipay, "工商银行卡"));
    }
}
