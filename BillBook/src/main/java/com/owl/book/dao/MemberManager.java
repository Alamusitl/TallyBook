package com.owl.book.dao;

import com.owl.book.entity.Member;
import com.owl.book.entity.MemberDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/23.
 */

public class MemberManager extends BaseDaoManager<MemberDao, Member> {

    private static MemberManager sInstance = null;

    public MemberManager() {
        mDao = DaoManager.getInstance().getDaoSession().getMemberDao();
        if (!hasDataInDao(mDao)) {
            initTable();
        }
    }

    public static MemberManager getInstance() {
        if (sInstance == null) {
            synchronized (MemberManager.class) {
                if (sInstance == null) {
                    sInstance = new MemberManager();
                }
            }
        }
        return sInstance;
    }

    @Override
    protected void initTable() {
        mDao.insert(new Member(1, "我"));
        mDao.insert(new Member(2, "爸爸"));
        mDao.insert(new Member(3, "妈妈"));
    }

    @Override
    public List<Member> getList() {
        Query<Member> memberQuery = mDao.queryBuilder().orderAsc(MemberDao.Properties.MemberId).build();
        return memberQuery.list();
    }

    @Override
    public void insert(Member data) {
        mDao.insertOrReplace(data);
    }

    @Override
    public void update(Member data) {
        mDao.update(data);
    }

    @Override
    public void delete(Member data) {
        mDao.delete(data);
    }
}
