package com.owl.tallybook.recycler;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Common DataBinding ViewHolder
 * Created by Alamusi on 2017/5/11.
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    protected T mBinding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public T getBinding() {
        return mBinding;
    }
}
