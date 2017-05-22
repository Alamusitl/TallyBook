package com.owl.book.tally;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.book.databinding.ViewTallyTypeItemBinding;
import com.owl.book.recycler.BindingViewHolder;
import com.owl.book.tally.model.TallyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class TallyTypeItemAdapter extends RecyclerView.Adapter<TallyTypeItemAdapter.TallyItemViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<TallyItem> mEarnList;
    private List<TallyItem> mPayList;
    private List<TallyItem> mShowItemList;
    private boolean mIsEarn;

    private OnItemClickListener mOnItemClickListener;

    public TallyTypeItemAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mEarnList = new ArrayList<>();
        mPayList = new ArrayList<>();
        mShowItemList = new ArrayList<>();
    }

    @Override
    public TallyItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TallyItemViewHolder(ViewTallyTypeItemBinding.inflate(mLayoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(TallyItemViewHolder holder, int position) {
        TallyItem item = mShowItemList.get(position);
        holder.bind(item);
        if (mOnItemClickListener != null) {
            setUpItemEvent(holder);
        }
    }

    @Override
    public int getItemCount() {
        return mShowItemList.isEmpty() ? 0 : mShowItemList.size();
    }

    private void setUpItemEvent(final TallyItemViewHolder holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, holder.getAdapterPosition());
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mOnItemClickListener.onItemLongClick(v, holder.getAdapterPosition());
                return false;
            }
        });
    }

    List<TallyItem> getEarnList() {
        return mEarnList;
    }

    void setEarnList(List<TallyItem> earnList) {
        mEarnList = earnList;
    }

    List<TallyItem> getPayList() {
        return mPayList;
    }

    void setPayList(List<TallyItem> payList) {
        mPayList = payList;
    }

    boolean isEarn() {
        return mIsEarn;
    }

    void setEarn(boolean earn) {
        mIsEarn = earn;
        if (earn) {
            mShowItemList = mEarnList;
        } else {
            mShowItemList = mPayList;
        }
        notifyDataSetChanged();
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, 0);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    class TallyItemViewHolder extends BindingViewHolder<ViewTallyTypeItemBinding> {

        TallyItemViewHolder(ViewTallyTypeItemBinding binding) {
            super(binding);
        }

        public void bind(TallyItem item) {
            mBinding.setTallyItem(item);
            mBinding.executePendingBindings();
        }
    }
}
