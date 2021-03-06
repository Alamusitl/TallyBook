package com.owl.book.dao;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/23.
 */

abstract class BaseDaoManager<T extends AbstractDao, D> {

    T mDao;

    boolean hasDataInDao(T dao) {
        Query query = dao.queryBuilder().build();
        if (query == null) {
            return false;
        }
        List accounts = query.list();
        return !(accounts == null || accounts.isEmpty());
    }

    protected abstract void initTable();

    public abstract List<D> getList();

    public abstract void insert(D data);

    public abstract void update(D data);

    public abstract void delete(D data);
}
