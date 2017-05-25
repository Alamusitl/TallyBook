package com.owl.book.tally;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.owl.book.R;
import com.owl.book.base.BaseFragment;
import com.owl.book.dao.AccountManager;
import com.owl.book.databinding.FragmentAddOneBinding;
import com.owl.book.tally.account.AccountFragment;
import com.owl.book.tally.date.DatePickerFragment;
import com.owl.book.tally.desc.AddDescFragment;
import com.owl.book.tally.member.MemberFragment;
import com.owl.book.tally.model.OneTally;
import com.owl.book.tally.model.TallyItem;
import com.owl.book.util.ResUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class AddOneFragment extends BaseFragment<FragmentAddOneBinding> implements TallyTypeItemAdapter.OnItemClickListener {

    private TextView mTvEarn;
    private TextView mTvPay;

    private TextView mTvSelectItem;
    private ImageView mIvSelectItem;

    private View mChooseAccountView;
    private View mChooseDateView;
    private View mChooseMemberView;
    private View mEditDescView;

    private RecyclerView mRecyclerView;

    private Presenter mPresenter;
    private OneTally mOneTally;

    private TallyTypeItemAdapter mAdapter;

    private StringBuilder mMoney;

    private Fragment mAccountFragment;
    private Fragment mMemberFragment;
    private Fragment mAddDescFragment;
    private Fragment mDatePickFragment;

    private void initViews() {
        mTvEarn = mBinding.idAddEarn;
        mTvPay = mBinding.idAddPay;
        mTvPay.setSelected(true);
        mTvSelectItem = mBinding.idAddSelectItemName;
        mIvSelectItem = mBinding.idAddSelectItemImg;
        mRecyclerView = mBinding.idAddRecyclerView;
    }

    public void initData() {
        List<TallyItem> earnList = new ArrayList<>();
        String[] earnListImg = getContext().getResources().getStringArray(R.array.earn_list_drawable);
        String[] earnListName = getContext().getResources().getStringArray(R.array.earn_list_name);
        for (int i = 0; i < earnListName.length; i++) {
            earnList.add(new TallyItem(earnListName[i], ResUtils.getDrawableId(getContext(), earnListImg[i])));
        }
        mAdapter.setEarnList(earnList);

        List<TallyItem> payList = new ArrayList<>();
        String[] payListImg = getContext().getResources().getStringArray(R.array.pay_list_drawable);
        String[] payListName = getContext().getResources().getStringArray(R.array.payment_list_name);
        for (int i = 0; i < payListName.length; i++) {
            payList.add(new TallyItem(payListName[i], ResUtils.getDrawableId(getContext(), payListImg[i])));
        }
        mAdapter.setPayList(payList);
        mAdapter.setEarn(false);
        mMoney = new StringBuilder("0.00");
        mOneTally.setMoney(mMoney.toString());

        AccountManager.getInstance();
    }

    @Override
    public void onItemClick(View view, int position) {
        TallyItem item;
        if (mAdapter.isEarn()) {
            item = mAdapter.getEarnList().get(position);
        } else {
            item = mAdapter.getPayList().get(position);
        }
        mTvSelectItem.setText(item.getItemName());
        mIvSelectItem.setImageResource(item.getItemDrawableId() == 0 ? R.drawable.icon_other : item.getItemDrawableId());
    }

    @Override
    public void onItemLongClick(View view, int position) {
        onItemClick(view, position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_add_one, container);
        registerEventListener(AddOneFragment.class, this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new Presenter();
        mBinding.setPresenter(mPresenter);

        mOneTally = new OneTally();
        mBinding.setOneTally(mOneTally);

        initViews();

        mAdapter = new TallyTypeItemAdapter(getContext());
        mAdapter.setOnItemClickListener(this);
        initData();

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unregisterEventListener(AddOneFragment.class, this);
    }

    @Override
    public void dismiss(Class clz, Fragment fragment, Bundle bundle) {
        if (fragment == mAccountFragment) {
            mChooseAccountView.setSelected(false);
            if (bundle != null) {

            }
        } else if (fragment == mMemberFragment) {
            mChooseMemberView.setSelected(false);
            if (bundle != null) {
                List<String> members = bundle.getStringArrayList(MemberFragment.KEY_MEMBERS);
            }
        } else if (fragment == mAddDescFragment) {
            mEditDescView.setSelected(false);
            if (bundle != null) {
                String desc = bundle.getString(AddDescFragment.KEY_DESC);
            }
        } else if (fragment == mDatePickFragment) {
            mChooseDateView.setSelected(false);
            if (bundle != null) {

            }
        }
    }

    public class Presenter {

        public void onSelectTabClicked(View view) {
            if (view == mTvEarn) {
                mTvEarn.setSelected(true);
                mTvPay.setSelected(false);
                mOneTally.setEarn(true);
                mAdapter.setEarn(true);
            } else if (view == mTvPay) {
                mTvPay.setSelected(true);
                mTvEarn.setSelected(false);
                mOneTally.setPay(true);
                mAdapter.setEarn(false);
            }
        }

        public void onCloseClick() {
            finish();
            getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
        }

        public void onKeyboardNumClick(String value) {
            switch (value) {
                case "0":
                    break;
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case ".":
                    break;
                case "C":
                    break;
                case "+":
                    break;
                case "-":
                    break;
                case "Del":
                    break;
                case "确定":
                    break;
            }
            System.out.println(value);
        }

        public void onChooseAccountTypeClick(View view) {
            mChooseAccountView = view;
            if (mAccountFragment == null) {
                mAccountFragment = new AccountFragment();
            }
            handleClick(AccountFragment.class, mAccountFragment);
        }

        public void onChooseDateClick(View view) {
            mChooseDateView = view;
            if (mDatePickFragment == null) {
                mDatePickFragment = new DatePickerFragment();
            }
            handleClick(DatePickerFragment.class, mDatePickFragment);
        }

        public void onChooseMemberClick(View view) {
            mChooseMemberView = view;
            view.setSelected(true);
            if (mMemberFragment == null) {
                mMemberFragment = new MemberFragment();
            }
            handleClick(MemberFragment.class, mMemberFragment);
        }

        public void onAddDescriptionClick(View view) {
            mEditDescView = view;
            view.setSelected(true);
            if (mAddDescFragment == null) {
                mAddDescFragment = new AddDescFragment();
            }
            handleClick(AddDescFragment.class, mAddDescFragment);
        }

        private void handleClick(Class clz, Fragment fragment) {
            if (getFragmentManager().findFragmentByTag(clz.getName()) == null) {
                getFragmentManager().beginTransaction().add(R.id.id_fragmentContainer, fragment, clz.getName()).commit();
            } else {
                getFragmentManager().beginTransaction().show(fragment).commit();
            }
        }
    }
}
