package com.owl.book.recycler;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imagine Owl on 2017/5/18.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder> {

    protected LayoutInflater mInflater;
    private List<T> mDataList;
    private OnItemClickListener mItemClickListener;

    public BaseRecyclerAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mDataList = new ArrayList<>();
    }

    @Override
    public abstract BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    @CallSuper
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mDataList.get(position));
        if (mItemClickListener != null) {
            setUpItemEvent(holder);
        }
    }

    @Override
    @CallSuper
    public int getItemCount() {
        return mDataList.size();
    }

    private void setUpItemEvent(final BaseViewHolder holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItemClickListener().onItemClick(v, holder.getAdapterPosition());
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                getItemClickListener().onItemLongClick(v, holder.getAdapterPosition());
                return false;
            }
        });
    }

    public List<T> getDataList() {
        return mDataList;
    }

    public void setDataList(List<T> dataList) {
        mDataList = dataList;
    }

    public OnItemClickListener getItemClickListener() {
        return mItemClickListener;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    protected abstract class BaseViewHolder<BindingT extends ViewDataBinding> extends BindingViewHolder {

        public BaseViewHolder(BindingT binding) {
            super(binding);
        }

        public abstract void bind(T data);
    }
}
