package com.owl.book.main;

import android.support.v4.app.Fragment;

import com.owl.book.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

}
