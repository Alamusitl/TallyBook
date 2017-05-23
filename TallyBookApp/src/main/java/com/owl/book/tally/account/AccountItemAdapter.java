package com.owl.book.tally.account;

import android.content.Context;
import android.view.ViewGroup;

import com.owl.book.databinding.ViewItemChooseAccountBinding;
import com.owl.book.recycler.BaseRecyclerAdapter;

/**
 * Created by Imagine Owl on 2017/5/18.
 */

public class AccountItemAdapter extends BaseRecyclerAdapter<Account> {

    public AccountItemAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChooseViewHolder(ViewItemChooseAccountBinding.inflate(mInflater, parent, false));
    }

    private class ChooseViewHolder extends BaseViewHolder<ViewItemChooseAccountBinding> {

        ChooseViewHolder(ViewItemChooseAccountBinding binding) {
            super(binding);
        }

        @Override
        public void bind(Account data) {
            ((ViewItemChooseAccountBinding) mBinding).setItem(data);
            mBinding.executePendingBindings();
        }
    }
}
