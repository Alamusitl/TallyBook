package com.owl.book;

import android.support.v4.app.Fragment;

import com.owl.book.base.BaseActivity;

/**
 * Created by Imagine Owl on 2017/5/18.
 */

public class ChooseActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new ChooseFragment();
    }
}
