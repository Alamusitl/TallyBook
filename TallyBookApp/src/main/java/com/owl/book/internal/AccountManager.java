package com.owl.book.internal;

import com.owl.book.ChooseItem;
import com.owl.book.bean.Account;
import com.owl.book.bean.AccountDao;
import com.owl.book.config.Constants;
import com.owl.book.dao.DaoManager;

import org.greenrobot.greendao.query.Query;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Imagine Owl on 2017/5/17.
 */

public class AccountManager {

    private static AccountManager sInstance = null;

    private AccountDao mAccountDao = null;

    public AccountManager() {
        mAccountDao = DaoManager.getInstance().getDaoSession().getAccountDao();
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

    public List<ChooseItem> getAccountList() {
        List<ChooseItem> list = new ArrayList<>();
        Query<Account> accountQuery = mAccountDao.queryBuilder().orderAsc(AccountDao.Properties.Id).build();
        List<Account> accounts = accountQuery.list();
        for (Account account : accounts) {
            list.add(new ChooseItem(account.getName()));
        }
        return list;
    }

    private boolean hasDataInDao() {
        Query<Account> accountQuery = mAccountDao.queryBuilder().orderAsc(AccountDao.Properties.Id).build();
        if (accountQuery == null) {
            return false;
        }
        List<Account> accounts = accountQuery.list();
        return !(accounts == null || accounts.isEmpty());
    }

    private void loadProperties() {
        Single.just(Constants.ACCOUNT_PROPERTIES).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String file) throws Exception {
                Properties properties = new Properties();
                try {
                    properties.load(new InputStreamReader(AccountManager.class.getResourceAsStream(file), Constants.DEFAULT_CHARSET));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (properties.isEmpty()) {
                    return;
                }
                for (Object key : properties.keySet()) {
                    String value = (String) properties.get(key);
                    System.out.println(key + " : " + value);
                    mAccountDao.insert(new Account(Long.parseLong((String) key), value));
                }
            }
        });
    }
}
