package com.owl.book.bill.member;

import android.content.Context;
import android.view.ViewGroup;

import com.owl.book.databinding.ViewItemChooseMemberBinding;
import com.owl.book.entity.Member;
import com.owl.book.recycler.BaseRecyclerAdapter;


/**
 * Created by Imagine Owl on 2017/5/23.
 */

public class MemberAdapter extends BaseRecyclerAdapter<Member> {

    public MemberAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MemberViewHolder(ViewItemChooseMemberBinding.inflate(mInflater, parent, false));
    }

    private class MemberViewHolder extends BaseViewHolder<ViewItemChooseMemberBinding> {

        MemberViewHolder(ViewItemChooseMemberBinding binding) {
            super(binding);
        }

        @Override
        public void bind(Member data) {
            ((ViewItemChooseMemberBinding) mBinding).setItem(data);
            mBinding.executePendingBindings();
        }
    }
}
