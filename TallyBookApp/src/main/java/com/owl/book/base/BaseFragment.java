package com.owl.book.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class BaseFragment<T extends ViewDataBinding> extends Fragment {

    private static final String TAG = "BaseFragment";

    protected T mBinding;

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

    protected void startActivityForResult(Class className, int requestCode) {
        startActivityForResult(new Intent(getActivity(), className), requestCode);
    }

    protected void finish() {
        getActivity().finish();
    }

    protected void finishWithResult(int code, Intent intent) {
        getActivity().setResult(code, intent);
        getActivity().finish();
    }

    protected void d(String msg) {
        Log.d(TAG, msg);
    }

    protected void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    protected void i(String msg) {
        Log.i(TAG, msg);
    }

    protected void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    protected void v(String msg) {
        Log.v(TAG, msg);
    }

    protected void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    protected void e(String msg) {
        Log.e(TAG, msg);
    }

    protected void e(String tag, String msg) {
        Log.e(tag, msg);
    }
}
