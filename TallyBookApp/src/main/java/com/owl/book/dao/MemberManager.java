package com.owl.book.dao;

import com.owl.book.tally.member.Member;
import com.owl.book.tally.member.MemberDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/23.
 */

public class MemberManager extends BaseDaoManager<MemberDao> {

    private static MemberManager sInstance = null;
    private MemberDao mMemberDao;

    public MemberManager() {
        mMemberDao = DaoManager.getInstance().getDaoSession().getMemberDao();
        if (!hasDataInDao(mMemberDao)) {
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

    public List<Member> getMemberList() {
        Query<Member> memberQuery = mMemberDao.queryBuilder().orderAsc(MemberDao.Properties.Id).build();
        return memberQuery.list();
    }

    @Override
    protected void initTable() {
        mMemberDao.insert(new Member(1, "我"));
        mMemberDao.insert(new Member(2, "爸爸"));
        mMemberDao.insert(new Member(3, "妈妈"));
    }

    public void insertMember(Member member) {
        mMemberDao.insertOrReplace(member);
    }

    public void updateMember(Member member) {
        mMemberDao.update(member);
    }

    public void deleteMember(Member member) {
        mMemberDao.delete(member);
    }
}
