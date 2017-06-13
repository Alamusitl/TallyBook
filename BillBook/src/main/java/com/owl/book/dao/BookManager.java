package com.owl.book.dao;

import com.owl.book.R;
import com.owl.book.entity.Book;
import com.owl.book.entity.BookDao;

import java.util.List;

/**
 * Created by Imagine Owl on 2017/6/9.
 */

public class BookManager extends BaseDaoManager<BookDao, Book> {

    private static BookManager sInstance = null;

    public BookManager() {
        mDao = DaoManager.getInstance().getDaoSession().getBookDao();
        if (!hasDataInDao(mDao)) {
            initTable();
        }
    }

    public static BookManager getInstance() {
        if (sInstance == null) {
            synchronized (BookManager.class) {
                if (sInstance == null) {
                    sInstance = new BookManager();
                }
            }
        }
        return sInstance;
    }

    @Override
    protected void initTable() {
        mDao.insert(new Book(1, "默认账本", R.drawable.books_default, true));
        mDao.insert(new Book(2, "旅游账本", R.drawable.books_others, false));
        mDao.insert(new Book(3, "生意账本", R.drawable.books_others, false));
    }

    @Override
    public List<Book> getList() {
        return mDao.queryBuilder().build().list();
    }

    @Override
    public void insert(Book data) {
        mDao.insert(data);
    }

    @Override
    public void update(Book data) {
        mDao.update(data);
    }

    @Override
    public void delete(Book data) {
        mDao.delete(data);
    }
}
