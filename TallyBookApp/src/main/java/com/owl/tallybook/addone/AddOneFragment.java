package com.owl.tallybook.addone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.owl.tallybook.R;
import com.owl.tallybook.addone.model.OneTally;
import com.owl.tallybook.addone.model.TallyItem;
import com.owl.tallybook.base.BaseFragment;
import com.owl.tallybook.databinding.FragmentAddOneBinding;

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
        int[] earnListImg = getContext().getResources().getIntArray(R.array.earn_list_drawable);
        String[] earnListName = getContext().getResources().getStringArray(R.array.earn_list_name);
        for (int i = 0; i < earnListName.length; i++) {
            earnList.add(new TallyItem(earnListName[i], earnListImg[i]));
        }
        mAdapter.setEarnList(earnList);

        List<TallyItem> payList = new ArrayList<>();
        int[] payListImg = getContext().getResources().getIntArray(R.array.pay_list_drawable);
        String[] payListName = getContext().getResources().getStringArray(R.array.payment_list_name);
        for (int i = 0; i < payListName.length; i++) {
            payList.add(new TallyItem(payListName[i], payListImg[i]));
        }
        mAdapter.setPayList(payList);
        mAdapter.setEarn(false);
        mMoney = new StringBuilder("0.00");
        mOneTally.setMoney(mMoney.toString());
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

    public class Presenter {

        public void onSelectTabClicked(View view) {
            if (view == mTvEarn) {
                mTvEarn.setSelected(true);
                mTvPay.setSelected(false);
                mOneTally.setSelectEarn(true);
                mAdapter.setEarn(true);
            } else if (view == mTvPay) {
                mTvPay.setSelected(true);
                mTvEarn.setSelected(false);
                mOneTally.setSelectPay(true);
                mAdapter.setEarn(false);
            }
        }

        public void onCloseClick() {
            finish();
        }

        public void onKeyboardNumClick(String value) {
            System.out.println(value);
        }
    }
}
