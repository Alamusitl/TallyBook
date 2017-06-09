package com.owl.book.tally.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.book.R;
import com.owl.book.account.Account;
import com.owl.book.base.BaseFragment;
import com.owl.book.dao.AccountManager;
import com.owl.book.databinding.FragmentChooseAccountBinding;
import com.owl.book.recycler.BaseRecyclerAdapter;
import com.owl.book.tally.AddOneFragment;

import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/18.
 */

public class AccountFragment extends BaseFragment<FragmentChooseAccountBinding> implements BaseRecyclerAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private AccountItemAdapter mAdapter;
    private Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_choose_account, container);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new Presenter();
        mBinding.setPresenter(mPresenter);

        mRecyclerView = mBinding.idAccountRecyclerView;

        mAdapter = new AccountItemAdapter(getContext());
        mAdapter.setItemClickListener(this);
        List<Account> dataList = AccountManager.getInstance().getList();
        mAdapter.setDataList(dataList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onItemClick(View view, int position) {
        List<Account> list = mAdapter.getDataList();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setAccountSelect(false);
        }
        list.get(position).setAccountSelect(true);
        getFragmentManager().beginTransaction().hide(AccountFragment.this).commit();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        onItemClick(view, position);
    }

    public class Presenter {
        public void onBackgroundClick(View view) {
            getFragmentManager().beginTransaction().hide(AccountFragment.this).commit();
            dismiss(AddOneFragment.class.getName(), null);
        }
    }
}
