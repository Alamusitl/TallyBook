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
        mDao.insert(new Account(R.drawable.icon_alipay_grey, R.drawable.icon_alipay_white, "支付宝"));
        mDao.insert(new Account(R.drawable.icon_cash_grey, R.drawable.icon_cash_white, "现金"));
        mDao.insert(new Account(R.drawable.icon_deposit_card_grey, R.drawable.icon_deposit_card_white, "招商银行卡"));
        mDao.insert(new Account(R.drawable.icon_deposit_card_grey, R.drawable.icon_deposit_card_white, "工商银行卡"));
    }

    @Override
    public List<Account> getList() {
        DaoManager.getInstance().clear();
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
