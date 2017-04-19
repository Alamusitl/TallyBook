package com.owl.tallybook.base;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by Alamusi on 2017/4/19.
 */

public abstract class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";

    public abstract boolean onBackPressed();

    protected void startActivity(Class className) {
        startActivity(new Intent(getActivity(), className));
    }

    protected void finish() {
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
