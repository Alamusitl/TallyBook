package com.owl.book.dao;

import com.owl.book.entity.DaoSession;

/**
 * Created by Imagine Owl on 2017/5/17.
 */

public class DaoManager {

    public static final String DB_NAME = "book-db";
    private static DaoManager sInstance = null;
    private DaoSession mDaoSession;

    public static DaoManager getInstance() {
        if (sInstance == null) {
            synchronized (DaoManager.class) {
                if (sInstance == null) {
                    sInstance = new DaoManager();
                }
            }
        }
        return sInstance;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public void setDaoSession(DaoSession daoSession) {
        mDaoSession = daoSession;
    }
}
