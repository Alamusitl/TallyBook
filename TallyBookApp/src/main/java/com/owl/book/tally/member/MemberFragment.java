package com.owl.book.tally.member;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.book.R;
import com.owl.book.base.BaseFragment;
import com.owl.book.dao.MemberManager;
import com.owl.book.databinding.FragmentChooseMemberBinding;
import com.owl.book.recycler.BaseRecyclerAdapter;

import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/23.
 */

public class MemberFragment extends BaseFragment<FragmentChooseMemberBinding> implements BaseRecyclerAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private Presenter mPresenter;
    private MemberAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_choose_member, container);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new Presenter();
        mBinding.setPresenter(mPresenter);

        mRecyclerView = mBinding.idMemberRecyclerView;

        mAdapter = new MemberAdapter(getContext());
        mAdapter.setItemClickListener(this);
        List<Member> list = MemberManager.getInstance().getMemberList();
        mAdapter.setDataList(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

    public class Presenter {
        public void onBackgroundClick(View view) {
            getFragmentManager().beginTransaction().hide(MemberFragment.this).commit();
        }

        public void onEditClick(View view) {

        }

        public void onDoneClick(View view) {

        }
    }
}
