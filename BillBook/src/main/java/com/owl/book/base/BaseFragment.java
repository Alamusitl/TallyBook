package com.owl.book.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.owl.book.util.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All Fragment based on an BaseFragment in this module
 * Created by Alamusi on 2017/4/19.
 */

public class BaseFragment<T extends ViewDataBinding> extends Fragment implements FragmentEventListener {

    private static final String TAG = "BaseFragment";
    private static Map<String, List<FragmentEventListener>> mEventListenerMap = new HashMap<>();

    protected T mBinding;

    protected void registerEventListener() {
        if (mEventListenerMap.containsKey(getClass().getName())) {
            mEventListenerMap.get(getClass().getName()).add(this);
        } else {
            List<FragmentEventListener> list = new ArrayList<>();
            list.add(this);
            mEventListenerMap.put(getClass().getName(), list);
        }
    }

    protected void unregisterEventListener() {
        if (mEventListenerMap.containsKey(getClass().getName())) {
            List<FragmentEventListener> list = mEventListenerMap.get(getClass().getName());
            if (list == null || list.isEmpty() || !list.contains(this)) {
                return;
            }
            mEventListenerMap.get(getClass().getName()).remove(this);
        }
    }

    protected T instanceBinding(LayoutInflater inflater, int layoutId, ViewGroup container) {
        mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        return mBinding;
    }

    protected T getBinding() {
        return mBinding;
    }

    protected boolean onBackPressed() {
        return false;
    }

    protected void startActivity(Class className) {
        startActivity(new Intent(getActivity(), className));
    }

    protected void finish() {
        getActivity().finish();
    }

    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public void dismiss(String target, Bundle extras) {
        LogUtil.i(getClass().getSimpleName(), "dismiss callback!");
        List<FragmentEventListener> list = mEventListenerMap.get(target);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            FragmentEventListener listener = list.get(i);
            listener.handleDismiss(getName(), extras);
        }
    }

    @Override
    public void handleDismiss(String src, Bundle extras) {
        LogUtil.i(getClass().getSimpleName(), "handled dismiss callback from " + src + "!");
    }
}
