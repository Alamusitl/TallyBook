package com.owl.book.tally.member;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.owl.book.R;
import com.owl.book.base.BaseFragment;
import com.owl.book.dao.MemberManager;
import com.owl.book.databinding.FragmentMemberManageBinding;
import com.owl.book.recycler.BaseRecyclerAdapter;

import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/25.
 */

public class MemberManageFragment extends BaseFragment<FragmentMemberManageBinding> implements BaseRecyclerAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private EditText mEtNewMember;
    private TextView mPreviousView;
    private TextView mNextView;
    private TextView mTitleView;
    private LinearLayout mInputNewMember;

    private MemberManageAdapter mAdapter;
    private Presenter mPresenter;

    private boolean mIsSettings = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_member_manage, container);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new Presenter();
        mBinding.setPresenter(mPresenter);

        mRecyclerView = mBinding.idManageMemberRecyclerView;
        mEtNewMember = mBinding.idManageMemberInput;
        mEtNewMember.requestFocus();
        mPreviousView = mBinding.idManageMemberTitlePre;
        mTitleView = mBinding.idManageMemberTitleText;
        mNextView = mBinding.idManageMemberTitleNext;
        mInputNewMember = mBinding.idManageMemberInputLayout;

        mAdapter = new MemberManageAdapter(getContext());
        mAdapter.setItemClickListener(this);
        List<Member> list = MemberManager.getInstance().getMemberList();
        mAdapter.setDataList(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onItemClick(View view, final int position) {
        if (mIsSettings) {
            for (int i = 0; i < mAdapter.getItemCount(); i++) {
                mAdapter.getDataList().get(i).setIsMemberDefault(false);
            }
            int childCount = ((ViewGroup) view.getParent()).getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup itemView = (ViewGroup) ((ViewGroup) view.getParent()).getChildAt(i);
                itemView.getChildAt(2).setVisibility(View.INVISIBLE);
            }
            mAdapter.getDataList().get(position).setIsMemberDefault(true);
            ((ViewGroup) view).getChildAt(2).setVisibility(View.VISIBLE);
        } else {

        }
    }

    @Override
    public void onItemLongClick(View view, int position) {
        //ignore
    }

    public class Presenter {

        public void onBackClick() {
            if (mIsSettings) {
                mIsSettings = false;
                mInputNewMember.setVisibility(View.VISIBLE);
                mNextView.setVisibility(View.VISIBLE);
                mPreviousView.setText(getString(R.string.manage_member_member));
                mTitleView.setText(getString(R.string.manage_member_manager));
            } else {
                getFragmentManager().beginTransaction().hide(MemberManageFragment.this).commit();
            }
        }

        public void onDefaultSettingClick() {
            mIsSettings = true;
            mInputNewMember.setVisibility(View.GONE);
            mNextView.setVisibility(View.GONE);
            mPreviousView.setText(getString(R.string.manage_member_manager));
            mTitleView.setText(getString(R.string.manage_member_choose_default));
        }

        public void onAddMemberClick() {
            String newMemberName = mEtNewMember.getText().toString();
            mEtNewMember.setText("");
            if (newMemberName.isEmpty()) {
                return;
            }
            long lastId = mAdapter.getDataList().get(mAdapter.getDataList().size() - 1).getId();
            Member member = new Member(lastId + 1, newMemberName);
            mAdapter.getDataList().add(mAdapter.getItemCount(), member);
            mAdapter.notifyItemInserted(mAdapter.getItemCount());
            MemberManager.getInstance().insertMember(member);
        }
    }
}
