package com.owl.book.tally;

import android.content.Context;
import android.view.ViewGroup;

import com.owl.book.databinding.ViewChooseAccountItemBinding;
import com.owl.book.recycler.BaseRecyclerAdapter;

/**
 * Created by Imagine Owl on 2017/5/18.
 */

public class AccountItemAdapter extends BaseRecyclerAdapter<AccountItem> {

    public AccountItemAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChooseViewHolder(ViewChooseAccountItemBinding.inflate(mInflater, parent, false));
    }

    private class ChooseViewHolder extends BaseViewHolder<ViewChooseAccountItemBinding> {

        ChooseViewHolder(ViewChooseAccountItemBinding binding) {
            super(binding);
        }

        @Override
        public void bind(AccountItem data) {
            ((ViewChooseAccountItemBinding) mBinding).setItem(data);
            mBinding.executePendingBindings();
        }
    }
}
