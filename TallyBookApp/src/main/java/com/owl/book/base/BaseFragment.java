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
    private static Map<Class, List<FragmentEventListener>> mEventListenerMap = new HashMap<>();

    protected T mBinding;

    protected void registerEventListener(Class fragment, FragmentEventListener listener) {
        if (mEventListenerMap.containsKey(fragment)) {
            mEventListenerMap.get(fragment).add(listener);
        } else {
            List<FragmentEventListener> list = new ArrayList<>();
            list.add(listener);
            mEventListenerMap.put(fragment, list);
        }
    }

    protected void unregisterEventListener(Class fragment, FragmentEventListener listener) {
        if (mEventListenerMap.containsKey(fragment)) {
            List<FragmentEventListener> list = mEventListenerMap.get(fragment);
            if (list == null || list.isEmpty() || !list.contains(listener)) {
                return;
            }
            mEventListenerMap.get(fragment).remove(listener);
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

    @Override
    public void dismiss(Class clz, Fragment fragment, Bundle bundle) {
        LogUtil.i(TAG, "base fragment dismiss called.");
        List<FragmentEventListener> list = mEventListenerMap.get(clz);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            FragmentEventListener listener = list.get(i);
            listener.dismiss(clz, fragment, bundle);
        }
    }
}
