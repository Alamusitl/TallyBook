package com.owl.book.bill;

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
import com.owl.book.bill.account.AccountFragment;
import com.owl.book.bill.date.DatePickerFragment;
import com.owl.book.bill.desc.AddDescFragment;
import com.owl.book.bill.member.MemberFragment;
import com.owl.book.databinding.FragmentAddOneBinding;
import com.owl.book.entity.Account;
import com.owl.book.entity.BillItem;
import com.owl.book.entity.BillTypeItem;
import com.owl.book.entity.Member;
import com.owl.book.util.ResUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class AddOneFragment extends BaseFragment<FragmentAddOneBinding> implements BillTypeItemAdapter.OnItemClickListener {

    /**
     * Fragment Views
     */
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
    private BillItem mBillItem;
    private Account mAccount;
    private List<Member> mMembers;

    private BillTypeItemAdapter mAdapter;

    private StringBuilder mMoney;

    private AccountFragment mAccountFragment;
    private MemberFragment mMemberFragment;
    private AddDescFragment mAddDescFragment;
    private DatePickerFragment mDatePickFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        instanceBinding(inflater, R.layout.fragment_add_one, container);
        registerEventListener();
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new Presenter();
        mBinding.setPresenter(mPresenter);

        mBillItem = new BillItem();
        mBinding.setBillItem(mBillItem);

        mAccount = new Account();
        mBinding.setAccount(mAccount);

        initViews();

        mAdapter = new BillTypeItemAdapter(getContext());
        mAdapter.setOnItemClickListener(this);
        initData();

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unregisterEventListener();
    }

    private void initViews() {
        mTvEarn = mBinding.idAddEarn;
        mTvPay = mBinding.idAddPay;
        mTvPay.setSelected(true);
        mTvSelectItem = mBinding.idAddSelectItemName;
        mIvSelectItem = mBinding.idAddSelectItemImg;
        mRecyclerView = mBinding.idAddRecyclerView;
    }

    public void initData() {
        List<BillTypeItem> earnList = new ArrayList<>();
        String[] earnListImg = getContext().getResources().getStringArray(R.array.earn_list_drawable);
        String[] earnListName = getContext().getResources().getStringArray(R.array.earn_list_name);
        for (int i = 0; i < earnListName.length; i++) {
            earnList.add(new BillTypeItem(earnListName[i], ResUtils.getDrawableId(getContext(), earnListImg[i])));
        }
        mAdapter.setEarnList(earnList);

        List<BillTypeItem> payList = new ArrayList<>();
        String[] payListImg = getContext().getResources().getStringArray(R.array.pay_list_drawable);
        String[] payListName = getContext().getResources().getStringArray(R.array.payment_list_name);
        for (int i = 0; i < payListName.length; i++) {
            payList.add(new BillTypeItem(payListName[i], ResUtils.getDrawableId(getContext(), payListImg[i])));
        }
        mAdapter.setPayList(payList);
        mAdapter.setEarn(false);
        mMoney = new StringBuilder("0.00");
        mBillItem.setMoney(Float.parseFloat(mMoney.toString()));
    }

    @Override
    public void onItemClick(View view, int position) {
        BillTypeItem item;
        if (mAdapter.isEarn()) {
            item = mAdapter.getEarnList().get(position);
        } else {
            item = mAdapter.getPayList().get(position);
        }
        mTvSelectItem.setText(item.getBillTypeItemName());
        mIvSelectItem.setImageResource(item.getBillTypeItemDrawableId() == 0 ? R.drawable.icon_other : item.getBillTypeItemDrawableId());
    }

    @Override
    public void onItemLongClick(View view, int position) {
        onItemClick(view, position);
    }

    @Override
    public void handleDismiss(String src, Bundle extras) {
        super.handleDismiss(src, extras);
        if (mAccountFragment != null && src.equals(mAccountFragment.getName())) {
            mChooseAccountView.setSelected(false);
            if (extras != null) {
                mAccount.setAccount((Account) extras.getParcelable(AccountFragment.KEY_SELECT_ACCOUNT));
                mBillItem.setAccount(mAccount);
            }
        } else if (mMemberFragment != null && src.equals(mMemberFragment.getName())) {
            mChooseMemberView.setSelected(false);
            if (extras != null) {
                List<Member> members = extras.getParcelableArrayList(MemberFragment.KEY_MEMBERS);
                if (members == null) {
                    return;
                }
                for (Member member : members) {
                    mMembers.add(member);
                }
            }
        } else if (mAddDescFragment != null && src.equals(mAddDescFragment.getName())) {
            mEditDescView.setSelected(false);
            if (extras != null) {
                String desc = extras.getString(AddDescFragment.KEY_DESC);
                mBillItem.setDesc(desc);
            }
        } else if (mDatePickFragment != null && src.equals(mDatePickFragment.getName())) {
            mChooseDateView.setSelected(false);
            if (extras != null) {

            }
        }
    }

    public class Presenter {

        public void onSelectTabClicked(View view) {
            if (view == mTvEarn) {
                mTvEarn.setSelected(true);
                mTvPay.setSelected(false);
                mAdapter.setEarn(true);
            } else if (view == mTvPay) {
                mTvPay.setSelected(true);
                mTvEarn.setSelected(false);
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
                getFragmentManager().beginTransaction().add(R.id.id_fragmentContainer, fragment, clz.getName())
                        .setCustomAnimations(R.anim.fragment_show, R.anim.fragment_hide).commit();
            } else {
                getFragmentManager().beginTransaction().show(fragment)
                        .setCustomAnimations(R.anim.fragment_show, R.anim.fragment_hide).commit();
            }
        }
    }
}
