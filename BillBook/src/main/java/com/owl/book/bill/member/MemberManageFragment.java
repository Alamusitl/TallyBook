package com.owl.book.bill.member;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.owl.book.R;
import com.owl.book.base.BaseFragment;
import com.owl.book.dao.MemberManager;
import com.owl.book.databinding.FragmentMemberManageBinding;
import com.owl.book.entity.Member;
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
        List<Member> list = MemberManager.getInstance().getList();
        mAdapter.setDataList(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onItemClick(View view, final int position) {
        if (mIsSettings) {
            Member member = mAdapter.getDataList().get(position);
            boolean isDefault = member.getIsMemberDefault();
            for (int i = 0; i < mAdapter.getItemCount(); i++) {
                mAdapter.getDataList().get(i).setIsMemberDefault(false);
            }
            member.setIsMemberDefault(!isDefault);
            hideItemSelectImg();
            ((ViewGroup) view).getChildAt(2).setVisibility(member.getIsMemberDefault() ? View.VISIBLE : View.INVISIBLE);
        } else {
            final EditText etMember = ((EditText) ((ViewGroup) view).getChildAt(0));
            etMember.setFocusable(true);
            etMember.setFocusableInTouchMode(true);
            etMember.requestFocus();
            etMember.setSelection(etMember.getText().length());
            etMember.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        mAdapter.getDataList().get(position).setMemberName(etMember.getText().toString());
                        etMember.setFocusable(false);
                        etMember.setFocusableInTouchMode(false);
                        return true;
                    }
                    return false;
                }
            });
            etMember.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        mAdapter.getDataList().get(position).setMemberName(etMember.getText().toString());
                    }
                }
            });
        }
    }

    @Override
    public void onItemLongClick(View view, int position) {
        //ignore
    }

    private void hideItemSelectImg() {
        int childCount = mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup itemView = (ViewGroup) mRecyclerView.getChildAt(i);
            itemView.getChildAt(2).setVisibility(View.INVISIBLE);
        }
    }

    public class Presenter {

        public void onBackClick() {
            if (mIsSettings) {
                mIsSettings = false;
                mInputNewMember.setVisibility(View.VISIBLE);
                mNextView.setVisibility(View.VISIBLE);
                mPreviousView.setText(getString(R.string.manage_member_member));
                mTitleView.setText(getString(R.string.manage_member_manager));
                hideItemSelectImg();
                mBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right));
            } else {
                for (int i = 0; i < mAdapter.getItemCount(); i++) {
                    MemberManager.getInstance().update(mAdapter.getDataList().get(i));
                }
                dismiss(MemberFragment.class.getName(), null);
                getFragmentManager().beginTransaction().hide(MemberManageFragment.this).commit();
            }
        }

        public void onDefaultSettingClick() {
            mIsSettings = true;
            mInputNewMember.setVisibility(View.GONE);
            mNextView.setVisibility(View.GONE);
            mPreviousView.setText(getString(R.string.manage_member_manager));
            mTitleView.setText(getString(R.string.manage_member_choose_default));
            mBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right));
        }

        public void onAddMemberClick() {
            String newMemberName = mEtNewMember.getText().toString();
            mEtNewMember.setText("");
            if (newMemberName.isEmpty()) {
                return;
            }
            long lastId = mAdapter.getDataList().get(mAdapter.getDataList().size() - 1).getMemberId();
            Member member = new Member(lastId + 1, newMemberName);
            mAdapter.getDataList().add(mAdapter.getItemCount(), member);
            mAdapter.notifyItemInserted(mAdapter.getItemCount());
            MemberManager.getInstance().insert(member);
        }
    }
}
