package com.owl.book.bill.member;

import android.content.Context;
import android.view.ViewGroup;

import com.owl.book.recycler.BaseRecyclerAdapter;

import null.databinding.ViewItemManageMemberBinding;

/**
 * Created by Imagine Owl on 2017/5/25.
 */

public class MemberManageAdapter extends BaseRecyclerAdapter<Member> {

    public MemberManageAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MemberManageViewHolder(ViewItemManageMemberBinding.inflate(mInflater, parent, false));
    }

    private class MemberManageViewHolder extends BaseViewHolder<ViewItemManageMemberBinding> {

        MemberManageViewHolder(ViewItemManageMemberBinding binding) {
            super(binding);
        }

        @Override
        public void bind(Member data) {
            ((ViewItemManageMemberBinding) mBinding).setMember(data);
            mBinding.executePendingBindings();
        }
    }
}
