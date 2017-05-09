package com.owl.tallybook.addone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.owl.tallybook.R;
import com.owl.tallybook.base.BaseFragment;
import com.owl.tallybook.databinding.FragmentAddOneBinding;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class AddOneFragment extends BaseFragment<FragmentAddOneBinding> {

    private TextView mTvIncome;
    private TextView mTvPayment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_add_one, container);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTvIncome = mBinding.idAddIncome;
        mTvPayment = mBinding.idAddPayment;
        mTvPayment.setActivated(true);

        RecyclerView recyclerView = mBinding.idAddRecyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        recyclerView.setAdapter(new RecyclerViewAdapter());
    }

    public class Presenter {
        public void onInComeClick() {
            if (mTvPayment.isActivated()) {
                mTvPayment.setActivated(false);
            }
            if (!mTvIncome.isActivated()) {
                mTvIncome.setActivated(true);
            }
        }

        public void onPaymentClick() {
            if (mTvIncome.isActivated()) {
                mTvIncome.setActivated(false);
            }
            if (!mTvPayment.isActivated()) {
                mTvPayment.setActivated(true);
            }
        }

        public void onCloseClick() {
            finish();
        }
    }
}
