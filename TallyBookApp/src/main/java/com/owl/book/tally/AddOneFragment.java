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

    private RecyclerView mRecyclerView;

    private Presenter mPresenter;
    private OneTally mOneTally;

    private TallyTypeItemAdapter mAdapter;

    private StringBuilder mMoney;

    private Fragment mAccountFragment;
    private Fragment mMemberFragment;

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
        // ignore
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_add_one, container);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
            if (getFragmentManager().findFragmentByTag(AccountManager.class.getName()) == null) {
                mAccountFragment = new AccountFragment();
                getFragmentManager().beginTransaction().add(R.id.id_fragmentContainer, mAccountFragment, AccountManager.class.getName()).commit();
            } else {
                getFragmentManager().beginTransaction().show(mAccountFragment).commit();
            }
        }

        public void onChooseDateClick(View view) {

        }

        public void onChooseMemberClick(View view) {
            view.setSelected(true);
            if (getFragmentManager().findFragmentByTag(MemberFragment.class.getName()) == null) {
                mMemberFragment = new MemberFragment();
                getFragmentManager().beginTransaction().add(R.id.id_fragmentContainer, mMemberFragment, MemberFragment.class.getName()).commit();
            } else {
                getFragmentManager().beginTransaction().show(mMemberFragment).commit();
            }
        }

        public void onAddDescriptionClick(View view) {
            view.setSelected(true);
        }
    }
}
