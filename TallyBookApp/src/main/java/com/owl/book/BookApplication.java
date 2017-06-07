package com.owl.book;

import android.app.Application;

import com.owl.book.account.DaoMaster;
import com.owl.book.dao.DaoManager;

import org.greenrobot.greendao.database.Database;

/**
 * Application entrance
 * Created by Alamusi on 2017/4/19.
 */

public class BookApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DaoManager.DB_NAME);
        Database db = helper.getWritableDb();
        DaoManager.getInstance().setDaoSession(new DaoMaster(db).newSession());

        System.out.println("getResources().getDisplayMetrics().density = " + getResources().getDisplayMetrics().density);
    }
}
