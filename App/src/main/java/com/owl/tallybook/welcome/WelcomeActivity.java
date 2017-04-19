package com.owl.tallybook.welcome;

import android.support.v4.app.Fragment;

import com.owl.tallybook.base.BaseActivity;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class WelcomeActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new WelcomeFragment();
    }

}
