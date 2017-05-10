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
import com.owl.tallybook.addone.model.OneTally;
import com.owl.tallybook.base.BaseFragment;
import com.owl.tallybook.databinding.FragmentAddOneBinding;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class AddOneFragment extends BaseFragment<FragmentAddOneBinding> {

    private TextView mTvIncome;
    private TextView mTvPayment;

    private Presenter mPresenter;
    private OneTally mOneTally;

    private TallyTypeAdapter mAdapter;

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

        mTvIncome = mBinding.idAddIncome;
        mTvPayment = mBinding.idAddPayment;
        mTvPayment.setSelected(true);

        RecyclerView recyclerView = mBinding.idAddRecyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));

        mAdapter = new TallyTypeAdapter(getContext());
        recyclerView.setAdapter(mAdapter);
    }

    public class Presenter {

        public void onSelectTabClicked(View view) {
            if (view == mTvIncome) {
                mTvIncome.setSelected(true);
                mTvPayment.setSelected(false);
                mOneTally.setSelectGet(true);
                mAdapter.setInCome(true);
                mAdapter.notifyDataSetChanged();
            } else if (view == mTvPayment) {
                mTvPayment.setSelected(true);
                mTvIncome.setSelected(false);
                mOneTally.setSelectPay(true);
                mAdapter.setInCome(false);
                mAdapter.notifyDataSetChanged();
            }
        }

        public void onCloseClick() {
            finish();
        }
    }
}
