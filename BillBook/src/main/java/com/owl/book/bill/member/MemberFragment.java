package com.owl.book.bill.member;

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
import com.owl.book.bill.AddOneFragment;
import com.owl.book.dao.MemberManager;
import com.owl.book.recycler.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import null.databinding.FragmentChooseMemberBinding;

/**
 * Created by Imagine Owl on 2017/5/23.
 */

public class MemberFragment extends BaseFragment<FragmentChooseMemberBinding> implements BaseRecyclerAdapter.OnItemClickListener {

    public static final String KEY_MEMBERS = "members";
    private RecyclerView mRecyclerView;
    private Presenter mPresenter;
    private MemberAdapter mAdapter;
    private MemberManageFragment mMemberManageFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_choose_member, container);
        registerEventListener();
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
        List<Member> list = MemberManager.getInstance().getList();
        mAdapter.setDataList(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unregisterEventListener();
    }

    @Override
    public void handleDismiss(String src, Bundle extras) {
        super.handleDismiss(src, extras);
    }

    @Override
    public void onItemClick(View view, int position) {
        List<Member> list = mAdapter.getDataList();
        list.get(position).setMemberSelect(!list.get(position).isMemberSelect());
    }

    @Override
    public void onItemLongClick(View view, int position) {
        onItemClick(view, position);
    }

    public class Presenter {
        public void onBackgroundClick(View view) {
            handleDismiss(null);
        }

        public void onEditClick(View view) {
            String tag = MemberManageFragment.class.getName();
            if (getFragmentManager().findFragmentByTag(tag) == null) {
                mMemberManageFragment = new MemberManageFragment();
                getFragmentManager().beginTransaction().add(R.id.id_fragmentContainer, mMemberManageFragment, tag)
                        .setCustomAnimations(R.anim.fragment_show, R.anim.fragment_hide).commit();
            } else {
                getFragmentManager().beginTransaction().show(mMemberManageFragment)
                        .setCustomAnimations(R.anim.fragment_show, R.anim.fragment_hide).commit();
            }
        }

        public void onDoneClick(View view) {
            Bundle bundle = new Bundle();
            ArrayList<String> members = new ArrayList<>();
            for (int i = 0; i < mAdapter.getDataList().size(); i++) {
                if (mAdapter.getDataList().get(i).isMemberSelect()) {
                    members.add(mAdapter.getDataList().get(i).getMemberName());
                }
            }
            bundle.putStringArrayList(KEY_MEMBERS, members);
            handleDismiss(bundle);
        }

        private void handleDismiss(Bundle bundle) {
            getFragmentManager().beginTransaction().hide(MemberFragment.this).commit();
            dismiss(AddOneFragment.class.getName(), bundle);
        }
    }
}
