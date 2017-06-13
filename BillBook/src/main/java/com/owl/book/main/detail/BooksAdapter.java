package com.owl.book.main.detail;

import android.content.Context;
import android.view.ViewGroup;

import com.owl.book.databinding.ViewItemBookBinding;
import com.owl.book.entity.Book;
import com.owl.book.recycler.BaseRecyclerAdapter;

/**
 * Created by Imagine Owl on 2017/6/8.
 */

public class BooksAdapter extends BaseRecyclerAdapter<Book> {

    public BooksAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookItemViewHolder(ViewItemBookBinding.inflate(mInflater, parent, false));
    }

    private class BookItemViewHolder extends BaseViewHolder<ViewItemBookBinding> {

        BookItemViewHolder(ViewItemBookBinding binding) {
            super(binding);
        }

        @Override
        public void bind(Book data) {
            ((ViewItemBookBinding) mBinding).setBook(data);
            mBinding.executePendingBindings();
        }
    }
}
