package com.owl.book.main.detail;

import android.view.View;
import android.view.ViewGroup;

import com.owl.book.databinding.ViewItemAddBookBinding;
import com.owl.book.entity.Book;
import com.owl.book.recycler.BaseRecyclerAdapter;
import com.owl.book.recycler.BaseRecyclerExpandAdapter;

/**
 * Created by Imagine Owl on 2017/6/8.
 */

public class BooksFooterAdapter extends BaseRecyclerExpandAdapter {

    public BooksFooterAdapter(BaseRecyclerAdapter<? extends Book> adapter) {
        super(adapter);
    }

    @Override
    public BaseRecyclerAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mFooterViews.get(viewType) != null) {
            return new BookFooterViewHolder(ViewItemAddBookBinding.inflate(mAdapter.getLayoutInflater(), parent, false));
        }
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (isHeaderViewPos(position) || isFooterViewPos(position)) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getItemClickListener().onItemClick(v, holder.getAdapterPosition());
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    getItemClickListener().onItemLongClick(v, holder.getAdapterPosition());
                    return false;
                }
            });
        }
    }

    private class BookFooterViewHolder extends BaseViewHolder<ViewItemAddBookBinding> {

        BookFooterViewHolder(ViewItemAddBookBinding binding) {
            super(binding);
        }

        @Override
        public void bind(final BaseViewHolder holder) {

        }
    }
}
