package com.owl.tallybook.addone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.owl.tallybook.addone.model.TallyItem;
import com.owl.tallybook.databinding.ViewTallyTypeItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class TallyTypeAdapter extends RecyclerView.Adapter<TallyTypeAdapter.TallyItemViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<TallyItem> mInComeList;
    private List<TallyItem> mPayList;
    private boolean mIsInCome;

    public TallyTypeAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mInComeList = new ArrayList<>();
        mPayList = new ArrayList<>();
        mIsInCome = false;
    }

    @Override
    public TallyItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TallyItemViewHolder(ViewTallyTypeItemBinding.inflate(mLayoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(TallyItemViewHolder holder, int position) {
        TallyItem item = getItem(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        if (mIsInCome) {
            return mInComeList.isEmpty() ? 0 : mInComeList.size();
        } else {
            return mPayList.isEmpty() ? 0 : mPayList.size();
        }
    }

    private TallyItem getItem(int position) {
        if (mIsInCome) {
            return mInComeList.get(position);
        } else {
            return mPayList.get(position);
        }
    }

    public List<TallyItem> getInComeList() {
        return mInComeList;
    }

    public void setInComeList(List<TallyItem> inComeList) {
        mInComeList = inComeList;
    }

    public List<TallyItem> getPayList() {
        return mPayList;
    }

    public void setPayList(List<TallyItem> payList) {
        mPayList = payList;
    }

    public boolean isInCome() {
        return mIsInCome;
    }

    public void setInCome(boolean inCome) {
        mIsInCome = inCome;
    }

    class TallyItemViewHolder extends RecyclerView.ViewHolder {

        private ViewTallyTypeItemBinding mItemBinding;

        TallyItemViewHolder(ViewTallyTypeItemBinding binding) {
            super(binding.getRoot());
            mItemBinding = binding;
        }

        public void bind(TallyItem item) {
            mItemBinding.setTallyItem(item);
            mItemBinding.executePendingBindings();
        }
    }
}
