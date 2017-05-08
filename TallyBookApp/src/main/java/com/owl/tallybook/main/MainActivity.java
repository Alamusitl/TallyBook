package com.owl.tallybook.main;

import android.support.v4.app.Fragment;

import com.owl.tallybook.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

}
